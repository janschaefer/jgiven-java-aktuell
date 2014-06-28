package com.tngtech.jgiven.javaaktuell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class WennRegistrierungsSeite extends Schritte<WennRegistrierungsSeite> {
	@ExpectedScenarioState
	WebDriver webDriver;

	public WennRegistrierungsSeite der_Kunde_auf_den_Registrieren_Knopf_drückt() {
		webDriver.findElement(By.id("registrierenButton")).click();
		return self();
	}
}
