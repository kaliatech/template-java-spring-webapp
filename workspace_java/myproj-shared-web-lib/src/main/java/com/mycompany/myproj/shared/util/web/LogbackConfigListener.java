package com.mycompany.myproj.shared.util.web;

import com.mycompany.myproj.shared.util.LogbackConfigurer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogbackConfigListener implements ServletContextListener {

  private LogbackConfigurer configurer;

  public void contextInitialized(ServletContextEvent event) {

    configurer = new LogbackConfigurer();

    String logbackConfigFilePath = event.getServletContext().getInitParameter("logbackConfigLocation");

    configurer.configure(logbackConfigFilePath);

  }

  public void contextDestroyed(ServletContextEvent event) {

    if (configurer != null) {
      configurer.destroy();
    }
  }

}
