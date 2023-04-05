package com.compatibilidad.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static com.compatibilidad.userinterfaces.LoginUserInterface.*;

import java.util.concurrent.TimeUnit;
import static com.compatibilidad.utils.Helpers.*;
import org.openqa.selenium.JavascriptExecutor;

import com.compatibilidad.interactions.WaitToLoad;
public class Login implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		/*actor.attemptsTo(Enter.keyValues("Prueba").into(INPUT_USER),
				Enter.keyValues("Hola").into(INPUT_USER));*/
		/*actor.attemptsTo(Enter.theValue("Prueba").into(INPUT_USER),
				Enter.theValue("Hola").into(INPUT_USER));*/
		//INPUT_USER.resolveFor(actor).sendKeys("Prueba");
		//INPUT_USER.resolveFor(actor).sendKeys("Hola");
		
		BrowseTheWeb.as(actor).getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		actor.attemptsTo(WaitToLoad.theMiliSeconds(10));
		waitSelenium(2);
		System.out.println(INPUT_USER.resolveFor(actor).isCurrentlyVisible());
		
		JavascriptExecutor jse = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
		jse.executeScript("arguments[0].value='"+ "admin" +"';", INPUT_USER.resolveFor(actor));
		jse.executeScript("arguments[0].value='"+ "123456" +"';", INPUT_PASSWORD.resolveFor(actor));
		actor.attemptsTo(WaitToLoad.theMiliSeconds(1));
		waitSelenium(1);
		actor.attemptsTo(JavaScriptClick.on(BUTTON_SUBMIT));
		waitSelenium(3);
		actor.attemptsTo(JavaScriptClick.on(BUTTON_SIGN_OFF));
	}

	public static Login inThePage() {
		return Tasks.instrumented(Login.class);
	}
	
}
