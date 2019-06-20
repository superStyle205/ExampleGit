package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.personnel.Certificate;

@Repository("certificateDao")
public class CertificateDaoImpl extends AbstractDao<Integer, Certificate> implements CertificateDao {
	public Certificate findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveCertificate(Certificate Certificate) {
		persist(Certificate);
	}

	@Override
	public void deleteCertificateById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Certificate> findAllCertificates() {
		Criteria criteria = createEntityCriteria();
		return (List<Certificate>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Certificate> findAllCertificates(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("typeOfCertificate", "%" + search + "%");
		criteria.add(cond);
		return (List<Certificate>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Certificate> getCertificates(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<Certificate>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<Certificate> getCertificates(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("typeOfCertificate", "%" + search + "%");
		criteria.add(cond);
		return (List<Certificate>) criteria.list().subList(fromIndex, toIndex);
	}

}
