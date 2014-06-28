package com.tngtech.jgiven.javaaktuell;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.tngtech.jgiven.junit.de.SzenarioTest;

@RunWith( DataProviderRunner.class )
public class AnmeldeTest extends SzenarioTest<GegebenSeite, WennSeite, DannSeite> {

    @Test
    @Story( "ABC-1" )
    public void Kunden_können_sich_registrieren() {
        gegeben().die_Registrierungsseite_ist_geöffnet();
        wenn().der_Kunde_eine_valide_Email_angibt()
            .und().der_Kunde_ein_valides_Passwort_angibt()
            .und().der_Kunde_auf_den_Registrieren_Knopf_drückt();
        dann().wird_die_Willkommensseite_geöffnet()
            .und().der_Kunde_ist_registriert()
            .und().der_Kunde_erhält_eine_Bestätigungsemail();
    }

    @DataProvider
    public static Object[][] invalidEmailAddresses() {
        return new Object[][] {
            { "ungültig" },
            { "1234" },
        };
    }

    @Test
    @Story( "ABC-1" )
    @UseDataProvider( "invalidEmailAddresses" )
    public void Kunden_können_sich_nur_mit_valider_Email_Addresse_registrieren( String email ) {
        gegeben().die_Registrierungsseite_ist_geöffnet();
        wenn().der_Kunde_als_Email_Addresse_$_angibt( email )
            .und().der_Kunde_ein_valides_Passwort_angibt()
            .und().der_Kunde_auf_den_Registrieren_Knopf_drückt();
        dann().wird_die_Registrierung_mit_der_Fehlermeldung_$_abgelehnt( "Ungültige Email-Addresse" )
            .und().der_Kunde_ist_nicht_registriert();
    }
}
