package com.utility;
// this is a singleton class follows singleton Design pattern
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	private static Logger logger;

	private LoggerUtility() {
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null;
		if(logger == null) {
		logger = LogManager.getLogger(clazz);
		}
		
		return logger;
		
	}
	
}
