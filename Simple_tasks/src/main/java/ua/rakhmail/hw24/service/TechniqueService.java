package ua.rakhmail.hw24.service;

import ua.rakhmail.hw24.dao.TechniqueDao;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;

import java.util.List;

public class TechniqueService {
    private TechniqueDao techniqueDao = new TechniqueDao();

    public TechniqueService() {
    }

    public Technique findTechniqueById(int id) {
        return techniqueDao.findById(id);
    }

    public void saveTechnique(Technique technique) {
        techniqueDao.save(technique);
    }

    public void deleteTechnique(int id) {
        techniqueDao.delete(id);
    }

    public void updateTechnique(Technique technique) {
        techniqueDao.update(technique);
    }

    public List<Technique> findAllTechniques() {
        return techniqueDao.findAll();
    }

    public Factory findFactoryById(int id) {
        return techniqueDao.findFactoryById(id);
    }

    public void getTechniquesFromFactoryId(int id){
        techniqueDao.findTechniquesByFactoryID(id);
    }

}
