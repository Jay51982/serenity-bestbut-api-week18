package com.bestbuyapi.constants;


public class EndPoints {

    /**
     * This is Endpoints of products api
     */
    public static final String GET_ALL_PRODUCTS = "";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/{productsID}";
    public static final String CREATE_PRODUCT_BY_ID = "";
    public static final String UPDATE_PRODUCT_BY_ID = "/{productsID}";
    public static final String DELETE_PRODUCT_BY_ID = "/{productsID}";

    /**
     * This is Endpoints of services api
     */
    public static final String GET_ALL_SERVICES = "";
    public static final String GET_SINGLE_SERVICE_BY_ID = "/{servicesID}";
    public static final String CREATE_SERVICE_BY_ID = "";
    public static final String UPDATE_SERVICE_BY_ID = "/{servicesID}";
    public static final String DELETE_SERVICE_BY_ID = "/{servicesID}";

    /**
     * This is Endpoints of categories api
     */
    public static final String GET_ALL_CATEGORIES = "";
    public static final String GET_SINGLE_CATEGORY_BY_ID = "/{categoriesID}";
    public static final String CREATE_CATEGORY_BY_ID = "";
    public static final String UPDATE_CATEGORY_BY_ID = "/{categoriesID}";
    public static final String DELETE_CATEGORY_BY_ID = "/{categoriesID}";

    /**
     * This is Endpoints of stores api
     */
    public static final String GET_ALL_STORES = "";
    public static final String GET_SINGLE_STORE_BY_ID = "/{storesID}";
    public static final String CREATE_STORE_BY_ID = "";
    public static final String UPDATE_STORE_BY_ID = "/{storesID}";
    public static final String DELETE_STORE_BY_ID = "/{storesID}";

    /**
     * This is Endpoints of utilities api
     */
    public static final String GET_ALL_UTILITY = "/version";
    public static final String GET_ALL_UTILITIES = "/healthcheck";

}
