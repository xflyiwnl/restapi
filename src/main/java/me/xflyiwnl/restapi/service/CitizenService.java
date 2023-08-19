package me.xflyiwnl.restapi.service;

import me.xflyiwnl.restapi.database.dao.CitizenDAO;
import me.xflyiwnl.restapi.entity.Citizen;

import java.util.List;

public class CitizenService implements RestService<Citizen> {

    private CitizenDAO dao;

    public CitizenService(CitizenDAO dao) {
        this.dao = dao;
    }

    @Override
    public Citizen get(Object key) {
        return dao.get(key);
    }

    @Override
    public Citizen get(Citizen entity) {
        return dao.get(entity);
    }

    @Override
    public void save(Citizen entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Citizen entity) {
        dao.delete(entity);
    }

    @Override
    public List<Citizen> all() {
        return dao.all();
    }

}
