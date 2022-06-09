package com.bestbuyapi.servicesinfo;

import com.bestbuyapi.bestbuyapiinfo.ServicesSteps;
import com.bestbuyapi.testbase.ServicesTestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ServicesCURDTestWithSteps extends ServicesTestBase {

        static String name = "Smith";
        static int servicesId;

        @Steps
        ServicesSteps servicesSteps;

        @Title("This will create a new service")
        @Test
        public void test01() {
            servicesSteps.createService(name).statusCode(201).log().all();
        }

        @Title("Verify if the service was added")
        @Test
        public void test02() {

            HashMap<String, Object> value = servicesSteps.getServiceInfoByName(name);
            Assert.assertThat(value, hasValue(name));
            servicesId = (int) value.get("id");
            System.out.println(servicesId);
        }

        @Title("Update the service information and verify the updated information")
        @Test
        public void test03() {
            name = name + "_updated";
            servicesSteps.updateService(name, servicesId).log().all().statusCode(200);
            HashMap<String, Object> serviceMap = servicesSteps.getServiceInfoByName(name);
            Assert.assertThat(serviceMap, hasValue(name));
        }

        @Title("Delete the service and verify if the service is deleted!")
        @Test
        public void test04() {
            servicesSteps.deleteService(servicesId).statusCode(200).log().status();
            servicesSteps.getServiceByName(servicesId).statusCode(404).log().status();

        }
}
