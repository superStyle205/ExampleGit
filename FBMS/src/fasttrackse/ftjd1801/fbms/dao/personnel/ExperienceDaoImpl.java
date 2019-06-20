package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.personnel.Experience;

@Repository("experienceDao")
public class ExperienceDaoImpl extends AbstractDao<Integer, Experience> implements ExperienceDao {
	public Experience findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveExperience(Experience Experience) {
		persist(Experience);
	}

	@Override
	public void deleteExperienceById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experience> findAllExperiences() {
		Criteria criteria = createEntityCriteria();
		return (List<Experience>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experience> findAllExperiences(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("workPlace", "%" + search + "%");
		criteria.add(cond);
		return (List<Experience>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experience> getExperiences(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<Experience>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<Experience> getExperiences(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("workPlace", "%" + search + "%");
		criteria.add(cond);
		return (List<Experience>) criteria.list().subList(fromIndex, toIndex);
	}

}
