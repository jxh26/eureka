package com.cloud.bean;

import org.springframework.beans.factory.FactoryBean;

public class RunnableBean implements FactoryBean<Runnable>{

	@Override
	public Runnable getObject() throws Exception {
		// TODO Auto-generated method stub
		return () -> {};
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return FactoryBean.super.isSingleton();
	}

	

}
