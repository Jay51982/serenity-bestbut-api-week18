package com.bestbuyapi.bestbuyapiinfo;


import com.bestbuyapi.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UtilitiesSteps {
    @Step("Creating Utilities with version:{0}")
    public ValidatableResponse createVersion() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_UTILITY)
                .then();
    }

    @Step("Creating Utilities with healthcheck:{0}")
    public ValidatableResponse getHealthCheck() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_UTILITIES)
                .then();

    }


}
