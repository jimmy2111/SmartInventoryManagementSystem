package com.einfo.SmartInventoryManagement.Logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerImplementation {

	public static Logger getLogger(Class classname) {
		return LoggerFactory.getLogger(classname);
	}
}
