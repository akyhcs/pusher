package com.mindtree.config;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig
{
	static 
	{
		PropertyConfigurator.configure("../pusher/src/main/resources/application.properties");
	}
	
}
