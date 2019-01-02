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

@Repository
public class ProjectDaoImpl extends AbstractDao<Integer, Project> implements ProjectDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Project findById(int id) {
		return getByKey(id);
	}

	@Override
	public void addNew(Project project) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(project);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Project project) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(project);
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
	public List<Project> listAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Project>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProject(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("name_language", "%" + search + "%");
		criteria.add(cond);
		return (List<Project>) criteria.list().subList(fromIndex, toIndex);
	}

}
