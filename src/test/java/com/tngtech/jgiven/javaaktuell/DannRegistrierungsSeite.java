package com.tngtech.jgiven.javaaktuell;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.NotImplementedYet;
import com.tngtech.jgiven.lang.de.Stufe;

public class DannRegistrierungsSeite<SELF extends DannRegistrierungsSeite<?>> extends Stufe<SELF> {
    @ExpectedScenarioState
    WebDriver webDriver;

    @ExpectedScenarioState
    RegistrierungsSeite registrierungsSeite;

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

        assertThat( registrierungsSeite.fehlerMeldung.getText() )
            .isEqualTo( fehlerMeldung );
        return self();
    }

    public SELF lambdaTest( int x ) {
        new Thread( () -> { System.out.println(); } );
        return self();
    }

    public SELF ist_der_Kunde_registriert() {
        // entsprechend implementieren
        return self();
    }

    @NotImplementedYet
    public SELF der_Kunde_erhält_eine_Bestätigungsemail() {
        // entsprechend implementieren
        return self();
    }

    public SELF der_Kunde_ist_nicht_registriert() {
        return self();
    }

}
