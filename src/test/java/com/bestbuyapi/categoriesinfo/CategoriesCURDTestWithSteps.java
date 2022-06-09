package com.bestbuyapi.categoriesinfo;

import com.bestbuyapi.bestbuyapiinfo.CategoriesSteps;
import com.bestbuyapi.testbase.CategoriesTestBase;
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
public class CategoriesCURDTestWithSteps extends CategoriesTestBase {

        static String name = "AAA Batteries";
    static String id = TestUtils.getRandomName();

        static String categoriesId;

        @Steps
        CategoriesSteps categoriesSteps;

        @Title("This will create a new category")
        @Test
        public void test01() {
          categoriesSteps.createCategory(name, id).statusCode(201).log().all();

        }

        @Title("Verify if the category was created")
        @Test
        public void test02() {

            HashMap<String, Object> value = categoriesSteps.getCategoryInfoByName(name);
            Assert.assertThat(value, hasValue(name));
            categoriesId = (String) value.get("id");
            System.out.println(categoriesId);
        }

        @Title("Update the category information and verify the updated information")
        @Test
        public void test03() {
            name = name + "_updated";
            categoriesSteps.updateCategory(name, categoriesId).statusCode(200).log().all();
            HashMap<String, Object> categoryMap = categoriesSteps.getCategoryInfoByName(name);
            Assert.assertThat(categoryMap, hasValue(name));

        }

        @Title("Delete the category and verify if the category is deleted!")
        @Test
        public void test04() {
            categoriesSteps.deleteCategory(categoriesId).statusCode(200);
            categoriesSteps.getCategoryById(categoriesId).statusCode(404);
        }

}
