package com.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hd.bean.TFBase;
import com.hd.dao.TFBaseDAO;
import com.hd.dao.impl.TFBaseDAOImpl;
import com.hd.service.TFBaseService;

/**
 * @author hed
 * Jun 7, 2013
 */
@Service
public class TFBaseServiceImpl implements TFBaseService {
	
	@Resource(name="TFBaseDAOImpl")
	private TFBaseDAO tFBaseDAO;
	
//	public void add(TFBase TFBase){
//		this.tFBaseDAO.add(TFBase);
//	}
	
	
//	public void deleteObjectById(int id){
//		this.tFBaseDAO.deleteObjectById(id);
//	}
	
	public List<TFBase> selectAll2(){
		return this.tFBaseDAO.selectAll2();
	}
	
//	public List selectAllBySql(String sql,String [] args){
//		return this.tFBaseDAO.selectAllBySql(sql,args);
//	}
	
//	public void testTransactional(TFBase TFBase){
//		this.add(TFBase);
//		this.deleteObjectById(2082);
//		//this.deleteTFBaseById(-1);
//	}
	
//	public String userLogin(String name,String password){
//		return this.tFBaseDAO.userLogin(name,password);
//	}
}
