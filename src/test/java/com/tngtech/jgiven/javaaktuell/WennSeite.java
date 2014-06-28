package com.tngtech.jgiven.javaaktuell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class WennSeite extends Schritte<WennSeite> {
    @ExpectedScenarioState
    WebDriver webDriver;

    @ProvidedScenarioState
    String email = "TestEmail@test.com";

    @ProvidedScenarioState
    String passwort = "Passwort1234!$";

    public WennSeite der_Kunde_eine_valide_Email_angibt() {
        return der_Kunde_als_Email_Addresse_$_angibt( email );
    }

    public WennSeite der_Kunde_ein_valides_Passwort_angibt() {
        webDriver.findElement( By.id( "passwortInput" ) ).sendKeys( passwort );
        return self();
    }

    public WennSeite der_Kunde_auf_den_Registrieren_Knopf_drückt() {
        webDriver.findElement( By.id( "registrierenButton" ) ).click();
        return self();
    }

    public WennSeite der_Kunde_als_Email_Addresse_$_angibt( String email ) {
        this.email = email;
        webDriver.findElement( By.id( "emailInput" ) ).sendKeys( email );
        return self();
    }

}
