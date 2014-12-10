package com.tngtech.jgiven.javaaktuell;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.tngtech.jgiven.annotation.AfterScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.lang.de.Stufe;

public class GegebenRegistrierungsSeite<SELF extends GegebenRegistrierungsSeite<?>> extends
        Stufe<SELF> {
    @ProvidedScenarioState
    WebDriver webDriver = new HtmlUnitDriver( true );

    @ProvidedScenarioState
    String email = "testuser@test.com";

    @ProvidedScenarioState
    String passwort = "Passwort1234!$";

    public SELF die_Registrierungsseite_ist_geöffnet()
            throws Exception {
        File file = new File( "src/main/resources/webshop/registrierung.html" );
        webDriver.get( file.toURI().toURL().toString() );
        return self();
    }

    public SELF eine_valide_Email_ist_angegeben() {
        webDriver.findElement( By.id( "emailInput" ) ).sendKeys( email );
        return self();

    }

    public SELF ein_valides_Passwort_ist_angegeben() {
        webDriver.findElement( By.id( "passwortInput" ) ).sendKeys( passwort );
        return self();
    }

    public SELF als_Email_ist_$_angegeben( String email ) {
        this.email = email;
        webDriver.findElement( By.id( "emailInput" ) ).sendKeys( email );
        return self();
    }

    @AfterScenario
    public void closeBrowser() {
        webDriver.close();
    }
}
