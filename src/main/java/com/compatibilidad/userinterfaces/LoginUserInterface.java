package com.compatibilidad.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class LoginUserInterface {

	public static final Target INPUT_USER = Target.the("input user").
			located(By.xpath("//input[@name='userName']"));
	public static final Target INPUT_PASSWORD = Target.the("input paswword").
			located(By.xpath("//input[@name='password']"));
	public static final Target BUTTON_SUBMIT = Target.the("button submit").
			located(By.xpath("//input[@name='submit']"));
	public static final Target BUTTON_SIGN_OFF = Target.the("button sign off").
			located(By.xpath("//td/a[contains(text(), 'SIGN-OFF')]"));
	
	//frame
	public static final Target IFRAME = Target.the("iframe").
			located(By.xpath("//iframe[@id='a077aa5e']"));
	public static final Target IMAGEN = Target.the("imagen").
			located(By.xpath("//html/body/a/img"));
	public static final Target BUTTON_HOME = Target.the("button home").
			located(By.xpath("//li/a[contains(text(), 'Home')]"));
	
	
}
