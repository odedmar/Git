package com.carkyp.sequrity.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.caekyp.config.mongo.MongoConfig;
import com.carkyp.config.AppConfig;

//import config.mongo.MongoConfig;

public class MvcWebApplicationInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer  {

@Override
protected Class<?>[] getRootConfigClasses() {
return new Class[] { SecurityConfig.class, WebConfig.class ,AppConfig.class,MongoConfig.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
	// TODO Auto-generated method stub
	return null;
}

@Override
protected String[] getServletMappings() {
	// TODO Auto-generated method stub
	return new String[] { "/" };
}

// ... other overrides ...
}