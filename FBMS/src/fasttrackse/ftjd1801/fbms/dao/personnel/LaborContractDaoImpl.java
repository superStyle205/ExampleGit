package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.personnel.LaborContract;

@Repository("LaborContractDao")
public class LaborContractDaoImpl extends AbstractDao<Integer, LaborContract> implements LaborContractDao {
	public LaborContract findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveLaborContract(LaborContract LaborContract) {
		persist(LaborContract);
	}

	@Override
	public void deleteLaborContractById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LaborContract> findAllLaborContracts() {
		Criteria criteria = createEntityCriteria();
		return (List<LaborContract>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LaborContract> findAllLaborContracts(String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("idEmployee", "%" + search + "%");
		criteria.add(cond);
		return (List<LaborContract>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LaborContract> getLaborContracts(int fromIndex, int toIndex) {
		Criteria criteria = createEntityCriteria();
		return (List<LaborContract>) criteria.list().subList(fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public List<LaborContract> getLaborContracts(int fromIndex, int toIndex, String search) {
		Criteria criteria = createEntityCriteria();
		Criterion cond = Restrictions.ilike("idEmployee", "%" + search + "%");
		criteria.add(cond);
		return (List<LaborContract>) criteria.list().subList(fromIndex, toIndex);
	}

}
