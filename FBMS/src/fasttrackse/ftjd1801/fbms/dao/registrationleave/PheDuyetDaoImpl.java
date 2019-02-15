package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Repository
public class PheDuyetDaoImpl implements PheDuyetDao {
	@Autowired
	private SessionFactory sessionFactory;

	
	  @Override
	  public List<RegistrationLeave> listApproved(String approved){ 
		  Session session = this.sessionFactory.openSession(); 
		  List<RegistrationLeave> list = session.createQuery("FROM RegistrationLeave WHERE status = '"+approved+"' ").list(); 
		  session.close();
		  return list;
	  }
	 

	@Override
	public List<RegistrationLeave> listApprovedPage(int id, String approved, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE idEmployee = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", approved);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> findById(int id, String approved) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where idEmployee = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", approved);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> listApprovedPage(String approved, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE status = :st ");
		
		query.setParameter("st", approved);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

}
