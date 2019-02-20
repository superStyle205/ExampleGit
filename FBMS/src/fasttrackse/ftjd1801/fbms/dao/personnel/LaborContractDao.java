package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.LaborContract;

public interface LaborContractDao {
	LaborContract findById(int id);

	void saveLaborContract(LaborContract employee);

	void deleteLaborContractById(int id);

	List<LaborContract> findAllLaborContracts();

	List<LaborContract> findAllLaborContracts(String search);

	List<LaborContract> getLaborContracts(int fromIndex, int toIndex);

	List<LaborContract> getLaborContracts(int fromIndex, int toIndex, String search);
}