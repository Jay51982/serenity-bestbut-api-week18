package com.bestbuyapi.bestbuyapiinfo;


import com.bestbuyapi.constants.EndPoints;
import com.bestbuyapi.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class CategoriesSteps {
    @Step("Creating Category with name : {1}")
    public ValidatableResponse createCategory(String name, String id) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(EndPoints.CREATE_CATEGORY_BY_ID)
                .then();
    }

    @Step("Getting Category information with name: {0}")
    public HashMap<String, Object> getCategoryInfoByName(String name) {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_CATEGORIES)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }

    @Step("Updating Category information with name : {0}, categoriesID: {1}")
    public ValidatableResponse updateCategory(String name, String categoriesId) {
        CategoriesPojo categoriesPojo = CategoriesPojo.getCategoriesPojo(name, categoriesId);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("categoriesID", categoriesId)
                .body(categoriesPojo)
                .when()
                .put(EndPoints.UPDATE_CATEGORY_BY_ID)
                .then();
    }

    @Step("Deleting Category information with categoriesID: {0}")
    public ValidatableResponse deleteCategory(String categoriesId) {
        return SerenityRest
                .given()
                .pathParam("categoriesID", categoriesId)
                .when()
                .delete(EndPoints.DELETE_CATEGORY_BY_ID)
                .then();
    }

    @Step("Getting Category information with categoriesID: {0}")
    public ValidatableResponse getCategoryById(String categoriesId) {
        return SerenityRest
                .given()
                .pathParam("categoriesID", categoriesId)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORY_BY_ID)
                .then();
    }

}
