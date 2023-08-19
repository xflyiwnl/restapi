package me.xflyiwnl.restapi;

import me.xflyiwnl.restapi.database.Connector;

public class RestAPI implements RestHandler{

    private static RestAPI instance;

    private Connector connector;
    private RestServices services;

    @Override
    public void start() {

        instance = this;

        connector = new Connector();
        connector.connect("localhost", "root", "1234", 3306);

        services = new RestServices();

    }

    public static RestAPI getInstance() {
        return instance;
    }

    public Connector getConnector() {
        return connector;
    }

    public RestServices getServices() {
        return services;
    }
}
