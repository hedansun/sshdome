package com.hd.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Controller;

import com.hd.bean.User;
import com.hd.service.ILoginService;
import com.hd.service.TFBaseService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author hed
 * Jun 25, 2013
 */
@Controller
@ParentPackage("default")
public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private String validateCode;
	
	//图片流
	private ByteArrayInputStream imageStream;
	
	private String backUrl;
	
	@Resource(name="loginServiceImpl")
	private ILoginService iLoginService;
	
	/**
	@Action(value = "/user/login",results = {
			@Result(name = "success",type="redirect", location = "${backUrl}"),
			@Result(name = "input", location = "/page/login/login.jsp")})
	public String login() throws Exception {
		if("1".equals(name) && "1".equals(password)){
			ServletActionContext.getRequest().getSession().setAttribute("name", name);
			backUrl=ServletActionContext.getRequest().getSession().getAttribute("backUrl")+"";
			if(!"null".equals(backUrl)){
				ServletActionContext.getRequest().getSession().removeAttribute("backUrl");
				backUrl="/page/home.jsp";//登录拦截没有全部完成,暂时跳转到首页
				return "success";
			}else{
				//backUrl="/page/home.jsp";
				backUrl="/home";
				return "success";
			}
		}else{
			return "input";
		}
	}
	**/
	
	//0:登录成功,1:用户名不存在,2:密码错误
	@Action(value = "/user/login")
	public void login() throws Exception {
		String result="";
		int i = this.iLoginService.getUserEmail(user.getEmail());
		if(i>0){
			String userPassword=this.iLoginService.getUserPassword(user.getEmail());
			if(userPassword.equals(user.getPassword())){
				ServletActionContext.getRequest().getSession().setAttribute("userEmail", user.getEmail());
				result="0";
			}else{
				result="2";
			}
		}else{
			result="1";
		}
		ServletActionContext.getResponse().setContentType("text/html");
		ServletActionContext.getResponse().getWriter().print(result);
	}
	
	//0:成功,1:验证码错误,2:账号存在
	@Action(value="/user/register")
	public void register() throws Exception{
		String result = "";
		String validateImageCode=ServletActionContext.getRequest().getSession().getAttribute("validateImageCode")+"";
		if(!validateCode.equals(validateImageCode)){
			result="1";
		}else{
			int i = this.iLoginService.getUserEmail(user.getEmail());
			if(i>0){
				result="2";
			}else{
				this.iLoginService.register(user);
				ServletActionContext.getRequest().getSession().setAttribute("userEmail", user.getEmail());
				result="0";
			}
			
		}
		ServletActionContext.getResponse().setContentType("text/html");
		ServletActionContext.getResponse().getWriter().print(result);
	}
	
	@Action(value="/user/validateImageCode",results={@Result(name="success",type="streamx",
			params={"contentType","image/jpeg",
			"inputName","imageStream",
			"bufferSize","4096"})})
	public String validateImageCode(){
		//如果开启Hard模式，可以不区分大小写
		//String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
		//获取默认难度和长度的验证码
		String securityCode = this.getSecurityCode();
		imageStream = this.getImageAsInputStream(securityCode);
		//放入session中
		ServletActionContext.getRequest().getSession().removeAttribute("validateImageCode");
		ServletActionContext.getRequest().getSession().setAttribute("validateImageCode", securityCode);
		return "success";
	}
	
	/**
     * 产生长度和难度任意的验证码
     * @param length  长度
     * @param level   难度级别
     * @param isCanRepeat  是否能够出现重复的字符，如果为true，则可能出现 5578这样包含两个5,如果为false，则不可能出现这种情况
     * @return  String 验证码
     */
	public String getSecurityCode(int length,SecurityCodeLevel level,boolean isCanRepeat){
		//随机抽取len个字符
        int len=length;
        
        //字符集合(除去易混淆的数字0、数字1、字母l、字母o、字母O)
        char[] codes={'1','2','3','4','5','6','7','8','9',
                      'a','b','c','d','e','f','g','h','i',
                      'j','k','m','n','p','q','r','s','t',
                      'u','v','w','x','y','z','A','B','C',
                      'D','E','F','G','H','I','J','K','L',
                      'M','N','P','Q','R','S','T','U','V',
                      'W','X','Y','Z'};
        
        //根据不同的难度截取字符数组
        if(level==SecurityCodeLevel.Simple){
            codes=Arrays.copyOfRange(codes, 0,9);
        }else if(level==SecurityCodeLevel.Medium){
            codes=Arrays.copyOfRange(codes, 0,33);
        }
        
        //字符集合长度
        int n=codes.length;
        
        //抛出运行时异常
        if(len>n&&isCanRepeat==false){
            throw new RuntimeException(
                    String.format("调用SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)出现异常，" +
                                   "当isCanRepeat为%3$s时，传入参数%1$s不能大于%4$s",
                                   len,level,isCanRepeat,n));
        }
        
        //存放抽取出来的字符
        char[] result=new char[len];
        
        //判断能否出现重复的字符
        if(isCanRepeat){
            for(int i=0;i<result.length;i++){
                //索引 0 and n-1
                int r=(int)(Math.random()*n);
            
                //将result中的第i个元素设置为codes[r]存放的数值
                result[i]=codes[r];
            }
        }else{
            for(int i=0;i<result.length;i++){
                //索引 0 and n-1
                int r=(int)(Math.random()*n);
                
                //将result中的第i个元素设置为codes[r]存放的数值
                result[i]=codes[r];
                
                //必须确保不会再次抽取到那个字符，因为所有抽取的字符必须不相同。
                //因此，这里用数组中的最后一个字符改写codes[r]，并将n减1
                codes[r]=codes[n-1];
                n--;
            }
        }
        
        return String.valueOf(result);
	}
	
	/**
     * 验证码难度级别，Simple只包含数字，Medium包含数字和小写英文，Hard包含数字和大小写英文
     */
    public enum SecurityCodeLevel {Simple,Medium,Hard};
	 /**
     * 产生默认验证码，4位中等难度
     * @return  String 验证码
     */
    public String getSecurityCode(){
        return getSecurityCode(4,SecurityCodeLevel.Medium,false);
    }
	
    /**
     * 返回验证码图片的流格式
     * @param securityCode  验证码
     * @return ByteArrayInputStream 图片流
     */
    public ByteArrayInputStream getImageAsInputStream(String securityCode){
        
        BufferedImage image = createImage(securityCode);
        return convertImageToStream(image);
    }
    
    /**
     * 将BufferedImage转换成ByteArrayInputStream
     * @param image  图片
     * @return ByteArrayInputStream 流
     */
    private static ByteArrayInputStream convertImageToStream(BufferedImage image){
        
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
        try {
            jpeg.encode(image);
            byte[] bts = bos.toByteArray();
            inputStream = new ByteArrayInputStream(bts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }
    
    public BufferedImage createImage(String securityCode){
    	//验证码长度
        int codeLength=securityCode.length();
        //字体大小
        int fSize = 15;
        int fWidth = fSize + 1;
        //图片宽度
        int width = codeLength * fWidth + 6 ;
        //图片高度
        int height = fSize * 2 + 1;
        
        //图片
        BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g=image.createGraphics();
        
        //设置背景色
        g.setColor(Color.WHITE);
        //填充背景
        g.fillRect(0, 0, width, height);
        
        //设置边框颜色
        g.setColor(Color.LIGHT_GRAY);
        //边框字体样式
        g.setFont(new Font("Arial", Font.BOLD, height - 2));
        //绘制边框
        g.drawRect(0, 0, width - 1, height -1);
        
        
        //绘制噪点
        Random rand = new Random();
        //设置噪点颜色
        g.setColor(Color.LIGHT_GRAY);
        for(int i = 0;i < codeLength * 6;i++){
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            //绘制1*1大小的矩形
            g.drawRect(x, y, 1, 1);
        }
        
        //绘制验证码
        int codeY = height - 10;  
        //设置字体颜色和样式
        g.setColor(new Color(19,148,246));
        g.setFont(new Font("Georgia", Font.BOLD, fSize));
        for(int i = 0; i < codeLength;i++){
            g.drawString(String.valueOf(securityCode.charAt(i)), i * 16 + 5, codeY);
        }
        //关闭资源
        g.dispose();
        
        return image;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	
}
