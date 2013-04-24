package com.mycompany.myproj.shared.util;

import java.io.File;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackConfigurer {

  public void configure(String logbackConfigFilePath) {

    // assume SLF4J is bound to logback in the current environment
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

    try {

      // Bit of a hack for now
      logbackConfigFilePath.replace("${user.home}", System.getProperty("user.home"));
      logbackConfigFilePath.replace("${config.dir}", System.getProperty("config.dir"));

      File logbackConfigFile = new File(logbackConfigFilePath);
      if (!logbackConfigFile.exists()) {
        System.out.println("Specified logbackConfigLocation does not exist: " + logbackConfigFilePath);
        return;
      }

      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(context);

      // Call context.reset() to clear any previous configuration, e.g.
      // default
      // configuration. For multi-step configuration, omit calling
      // context.reset().
      context.reset();

      configurator.doConfigure(logbackConfigFile);

    } catch (JoranException je) {
      // StatusPrinter will handle this
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);

  }

  /**
   * Important/required to call this when app ends?
   */
  public void destroy() {
    // Check for logback implementation of slf4j
    ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
    if (loggerFactory instanceof LoggerContext) {
      LoggerContext context = (LoggerContext) loggerFactory;
      context.stop();
    }
  }

}
