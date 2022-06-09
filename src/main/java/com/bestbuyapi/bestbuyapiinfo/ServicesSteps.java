package com.bestbuyapi.bestbuyapiinfo;


import com.bestbuyapi.constants.EndPoints;
import com.bestbuyapi.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ServicesSteps {
    @Step("Creating Services with name:{0}")
    public ValidatableResponse createService(String name) {
        ServicesPojo servicesPojo = ServicesPojo.getServicesPojo(name);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .post(EndPoints.CREATE_SERVICE_BY_ID)
                .then();
    }

    @Step("Getting Service information with name:{0}")
    public HashMap<String, Object> getServiceInfoByName(String name) {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_SERVICES)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }

    @Step("Updating Service information with name:{0}")
    public ValidatableResponse updateService(String name, int servicesId) {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .pathParam("servicesID", servicesId)
                .body(servicesPojo)
                .when()
                .put(EndPoints.UPDATE_SERVICE_BY_ID)
                .then();
    }

    @Step("Deleting Service information with ServicesID:{0}")
    public ValidatableResponse deleteService(int servicesId) {
        return SerenityRest
                .given()
                .pathParam("servicesID", servicesId)
                .when()
                .delete(EndPoints.DELETE_SERVICE_BY_ID)
                .then();
    }

    @Step("Getting Service information with ServicesID:{0}")
    public ValidatableResponse getServiceByName(int servicesId) {
        return SerenityRest
                .given()
                .pathParam("servicesID", servicesId)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICE_BY_ID)
                .then();
    }
}
