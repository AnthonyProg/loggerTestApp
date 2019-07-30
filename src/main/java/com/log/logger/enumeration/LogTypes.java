package com.log.logger.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum LogTypes {

	ERROR(1),

	INFO(2),

	DEBUG(3),

	WARNING(4),

	FATAL(5);

	private final Integer id;
	
	private static Map<Integer, LogTypes> valuesMap;
	
	static {
		valuesMap = new HashMap<>();
		
		for (LogTypes elem : values()) {
			valuesMap.put(elem.id, elem);	
		}
	}
	
	LogTypes(Integer id){
		this.id = id;
	}
	
	public static LogTypes getLogTypeEnum(Integer id) {
		return valuesMap.get(id);
	}

}
