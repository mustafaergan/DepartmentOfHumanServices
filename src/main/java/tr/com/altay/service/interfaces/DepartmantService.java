package tr.com.altay.service.interfaces;

import tr.com.altay.Entity.Departmant;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
public interface DepartmantService {

    List<Departmant> findAll();

    Departmant findById(int id);

    void persist(Departmant group);

    void update(Departmant group);
}
