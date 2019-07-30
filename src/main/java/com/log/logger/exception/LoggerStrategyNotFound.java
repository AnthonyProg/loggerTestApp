package com.log.logger.exception;

public class LoggerStrategyNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803695754679221020L;
	
	public LoggerStrategyNotFound(String message) {
		super(message);
	}

}
