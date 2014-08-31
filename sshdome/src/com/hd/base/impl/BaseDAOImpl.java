package com.hd.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hd.base.IBaseDAO;

public class BaseDAOImpl implements IBaseDAO {

	@Resource
	private SessionFactory sf;
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void add(Object o) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(o);
	}

	public void deleteById(Class c, int id) {
		// TODO Auto-generated method stub
		Object o = this.hibernateTemplate.load(c, id);
		if (o != null) {
			this.hibernateTemplate.delete(o);
		}
	}

	public void update(Object o) {
		this.hibernateTemplate.update(o);
	}

	public Object selectObject(Class c, int id) {
		return this.hibernateTemplate.get(c, id);
	}

	public List selectByHql(String hql) {
		return this.hibernateTemplate.find(hql);
	}

	public List selectBySql(String sql, String[] args) {
		return this.jdbcTemplate.queryForList(sql, args);
	}
	
	public int selectBySql(String sql) {
		return this.jdbcTemplate.queryForInt(sql);
	}

	public List getListForPage(final String hql, final int offset,final int length) {
		List list = hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

}
