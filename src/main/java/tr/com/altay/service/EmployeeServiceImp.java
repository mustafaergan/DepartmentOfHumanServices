package tr.com.altay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.altay.Entity.Employee;
import tr.com.altay.dao.interfaces.EmployeeDao;
import tr.com.altay.service.interfaces.EmployeeService;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeDao dao;

    public List<Employee> findAll() {
        return dao.findAll();
    }

    public Employee findById(int id) {
        return dao.findById(id);
    }

    public void persist(Employee employee) {
        dao.persist(employee);
    }

    public void update(Employee employee) {
        dao.update(employee);
    }

    public List<Employee> findByDepartmant(int departmantId) {
        return dao.findByDepartmant(departmantId);
    }
}
