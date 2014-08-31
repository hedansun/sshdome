package com.hd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.base.impl.BaseDAOImpl;
import com.hd.bean.TFBase;
import com.hd.dao.TFBaseDAO;

/**
 * @author hed
 * Jun 7, 2013
 */
@Repository
public class TFBaseDAOImpl extends BaseDAOImpl implements TFBaseDAO{
	
	public String userLogin(String name,String password){
		return null;
	}
	
	public List<TFBase> selectAll2(){
		return null;
	}

//	public String userLogin(String name,String password){
//		String result="";
//		String isExistsName="";
//		String isExistsPassword="";
//		String nameSql="select * from t_districtuser t where t.loginname = '"+name+"'";
//		if(this.selectAllBySql(nameSql).size()!=0){
//			String passwordSql="select * from t_districtuser t where t.loginname = '"+name+"' and t.passwd='"+password+"'";
//			if(this.selectAllBySql(passwordSql).size()!=0){
//				result="2";
//			}else{
//				result="1";
//			}
//		}else{
//			result="0";
//		}
//		return result;
//		}
	
	
}
