package com.tngtech.jgiven.javaaktuell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class DannRegistrierungsSeite extends Schritte<DannRegistrierungsSeite> {
	@ExpectedScenarioState
	WebDriver webDriver;

	@ExpectedScenarioState
	String email;

	@ExpectedScenarioState
	String passwort;

	public DannRegistrierungsSeite wird_die_Willkommensseite_geöffnet() {
		assertThat(webDriver.getTitle()).isEqualTo("Willkommen beim WebShop!");
		return self();
	}

	public DannRegistrierungsSeite wird_die_Registrierung_mit_der_Fehlermeldung_$_abgelehnt(
			String fehlerMeldung) {
		assertThat(webDriver.findElement(By.id("fehlerMeldung")).getText())
				.isEqualTo(fehlerMeldung);
		return self();
	}

	public DannRegistrierungsSeite ist_der_Kunde_registriert() {
		// entsprechend implementieren
		return self();
	}

	public DannRegistrierungsSeite der_Kunde_erhält_eine_Bestätigungsemail() {
		// entsprechend implementieren
		return self();
	}

	public DannRegistrierungsSeite der_Kunde_ist_nicht_registriert() {
		return self();
	}

}