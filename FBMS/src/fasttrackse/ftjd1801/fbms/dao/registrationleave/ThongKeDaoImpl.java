package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Repository
public class ThongKeDaoImpl implements ThongKeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RegistrationLeave> listRestDayPage(Date day, Date toDay, String approved, int currentPage, int perPage)  {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE day >= :beginDate and toDay <= :endDate and status = :st ");

	
		query.setParameter("st", approved);
		query.setParameter("beginDate", day);
		query.setParameter("endDate", toDay);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}

	@Override
	public List<RegistrationLeave> findByDay(Date day, Date toDay, String approved)  {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where day >= :beginDate and toDay <= :endDate and status = :st ");
		
		query.setParameter("st", approved);
		query.setParameter("beginDate", day);
		query.setParameter("endDate", toDay);
	
		return query.list();
	}

	@Override
	public List<RegistrationLeave> findByDayAndId(int id, Date day, Date toDay, String approved) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from RegistrationLeave where id = :id and day >= :beginDate and toDay <= :endDate and status = :st ");
		query.setParameter("id", id);
		query.setParameter("st", approved);
		query.setParameter("beginDate", day);
		query.setParameter("endDate", toDay);
	
		return query.list();
	}

	@Override
	public List<RegistrationLeave> listRestDayPageAndId(int id, Date day, Date toDay, String approved, int currentPage,
			int perPage) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM RegistrationLeave WHERE id = :id and day >= :beginDate and toDay <= :endDate and status = :st ");

		query.setParameter("id", id);
		query.setParameter("st", approved);
		query.setParameter("beginDate", day);
		query.setParameter("endDate", toDay);
		query.setFirstResult(currentPage);
		query.setMaxResults(perPage);

		return query.list();
	}
	
	


}
