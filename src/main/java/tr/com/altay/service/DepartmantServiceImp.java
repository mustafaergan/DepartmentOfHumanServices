package tr.com.altay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.altay.Entity.Departmant;
import tr.com.altay.dao.interfaces.DepartmantDao;
import tr.com.altay.service.interfaces.DepartmantService;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmantServiceImp implements DepartmantService {

    @Autowired
    DepartmantDao dao;

    public List<Departmant> findAll() {
        return dao.findAll();
    }

    public Departmant findById(int id) {
        return dao.findById(id);
    }

    public void persist(Departmant departmant) {
        dao.persist(departmant);
    }

    public void update(Departmant departmant) {
        dao.update(departmant);
    }
}
