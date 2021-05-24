package com.melot.kk.darkLaunch;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class DarkLaunchApplicationContextInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		// Set ApplicationContext into SpringCloudRegistryFactory before Dubbo Service
		// Register
		DarkLaunchLoadBalance.setApplicationContext(applicationContext);
	}

}