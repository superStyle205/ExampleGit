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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;

@Repository
public class DatabaseDaoImpl extends AbstractDao<Integer, Database> implements DatabaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Database findByIdDatabase(int id) {
		return getByKey(id);
	}

	@Override
	public void addNew(Database db) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(db);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Database db) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(db);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Database.class, id));
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Database> listAll(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameDatabase", "%" + search + "%");
		criteria.add(cond);
		return (List<Database>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Database> listForPagination(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("nameDatabase", "%" + search + "%");
		criteria.add(cond);
		return (List<Database>) criteria.list().subList(fromIndex, toIndex);
	}

}
