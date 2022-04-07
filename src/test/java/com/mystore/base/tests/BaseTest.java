package com.mystore.base.tests;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * Groups common test methods
 * 
 *
 */

public class BaseTest {
	
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	@SuppressWarnings("unused")
	private String loggingMessage;
	@SuppressWarnings("unused")
	private Object[] loggingArgs;
	

  protected void startLogging(String message, Object... args) {
	  this.loggingMessage = message;
	  this.loggingArgs = args;
	  logger.info("***************************************************************");
	  logger.info(this.getClass().getSimpleName() + " " + message + "STARTED", args);
	  logger.info("                                                               ");
  }
  
  @SuppressWarnings("unused")
private void endLoggingPass(String message, Object... args) {
	  logger.info(this.getClass().getSimpleName() + " " + message + "PASSED", args);
	  logger.info("***************************************************************");
	  logger.info("");
  }
  
  @SuppressWarnings("unused")
private void endLoggingFail(String message, Object... args) {
	  logger.info(this.getClass().getSimpleName() + " " + message + "FAIL", args);
	  logger.info("***************************************************************");
	  logger.info("");
	  
  }
}
