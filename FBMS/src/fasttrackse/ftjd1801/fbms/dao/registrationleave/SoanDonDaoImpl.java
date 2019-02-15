package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.LaborContract;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Repository
public class SoanDonDaoImpl implements SoanDonDao {
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
	public void addNew(RegistrationLeave rl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(rl);
		tx.commit();
		session.close();
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
	public void delete(int idAbsent) {
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
	  public List<RegistrationLeave> listDrafts(String draft){ 
		  Session session = this.sessionFactory.openSession(); 
		  List<RegistrationLeave> list = session.createQuery("FROM RegistrationLeave WHERE status = '"+draft+"' ").list(); 
		  session.close();
		  return list;
	  }
	 

	@Override
	public List<RegistrationLeave> listDraftsPage(int id, String draft, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE idAbsent = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", draft);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> findById(int id, String draft) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where idAbsent = :id and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", draft);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> findByIdEmployee(int idEmployee, String status) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where idEmployee = :id and status = :st ");
		query.setParameter("id", idEmployee);
		query.setParameter("st", status);

		return query.list();
	}
	

	
	@Override
	public List<RegistrationLeave> listDraftsPage(String draft, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE status = :st ");
		
		query.setParameter("st", draft);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public LaborContract dayOfRest(int idEmployee) {
		Session session = this.sessionFactory.openSession();
		LaborContract lb = session.get(LaborContract.class, idEmployee);
		session.close();
		return lb;
	}

	@Override
	public void updateDayOfRest(LaborContract lb) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(lb);
		tx.commit();
		session.close();
	}

	@Override
	public List<RegistrationLeave> findByIdAbsent(int search, int idEmployee, String status) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where idAbsent = :idAbsent and idEmployee = :id and status = :st ");
		query.setParameter("idAbsent", search);
		query.setParameter("id", idEmployee);
		query.setParameter("st", status);
		
		return query.list();
	}

	@Override
	public List<RegistrationLeave> listPageByIdEmployee(String status, int idEmployee, int currentPage, int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE idEmployee = :idEm AND (status = :st1 OR status = :st2 OR status = :st3) ");
		query.setParameter("idEm", idEmployee);
		query.setParameter("st1", "Chờ Duyệt");
		query.setParameter("st2", "Phê Duyệt");
		query.setParameter("st3", "Từ Chối");
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> listPageByIdAbsent(int search, String status, int idEmployee, int currentPage,
			int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE idEmployee = :idEm AND idAbsent = :idAb AND status = :st ");
		query.setParameter("idEm", idEmployee);
		query.setParameter("idAb", search);
		query.setParameter("st", status);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);
		return query.list();
	}

	


	
}
