package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.LaborContract;

public interface LaborContractService {
	LaborContract findById(int id);

	void saveLaborContract(LaborContract LaborContract);

	void updateLaborContract(LaborContract LaborContract);

	void deleteById(int id);

	List<LaborContract> findAllLaborContracts();

	List<LaborContract> findAllLaborContracts(String search);

	boolean isLaborContractIdUnique(Integer id);

	List<LaborContract> getLaborContracts(int fromIndex, int toIndex);

	List<LaborContract> getLaborContracts(int fromIndex, int toIndex, String search);
}