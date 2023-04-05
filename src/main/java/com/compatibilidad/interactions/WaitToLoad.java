package com.compatibilidad.interactions;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Screenshots;

public class WaitToLoad implements Interaction {
	private int seconds;
	Logger logger  = Logger.getLogger(WaitToLoad.class.getName());	
	
	public WaitToLoad(int seconds) {
		this.seconds = seconds;
	}

	@Override
	@Screenshots(disabled=true)
	public <T extends Actor> void performAs(T actor) {
		try {
			Thread.sleep(seconds);
		} catch (Exception e) {
			logger.log(Level.INFO, e.getMessage());
		}
	}
	@Screenshots(disabled=true)
	public static WaitToLoad theMiliSeconds(int seconds) {
		return Tasks.instrumented(WaitToLoad.class, seconds);
	}
}
