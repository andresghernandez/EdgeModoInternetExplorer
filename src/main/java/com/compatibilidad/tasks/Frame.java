package com.compatibilidad.tasks;

import java.util.concurrent.TimeUnit;

import com.compatibilidad.interactions.WaitToLoad;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static com.compatibilidad.userinterfaces.LoginUserInterface.*;

public class Frame implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		actor.attemptsTo(WaitToLoad.theMiliSeconds(10));
		BrowseTheWeb.as(actor).getDriver().switchTo().frame(IFRAME.resolveFor(actor));
		actor.attemptsTo(JavaScriptClick.on(IMAGEN));
		BrowseTheWeb.as(actor).getDriver().switchTo().defaultContent();
		//actor.attemptsTo(WaitToLoad.theMiliSeconds(10));
		actor.attemptsTo(JavaScriptClick.on(BUTTON_HOME));
		//actor.attemptsTo(WaitToLoad.theMiliSeconds(10));
	}

	public static Frame inThePage() {
		return Tasks.instrumented(Frame.class);
	}
}
