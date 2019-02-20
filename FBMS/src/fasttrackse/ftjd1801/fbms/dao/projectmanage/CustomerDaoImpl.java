package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;

@Repository
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer findByIdCustomer(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listAll(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameCustomer", "%" + search + "%");
		criteria.add(cond);
		return (List<Customer>) criteria.list();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(customer);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(Customer.class, id));
		pb.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listForPagination(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameCustomer", "%" + search + "%");
		criteria.add(cond);
		close();
		return (List<Customer>) criteria.list().subList(fromIndex, toIndex);
	}

	@Override
	public void update(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.update(customer);
		pb.commit();
		session.close();
	}

}
