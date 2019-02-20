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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Technology;

@Repository
public class TechnologyDaoImpl extends AbstractDao<Integer, Technology> implements TechnologyDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Technology findById(int id) {
		return getByKey(id);
	}

	@Override
	public void addNew(Technology tech) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tech);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Technology tech) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tech);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Technology.class, id));
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> listAll(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameTechnology", "%" + search + "%");
		criteria.add(cond);
		return (List<Technology>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> listForPagination(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameTechnology", "%" + search + "%");
		criteria.add(cond);
		return (List<Technology>) criteria.list().subList(fromIndex, toIndex);
		
	}

}
