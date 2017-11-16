package com.sampleproject;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
 
@Controller
public class AppContainerCustomizer {
	 public void customize(ConfigurableEmbeddedServletContainer container) {
		 container.setPort(9000);
	}

}
