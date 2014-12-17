package com.tngtech.jgiven.javaaktuell;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.lang.de.Stufe;

public class WennRegistrierungsSeite<SELF extends WennRegistrierungsSeite<?>> extends Stufe<SELF> {
    @ExpectedScenarioState
    RegistrierungsSeite registrierungsSeite;

    public SELF der_Kunde_auf_den_Registrieren_Knopf_drückt() {
        registrierungsSeite.registrierenButton.click();
        return self();
    }
}
