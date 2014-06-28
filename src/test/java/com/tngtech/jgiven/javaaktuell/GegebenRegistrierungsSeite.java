package com.tngtech.jgiven.javaaktuell;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.tngtech.jgiven.annotation.AfterScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class GegebenRegistrierungsSeite extends
		Schritte<GegebenRegistrierungsSeite> {
	@ProvidedScenarioState
	WebDriver webDriver = new HtmlUnitDriver(true);

	@ProvidedScenarioState
	String email = "testuser@test.com";

	@ProvidedScenarioState
	String passwort = "Passwort1234!$";

	public GegebenRegistrierungsSeite die_Registrierungsseite_ist_geöffnet()
			throws Exception {
		File file = new File("src/main/resources/webshop/registrierung.html");
		webDriver.get(file.toURI().toURL().toString());
		return self();
	}

	public GegebenRegistrierungsSeite eine_valide_Email_ist_angegeben() {
		webDriver.findElement(By.id("emailInput")).sendKeys(email);
		return self();

	}

	public GegebenRegistrierungsSeite ein_valides_Passwort_ist_angegeben() {
		webDriver.findElement(By.id("passwortInput")).sendKeys(passwort);
		return self();
	}

	public GegebenRegistrierungsSeite als_Email_ist_$_angegeben(String email) {
		this.email = email;
		webDriver.findElement(By.id("emailInput")).sendKeys(email);
		return self();
	}

	@AfterScenario
	public void closeBrowser() {
		webDriver.close();
	}
}
