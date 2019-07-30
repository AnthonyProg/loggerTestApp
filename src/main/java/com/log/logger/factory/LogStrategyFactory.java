package com.log.logger.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.log.logger.annotation.LoggerStrategy;
import com.log.logger.enumeration.LogTypes;
import com.log.logger.service.LoggerService;

@Component
public class LogStrategyFactory {
	
	/**
	 * an in memory map , is static just to show the example
	 */ 
	private static Map<LogTypes, LoggerService> strategyMemoryCache;

	@Autowired
	public LogStrategyFactory(ApplicationContext context) {
		strategyMemoryCache = new EnumMap<LogTypes, LoggerService>(LogTypes.class);
		Map<String , Object> annotatedBeanClasses = context.getBeansWithAnnotation(LoggerStrategy.class);
		
		for(Object bean : annotatedBeanClasses.values()) {
			LoggerStrategy strategy = AnnotationUtils.findAnnotation(bean.getClass(), LoggerStrategy.class);
			for(LogTypes logType : strategy.value()) {
				strategyMemoryCache.put(logType, (LoggerService) bean);
			}
		}
	}
	
	/**
	 * is static because I needed to use it in the main of the application 
	 * 
	 * @param logType
	 * @return an Optional of the desired strategy
	 */
	public static Optional<LoggerService> getLoggerStrategy(LogTypes logType){
		return Optional.ofNullable(strategyMemoryCache.get(logType));
	}
	
	public Set<LogTypes> getStrategies(){
		return strategyMemoryCache.keySet();
	}
}
