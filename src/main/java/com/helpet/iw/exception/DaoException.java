package com.helpet.iw.exception;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author Carlos Enrique Agudelo Giraldo
 * @email carloskikea@gmail.com
 * @description Managmet of personal exception in app generando message with the problem and registring this in "Auditoria.log"
 * @date 10/17/206 
 *
 */

public class DaoException extends Exception
{


	Logger log = Logger.getLogger(DaoException.class);
	//URL url = this.getClass().getResource("../log4j.properties");
	
	/**
	 * 
	 * @param message Mensaje personalizazo con el error que se presenta
	 * @param cause Mensaje generado por el compilador
	 */
	public DaoException(String message, Throwable cause) 
	{	
		super(message, cause);
		//PropertyConfigurator.configure(url);	
		log.error(message);
	}

	/**
	 * 
	 * @param cause Mensaje generado por el compilador
	 */
	public DaoException(Throwable cause)
	{
		super(cause);
		//PropertyConfigurator.configure(url);
		log.error(cause.getMessage());
	}
	
	/**
	 * 
	 * @param message Mensaje personalizado
	 */
	public DaoException(String message)
	{
		super(message);
		//PropertyConfigurator.configure(url);
		log.error(message);
	}
}
