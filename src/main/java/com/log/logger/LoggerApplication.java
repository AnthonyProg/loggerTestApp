package com.log.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.log.logger.enumeration.LogTypes;
import com.log.logger.exception.LoggerStrategyNotFound;
import com.log.logger.factory.LogStrategyFactory;


@SpringBootApplication
@ComponentScan(basePackages = "com.log.logger")
public class LoggerApplication {
	
	@Autowired
	public static LogStrategyFactory strategy;
	
	public static final String NOT_FOUND_MESSAGE = "LOG STRATEGY NOT FOUND";
	
	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);		
		LogStrategyFactory.getLoggerStrategy(LogTypes.ERROR).orElseThrow(
				() -> new LoggerStrategyNotFound(NOT_FOUND_MESSAGE)).writeLog("Hello World");
	}

}
