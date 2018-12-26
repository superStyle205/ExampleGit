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
public class VangNghiDaoImpl implements VangNghiDao {
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
	public void delete(String idAbsent) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(RegistrationLeave.class, idAbsent));
		pb.commit();
		session.close();
	}

	@Override
	public RegistrationLeave findByMaVangNghi(String idAbsent) {
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


}
