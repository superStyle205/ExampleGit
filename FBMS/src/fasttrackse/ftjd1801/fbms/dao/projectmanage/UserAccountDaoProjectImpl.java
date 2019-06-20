package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.UserAccountProject;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserAccountDaoProjectImpl implements UserAccountProjectDao {

	@Autowired
	SessionFactory sessionFatory;

	@Override
	public UserAccountProject loadUserByUsername(final String username) {
		Session session = sessionFatory.getCurrentSession();
		UserAccountProject user = null;
		try {
			user = session.createQuery("from UserAccount where username='" + username + "'", UserAccountProject.class)
					.getSingleResult();
		} catch (NoResultException nre) {
			// Ignore this because as per your logic this is ok!
		}

		return user;
	}
}