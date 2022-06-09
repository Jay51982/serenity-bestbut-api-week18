package com.bestbuyapi.bestbuyapiinfo;


import com.bestbuyapi.constants.EndPoints;
import com.bestbuyapi.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductsSteps {
    @Step("Creating product with name : {0},type : {1},price : {2},shipping : {3},upc : {4},description : {5},manufacturer : {6},model :{7},url : {8},image : {9}")
    public ValidatableResponse createProducts(String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post(EndPoints.CREATE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Getting the product information with name: {0}")
    public HashMap<String, Object> getProductInfoByName(String name) {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }

    @Step("Updating Product information with ProductsId: {0}, name : {1}, type: {2}, price: {3}, shipping: {4}, upc: {5},description: {6}, manufacturer: {7},model: {8},url: {9},image: {10}")
    public ValidatableResponse updateProduct(int productsId, String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("productsID", productsId)
                .body(productPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Deleting Product information with ProductsId:{0}")
    public ValidatableResponse deleteProduct(int productsId) {
        return SerenityRest
                .given()
                .pathParam("productsID", productsId)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Getting Product information with ProductsId:{0}")
    public ValidatableResponse getProductById(int productsId) {
        return SerenityRest
                .given()
                .pathParam("productsID", productsId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then();
    }
}