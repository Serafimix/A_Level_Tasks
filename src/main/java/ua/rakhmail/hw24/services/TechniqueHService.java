package ua.rakhmail.hw24.services;

import ua.rakhmail.hw24.dao.TechniqueHDao;
import ua.rakhmail.hw24.models.FactoryH;
import ua.rakhmail.hw24.models.TechniqueH;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TechniqueHService {
    private static final TechniqueHDao TECHNIQUE_H_DAO = new TechniqueHDao();

    public String save(String type, String model, Integer price, Date date,
                       String description, Boolean isHave, FactoryH factoryH) {
        TechniqueH techniqueH = new TechniqueH();
        final String s = UUID.randomUUID().toString();
        techniqueH.setId(s);
        techniqueH.setType(type);
        techniqueH.setModel(model);
        techniqueH.setPrice(price);
        techniqueH.setDate(date);
        techniqueH.setDescription(description);
        techniqueH.setHave(isHave);
        techniqueH.setFactoryId(factoryH);
        TECHNIQUE_H_DAO.save(techniqueH);
        return s;
    }

    public void save(TechniqueH techniqueH) {
        TECHNIQUE_H_DAO.save(techniqueH);
    }

    public TechniqueH getById(String id) {
        return TECHNIQUE_H_DAO.getById(id);
    }

    public List<TechniqueH> getAll() {
        return TECHNIQUE_H_DAO.getAll();
    }

    public void delete(TechniqueH techniqueH) {
        TECHNIQUE_H_DAO.deleteById(techniqueH.getId());
    }
}
