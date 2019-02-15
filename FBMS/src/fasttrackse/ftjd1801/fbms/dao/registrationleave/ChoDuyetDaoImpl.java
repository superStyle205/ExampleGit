package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Repository
public class ChoDuyetDaoImpl implements ChoDuyetDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationLeave> findAll() {
		Session session = this.sessionFactory.openSession();
		List<RegistrationLeave> list = session.createQuery("from RegistrationLeave").list();
		session.close();
		return list;
	}


	@Override
	public void update(RegistrationLeave rl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(rl);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(String idAbsent) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(RegistrationLeave.class, idAbsent));
		pb.commit();
		session.close();
	}

	@Override
	public RegistrationLeave findByMaVangNghi(int idAbsent) {
		Session session = this.sessionFactory.openSession();
		RegistrationLeave pb = session.get(RegistrationLeave.class, idAbsent);
		session.close();
		return pb;

	}

	
	  @Override
	  public List<RegistrationLeave> listPending(String pending){ 
		  Session session = this.sessionFactory.openSession(); 
		  List<RegistrationLeave> list = session.createQuery("FROM RegistrationLeave WHERE status = '"+pending+"' ").list(); 
		  session.close();
		  return list;
	  }
	 

	@Override
	public List<RegistrationLeave> listPendingPage(int id, String pending, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE idAbsent = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", pending);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> findById(int id, String pending) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where idAbsent = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", pending);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> listPendingPage(String pending, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE status = :st ");
		
		query.setParameter("st", pending);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

}
