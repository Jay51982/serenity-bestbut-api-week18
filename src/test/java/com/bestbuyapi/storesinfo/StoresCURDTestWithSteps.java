package com.bestbuyapi.storesinfo;

import com.bestbuyapi.bestbuyapiinfo.StoresSteps;
import com.bestbuyapi.testbase.StoresTestBase;
import com.bestbuyapi.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class StoresCURDTestWithSteps extends StoresTestBase {

    static String name = "Kwik Fix";
    static String type = "Car Store";
    static String address = TestUtils.getRandomValue() + ", Luton Road";
    static String address2 = "Luton";
    static String city = "St. Albans";
    static String state = "Middlesex";
    static String zip = "HA5 9DG";
    static int storeId;

    @Steps
    StoresSteps storesSteps;

    @Title("This will create a new Store")
    @Test
    public void test01() {
        storesSteps.createStore(name, type, address, address2, city, state, zip).statusCode(201).log().all();
    }

    @Title("Verify if the store was added to the application")
    @Test
    public void test02() {
        HashMap<String, Object> storesMap = storesSteps.getStoreInfoByName(name);
        Assert.assertThat(storesMap, hasValue(name));
        storeId = (int) storesMap.get("id");
        System.out.println(storeId);
    }

    @Title("Update the store information and verify the updated information")
    @Test
    public void test03() {
        name = "Slough Store";
        type = "Store";
        address = TestUtils.getRandomValue() + ", London road";
        address2 = "Slough";
        city = "Slough";
        state = "Buckinghamshire";
        zip = "Sl2 5BG";
        storesSteps.updateStore(storeId, name, type, address, address2, city, state, zip).log().all().statusCode(200);
        HashMap<String, Object> storesMap = storesSteps.getStoreInfoByName(name);
        Assert.assertThat(storesMap, hasValue(name));
    }

    @Title("Delete the stores and verify if the stores is deleted!")
    @Test
    public void test04() {
        storesSteps.deleteStore(storeId).statusCode(200).log().status();
        storesSteps.getStoreById(storeId).statusCode(404).log().status();
    }
}

