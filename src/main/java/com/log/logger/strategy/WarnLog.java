package com.log.logger.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.log.logger.annotation.LoggerStrategy;
import com.log.logger.enumeration.LogTypes;
import com.log.logger.service.LoggerService;

@Component
@LoggerStrategy(LogTypes.WARNING)
public class WarnLog implements LoggerService {

	public static Logger log = LogManager.getLogger();
	
	@Override
	public void writeLog(String message) {
		log.warn(message);		
	}
}
