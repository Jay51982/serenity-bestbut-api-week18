package com.bestbuyapi.utilitiesinfo;

import com.bestbuyapi.bestbuyapiinfo.UtilitiesSteps;
import com.bestbuyapi.testbase.UtilitiesTestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UtilitiesCURDTestWithSteps extends UtilitiesTestBase {

    @Steps
    UtilitiesSteps utilitiesSteps;

    @Title("This will get all HealthCheck")
    @Test
    public void test001() {
        utilitiesSteps.getHealthCheck().statusCode(200).log().all();

    }

    @Title("This will get all version")
    @Test
    public void test002() {
        utilitiesSteps.createVersion().statusCode(200).log().all();

    }
}
