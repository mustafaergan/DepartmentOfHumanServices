package tr.com.altay.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import tr.com.altay.Entity.Employee;
import tr.com.altay.dao.interfaces.EmployeeDao;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@Repository
public class EmployeeDaoImp extends AbstractDao<Integer, Employee> implements EmployeeDao {
    public List<Employee> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Employee> employees = (List<Employee>) criteria.list();
        return employees;
    }

    public Employee findById(int id) {
        return getByKey(id);
    }

    public List<Employee> findByDepartmant(int departmantId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("departmantId", departmantId));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Employee> employees = (List<Employee>) criteria.list();
        return employees;
    }
}
