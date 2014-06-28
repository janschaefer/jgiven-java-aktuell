package com.tngtech.jgiven.javaaktuell;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tngtech.jgiven.annotation.AfterScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.lang.de.Schritte;

public class GegebenSeite extends Schritte<GegebenSeite> {
    @ProvidedScenarioState
    WebDriver webDriver = new FirefoxDriver();

    public GegebenSeite die_Registrierungsseite_ist_geöffnet() {
        File file = new File( "src/main/resources/webshop/registrierung.html" );
        try {
            webDriver.get( file.toURI().toURL().toString() );
        } catch( MalformedURLException e ) {
            throw new RuntimeException( e );
        }
        return self();
    }

    @AfterScenario
    public void closeBrowser() {
        webDriver.close();
    }
}
