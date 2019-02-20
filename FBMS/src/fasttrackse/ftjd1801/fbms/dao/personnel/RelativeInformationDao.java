package fasttrackse.ftjd1801.fbms.dao.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.RelativeInformation;

public interface RelativeInformationDao {
	RelativeInformation findById(int id);

	void saveRelativeInformation(RelativeInformation employee);

	void deleteRelativeInformationById(int id);

	List<RelativeInformation> findAllRelativeInformations();

	List<RelativeInformation> findAllRelativeInformations(String search);

	List<RelativeInformation> getRelativeInformations(int fromIndex, int toIndex);

	List<RelativeInformation> getRelativeInformations(int fromIndex, int toIndex, String search);
}