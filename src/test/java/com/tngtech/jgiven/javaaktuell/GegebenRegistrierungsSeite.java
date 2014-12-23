package com.tngtech.jgiven.javaaktuell;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

import com.tngtech.jgiven.annotation.AfterScenario;
import com.tngtech.jgiven.annotation.BeforeStage;
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

    @ProvidedScenarioState
    RegistrierungsSeite registrierungsSeite;

    @BeforeStage
    protected void setupPage() {
        registrierungsSeite = PageFactory.initElements( webDriver, RegistrierungsSeite.class );
    }

    public SELF die_Registrierungsseite_ist_geöffnet()
            throws Exception {
        File file = new File( "src/main/resources/webshop/registrierung.html" );
        webDriver.get( file.toURI().toURL().toString() );
        return self();
    }

    public SELF eine_valide_Email_ist_angegeben() {
        return als_Email_ist_$_angegeben( email );
    }

    public SELF ein_valides_Passwort_ist_angegeben() {
        registrierungsSeite.passwortInput.sendKeys( passwort );
        return self();
    }

    public SELF als_Email_ist_$_angegeben( String email ) {
        this.email = email;
        registrierungsSeite.emailInput.sendKeys( email );
        return self();
    }

    @AfterScenario
    public void closeBrowser() {
        webDriver.close();
    }
}
