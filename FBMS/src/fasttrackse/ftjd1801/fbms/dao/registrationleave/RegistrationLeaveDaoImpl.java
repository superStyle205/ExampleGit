package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;

@Repository
public class RegistrationLeaveDaoImpl  implements RegistrationLeaveDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationLeave> getEmployees() {
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



		
	

	
}
