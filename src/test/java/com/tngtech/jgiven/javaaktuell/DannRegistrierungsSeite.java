package com.tngtech.jgiven.javaaktuell;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class DannRegistrierungsSeite<SELF extends DannRegistrierungsSeite<?>> extends Schritte<SELF> {
    @ExpectedScenarioState
    WebDriver webDriver;

    @ExpectedScenarioState
    String email;

    @ExpectedScenarioState
    String passwort;

    public SELF wird_die_Willkommensseite_geöffnet() {
        assertThat( webDriver.getTitle() ).isEqualTo( "Willkommen beim WebShop!" );
        return self();
    }

    public SELF wird_die_Registrierung_mit_der_Fehlermeldung_$_abgelehnt(
            String fehlerMeldung ) {
        assertThat( webDriver.findElement( By.id( "fehlerMeldung" ) ).getText() )
            .isEqualTo( fehlerMeldung );
        return self();
    }

    public SELF ist_der_Kunde_registriert() {
        // entsprechend implementieren
        return self();
    }

    public SELF der_Kunde_erhält_eine_Bestätigungsemail() {
        // entsprechend implementieren
        return self();
    }

    public SELF der_Kunde_ist_nicht_registriert() {
        return self();
    }

}
