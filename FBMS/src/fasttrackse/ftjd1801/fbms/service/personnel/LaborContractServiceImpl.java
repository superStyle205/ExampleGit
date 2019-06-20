package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.personnel.LaborContractDao;
import fasttrackse.ftjd1801.fbms.entity.personnel.LaborContract;

@Transactional
@Service("LaborContractService")
public class LaborContractServiceImpl implements LaborContractService {
	@Autowired
	private LaborContractDao dao;

	@Override
	public LaborContract findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveLaborContract(LaborContract LaborContract) {
		dao.saveLaborContract(LaborContract);
	}

	@Override
	public void updateLaborContract(LaborContract LaborContract) {
		LaborContract entity = dao.findById(LaborContract.getIdEmployee());
		if (entity != null) {
			entity.setTypeOfContract(LaborContract.getTypeOfContract());
			entity.setDayOfRest(LaborContract.getDayOfRest());
			entity.setMonthlySalary13(LaborContract.getMonthlySalary13());
			entity.setIdEmployee(LaborContract.getIdEmployee());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteLaborContractById(id);
	}

	@Override
	public List<LaborContract> findAllLaborContracts() {
		return dao.findAllLaborContracts();
	}

	@Override
	public List<LaborContract> findAllLaborContracts(String search) {
		return dao.findAllLaborContracts(search);
	}

	@Override
	public List<LaborContract> getLaborContracts(int currentPage, int perPage) {
		return dao.getLaborContracts(currentPage, perPage);
	}

	@Override
	public List<LaborContract> getLaborContracts(int currentPage, int perPage, String search) {
		return dao.getLaborContracts(currentPage, perPage, search);
	}

	@Override
	public boolean isLaborContractIdUnique(Integer id) {
		LaborContract LaborContract = findById(id);
		return (LaborContract == null || (id != null));
	}
}
