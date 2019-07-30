package com.log.logger.annotation;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

import com.log.logger.enumeration.LogTypes; 

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface LoggerStrategy {
	
	LogTypes[] value();
}
