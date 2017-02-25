package tr.com.altay.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import tr.com.altay.Entity.Departmant;
import tr.com.altay.dao.interfaces.DepartmantDao;

import java.util.List;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@Repository
public class DepartmanDaoImp extends AbstractDao<Integer, Departmant> implements DepartmantDao {
    public List<Departmant> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Departmant> departmants = (List<Departmant>) criteria.list();
        return departmants;
    }

    public Departmant findById(int id) {
        return getByKey(id);
    }
}
