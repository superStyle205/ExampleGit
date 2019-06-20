package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Repository
public class TuChoiDaoImpl implements TuChoiDao {
	@Autowired
	private SessionFactory sessionFactory;

	
	  @Override
	  public List<RegistrationLeave> listRefused(String refused){ 
		  Session session = this.sessionFactory.openSession(); 
		  List<RegistrationLeave> list = session.createQuery("FROM RegistrationLeave WHERE status = '"+refused+"' ").list(); 
		  session.close();
		  return list;
	  }
	 

	@Override
	public List<RegistrationLeave> listRefusedPage(int id, String refused, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE idAbsent = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", refused);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> findById(int id, String refused) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where idAbsent = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", refused);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> listRefusedPage(String refused, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE status = :st ");
		
		query.setParameter("st", refused);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

}
