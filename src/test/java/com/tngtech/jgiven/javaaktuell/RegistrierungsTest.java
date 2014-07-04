package com.tngtech.jgiven.javaaktuell;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.jgiven.junit.de.SzenarioTest;

@RunWith( DataProviderRunner.class )
public class RegistrierungsTest extends
        SzenarioTest<GegebenRegistrierungsSeite, WennRegistrierungsSeite, DannRegistrierungsSeite> {

    @Test
    @Story( "ABC-1" )
    public void Kunden_können_sich_registrieren() throws Exception {
        gegeben().die_Registrierungsseite_ist_geöffnet()
            .und().eine_valide_Email_ist_angegeben()
            .und().ein_valides_Passwort_ist_angegeben();
        wenn().der_Kunde_auf_den_Registrieren_Knopf_drückt();
        dann().ist_der_Kunde_registriert()
            .und().der_Kunde_erhält_eine_Bestätigungsemail();
    }

    @Test
    @Story( "ABC-1" )
    @DataProvider( { "abc.com", "ungültig", "1234" } )
    public void Kunden_können_sich_nur_mit_valider_Email_Addresse_registrieren( String email ) throws Exception {
        gegeben().die_Registrierungsseite_ist_geöffnet()
            .und().als_Email_ist_$_angegeben( email )
            .und().ein_valides_Passwort_ist_angegeben();
        wenn().der_Kunde_auf_den_Registrieren_Knopf_drückt();
        dann().wird_die_Registrierung_mit_der_Fehlermeldung_$_abgelehnt( "Ungültige Emailadresse" )
            .und().der_Kunde_ist_nicht_registriert();
    }
}
