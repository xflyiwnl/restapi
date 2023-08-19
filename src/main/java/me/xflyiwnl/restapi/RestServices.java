package me.xflyiwnl.restapi;

import me.xflyiwnl.restapi.service.CitizenService;

public class RestServices {

    private CitizenService citizen;

    public RestServices() {
        init();
    }

    public void init() {
        citizen = new CitizenService(RestAPI.getInstance().getConnector().getCitizenDAO());
    }

    public CitizenService getCitizen() {
        return citizen;
    }
}
