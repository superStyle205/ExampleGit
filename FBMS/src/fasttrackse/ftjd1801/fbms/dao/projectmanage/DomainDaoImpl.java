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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Domain;

@Repository
public class DomainDaoImpl extends AbstractDao<Integer, Domain> implements DomainDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Domain>) criteria.list();
	}

	@Override
	public void addNew(Domain dm) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(dm);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Domain dm) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dm);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int maDomain) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Domain.class, maDomain));
		tx.commit();
		session.close();
	}

	@Override
	public Domain findByMaDomain(int maDomain) {
		return  getByKey(maDomain);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Domain> findAll(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameDomain", "%" + search + "%");
		criteria.add(cond);
		return (List<Domain>) criteria.list().subList(fromIndex, toIndex);
	}
}
