package com.compatibilidad.tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;

import com.compatibilidad.drivers.Driver;
import com.compatibilidad.interactions.WaitToLoad;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ControlActivex implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		//String url = "https://espanol.yahoo.com/?p=us&guccounter=1";
		//actor.whoCan(BrowseTheWeb.with(Driver.inThePageUrl(url)));
		
		//BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
		int wait = 0;
		boolean alertFound = false;
		do {
			wait = wait +1;
			alertFound = acceptAlert(actor);
			System.out.println("Esperando alerta "+wait);
		} while (wait<300 && !alertFound);
		
		BrowseTheWeb.as(actor).getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		actor.attemptsTo(WaitToLoad.theMiliSeconds(10));
	}

    public boolean acceptAlert(Actor actor) {
        try
        {
        	BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        	return true;
        }catch (Exception ex){
        	return false;
        }   
    } 
	
	public static ControlActivex inThePage() {
		return Tasks.instrumented(ControlActivex.class);
	}
	
}
