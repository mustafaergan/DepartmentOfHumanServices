package tr.com.altay.dao.interfaces;

import tr.com.altay.Entity.Employee;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    void persist(Employee group);

    void update(Employee group);

    List<Employee> findByDepartmant(int departmantId);
}
