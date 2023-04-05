package com.compatibilidad.tasks;

import com.compatibilidad.drivers.Driver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class OpenPage implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		String url = "https://sucursalpersonas.transaccionesbancolombia.com/mua/USER?scis=QnbeDCjCuXja5VN1WEokE8woYjMJczbZ49hUFproEZY%3D#no-back-button";
		actor.whoCan(BrowseTheWeb.with(Driver.inThePage(url)));
	}
	
	public static OpenPage website() {
		return Tasks.instrumented(OpenPage.class);
	}
	
}
