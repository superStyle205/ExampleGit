package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.personnel.RelativeInformation;

@Repository("RelativeInformationDao")
public class RelativeInformationDaoImpl extends AbstractDao<Integer, RelativeInformation> implements RelativeInformationDao {
	public RelativeInformation findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveRelativeInformation(RelativeInformation RelativeInformation) {
		persist(RelativeInformation);
	}

	@Override
	public void deleteRelativeInformationById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelativeInformation> findAllRelativeInformations() {
		Criteria criteria = createEntityCriteria();
		return (List<RelativeInformation>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelativeInformation> findAllRelativeInformations(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("name", "%" + search + "%");
		criteria.add(cond);
		return (List<RelativeInformation>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelativeInformation> getRelativeInformations(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<RelativeInformation>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<RelativeInformation> getRelativeInformations(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("name", "%" + search + "%");
		criteria.add(cond);
		return (List<RelativeInformation>) criteria.list().subList(fromIndex, toIndex);
	}

}
