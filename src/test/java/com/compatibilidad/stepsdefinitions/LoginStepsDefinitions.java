package com.compatibilidad.stepsdefinitions;

import org.openqa.selenium.WebDriver;

import com.compatibilidad.tasks.ControlActivex;
import com.compatibilidad.tasks.Frame;
import com.compatibilidad.tasks.Login;
import com.compatibilidad.tasks.OpenPage;
import com.compatibilidad.drivers.Driver;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import static com.compatibilidad.drivers.Driver.*;


public class LoginStepsDefinitions {

	private Actor actor = Actor.named("the");
	
	@Managed
	private WebDriver browser;
	
	@Before
	public void setTheStage(){
	    OnStage.setTheStage(new OnlineCast());
	}
	
	@Given("^Park necesita loguearse en la pagina$")
	public void parkNecesitaLoguearseEnLaPagina() {
		Driver.web();
		actor.can(BrowseTheWeb.with(browser));
		actor.wasAbleTo(OpenPage.website());
	}

	@When("^el envia los datos para loguearse$")
	public void elEnviaLosDatosParaLoguearse() {
		
		//actor.wasAbleTo(ControlActivex.inThePage());
		//actor.wasAbleTo(Frame.inThePage());
		
		actor.wasAbleTo(Login.inThePage());
		actor.wasAbleTo(Login.inThePage());
	}

	@Then("^el obtiene una respuesta exitosa$")
	public void elObtieneUnaRespuestaExitosa() {

	}

	
}
