package com.product.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;

import util.HibernateUtil;

@WebFilter(urlPatterns = { "/*" })  //urlPatterns濾器，可以過濾會員及非會員等
public class OpenSessionInViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {  //所以交易開始和結束都在濾器範圍裏面，搭配後端渲染的情況
			System.out.println("filter open transaction");
			factory.getCurrentSession().beginTransaction();  //提前在濾器前打開工廠
			chain.doFilter(req, res);  //濾器
			factory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();  //關閉工廠
			e.printStackTrace();
			chain.doFilter(req, res);  //關濾器
		}
	}

}



