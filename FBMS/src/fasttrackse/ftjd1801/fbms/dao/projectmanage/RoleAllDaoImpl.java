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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Project;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.RoleAll;

@Repository
public class RoleAllDaoImpl extends AbstractDao<Integer, RoleAll> implements RoleAllDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public RoleAll findById(int id) {
		return getByKey(id);
	}

	@Override
	public void addNew(RoleAll role) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(role);
		tx.commit();
		session.close();
	}

	@Override
	public void update(RoleAll role) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(role);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Project.class, id));
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleAll> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<RoleAll>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleAll> findRole(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("role", "%" + search + "%");
		criteria.add(cond);
		return (List<RoleAll>) criteria.list().subList(fromIndex, toIndex);
	}

}
