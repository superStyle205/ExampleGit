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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Framework;

@Repository
public class FrameworkDaoImpl extends AbstractDao<Integer,Framework> implements FrameworkDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Framework findByIdFramework(int id) {
		return getByKey(id);
	}

	@Override
	public void addNew(Framework fm) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(fm);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Framework fm) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(fm);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Framework.class, id));
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Framework> listAll(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("technology", "%" + search + "%");
		criteria.add(cond);
		return (List<Framework>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Framework> listForPagination(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("technology", "%" + search + "%");
		criteria.add(cond);
		return (List<Framework>) criteria.list().subList(fromIndex, toIndex);
	}

}
