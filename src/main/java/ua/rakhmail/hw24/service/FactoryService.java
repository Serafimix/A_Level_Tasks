package ua.rakhmail.hw24.service;

import ua.rakhmail.hw24.dao.FactoryDao;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;

import java.util.List;

public class FactoryService {
    private FactoryDao factoryDao = new FactoryDao();

    public FactoryService() {
    }

    public Factory findUser(int id) {
        return factoryDao.findById(id);
    }

    public void saveFactory(Factory factory) {
        factoryDao.save(factory);
    }

    public void deleteFactory(Factory factory) {
        factoryDao.delete(factory);
    }

    public void updateFactory(Factory factory) {
        factoryDao.update(factory);
    }

    public List<Factory> findAllFactories() {
        return factoryDao.findAll();
    }

    public Technique findTechniqueById(int id) {
        return factoryDao.findFactoryById(id);
    }

}
