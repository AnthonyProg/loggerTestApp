package com.log.logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

import com.log.logger.enumeration.LogTypes;
import com.log.logger.factory.LogStrategyFactory;
import com.log.logger.strategy.ErrorLog;


public class LogStrategyFactoryTest {
	
	@Mock
	private ApplicationContext context;
	
	private LogStrategyFactory strategyFactory;
	
	private Map<String, Object> classesWithAnnotation = new HashMap<>();
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		classesWithAnnotation.put("errorLog", Mockito.mock(ErrorLog.class));
		when(context.getBeansWithAnnotation(anyObject())).thenReturn(classesWithAnnotation);
		strategyFactory = new LogStrategyFactory(context);
	}
	
	@Test
	public void getStrategiesTest() {
		Set<LogTypes> strategies = strategyFactory.getStrategies();
		assertTrue(strategies.contains(LogTypes.ERROR));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getLoggerStrategyTest() {		
		assertThat(strategyFactory.getLoggerStrategy(LogTypes.ERROR).get()).isInstanceOf(ErrorLog.class);
	}
	
}
