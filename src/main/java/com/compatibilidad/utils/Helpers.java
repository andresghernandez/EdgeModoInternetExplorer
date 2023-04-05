package com.compatibilidad.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Helpers {
	
	private Helpers() {}
	static Logger logger  = Logger.getLogger(Helpers.class.getName());
	
	public static void waitSelenium(int seconds) {
		try {
			Thread.sleep(seconds * (long) 1000);
		} catch (Exception e) {
			logger.log(Level.INFO, e.getMessage());
		}
	}
	
	public static boolean emptyOrNull(String palabra) {
		boolean esNuloOVacia = false;
		if (palabra == null || palabra.trim().isEmpty()) {
			esNuloOVacia = true;
		}
		return esNuloOVacia;
	}
}
