package com.helpet.exception;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DaoException extends Exception
{

	Logger log = Logger.getLogger(DaoException.class);
	//URL url = this.getClass().getResource("../log4j.properties");
	
	public DaoException(String message, Throwable cause) 
	{	
		super(message, cause);
		//PropertyConfigurator.configure(url);	
		log.error(message);
	}

	public DaoException(Throwable cause)
	{
		super(cause);
		//PropertyConfigurator.configure(url);
		log.error(cause.getMessage());
	}
	
	public DaoException(String message)
	{
		super(message);
		//PropertyConfigurator.configure(url);
		log.error(message);
	}
}
