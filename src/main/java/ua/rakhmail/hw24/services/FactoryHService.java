package ua.rakhmail.hw24.services;

import ua.rakhmail.hw24.dao.FactoryHDao;
import ua.rakhmail.hw24.models.FactoryH;

import java.util.List;
import java.util.UUID;

public class FactoryHService {
    private static final FactoryHDao FACTORY_H_DAO = new FactoryHDao();

    public String save(String name, String country) {
        FactoryH factoryH = new FactoryH();
        final String s = UUID.randomUUID().toString();
        factoryH.setId(s);
        factoryH.setName(name);
        factoryH.setCountry(country);
        FACTORY_H_DAO.save(factoryH);
        return s;
    }

    public void save(FactoryH factoryH) {
        FACTORY_H_DAO.save(factoryH);
    }

    public FactoryH getById(String id) {
        return FACTORY_H_DAO.getById(id);
    }

    public List<FactoryH> getAll() {
        return FACTORY_H_DAO.getAll();
    }

    public void delete(FactoryH factoryH) {
        FACTORY_H_DAO.deleteById(factoryH.getId());
    }
}
