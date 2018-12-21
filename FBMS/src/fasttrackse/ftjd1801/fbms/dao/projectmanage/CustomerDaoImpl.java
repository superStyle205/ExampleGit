package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;

@Repository
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	@Override
	public Customer findByIdCustomer(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll(String customerName) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("name", "%" + customerName + "%");
		criteria.add(cond);
		return (List<Customer>) criteria.list();
	}

	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
	}

	@Override
	public void delete(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findCustomer(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("name", "%" + search + "%");
		criteria.add(cond);
		return (List<Customer>) criteria.list().subList(fromIndex, toIndex);
	}

}
