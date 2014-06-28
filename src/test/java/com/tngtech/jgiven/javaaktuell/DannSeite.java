package com.tngtech.jgiven.javaaktuell;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class DannSeite extends Schritte<DannSeite> {
    @ExpectedScenarioState
    WebDriver webDriver;

    @ExpectedScenarioState
    String email;

    @ExpectedScenarioState
    String passwort;

    public DannSeite wird_die_Willkommensseite_geöffnet() {
        assertEquals( "Willkommen beim WebShop!", webDriver.getTitle() );
        return self();
    }

    public DannSeite wird_die_Registrierung_mit_der_Fehlermeldung_$_abgelehnt( String fehlerMeldung ) {
        assertEquals( fehlerMeldung, webDriver.findElement( By.id( "fehlerMeldung" ) ).getText() );
        return self();
    }

    public DannSeite der_Kunde_ist_registriert() {
        // entsprechend implementieren
        return self();
    }

    public DannSeite der_Kunde_erhält_eine_Bestätigungsemail() {
        // entsprechend implementieren
        return self();
    }

    public DannSeite der_Kunde_ist_nicht_registriert() {
        return self();
    }

}
