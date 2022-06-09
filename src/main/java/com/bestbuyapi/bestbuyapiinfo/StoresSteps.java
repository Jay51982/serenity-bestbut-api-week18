package com.bestbuyapi.bestbuyapiinfo;


import com.bestbuyapi.constants.EndPoints;
import com.bestbuyapi.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class StoresSteps {

    @Step("Creating store with name :{0}, type: {1}, address: {2}, address2: {3}, city: {4}, state: {5}, zip: {6}")
    public ValidatableResponse createStore(String name,String type,String address,String address2,String city,String state, String zip){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .post(EndPoints.CREATE_STORE_BY_ID)
                .then();
    }
    @Step("Getting Product information with name:{0}")
    public HashMap<String, Object> getStoreInfoByName(String name) {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORES)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }
    @Step("Updating store with name: {0}, type: {1}, address: {2}, address2: {3}, city: {4},state: {5}, zip: {6}")
    public ValidatableResponse updateStore(int storeId,String name,String type,String address,String address2,String city,String state, String zip){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("storesID", storeId)
                .body(storesPojo)
                .when()
                .put(EndPoints.UPDATE_STORE_BY_ID)
                .then();
    }
    @Step("Deleting store information with storeID:{0}")
    public ValidatableResponse deleteStore(int storeId) {
        return SerenityRest
                .given()
                .pathParam("storesID", storeId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then();
    }
    @Step("Getting Product information with ProductsId:{0}")
    public ValidatableResponse getStoreById(int storeId) {
        return SerenityRest
                .given()
                .pathParam("storesID", storeId)
                .when()
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then();
    }
}
