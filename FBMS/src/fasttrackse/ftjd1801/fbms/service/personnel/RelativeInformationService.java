package fasttrackse.ftjd1801.fbms.service.personnel;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.personnel.RelativeInformation;

public interface RelativeInformationService {
	RelativeInformation findById(int id);

	void saveRelativeInformation(RelativeInformation RelativeInformation);

	void updateRelativeInformation(RelativeInformation RelativeInformation);

	void deleteById(int id);

	List<RelativeInformation> findAllRelativeInformations();

	List<RelativeInformation> findAllRelativeInformations(String search);

	boolean isRelativeInformationIdUnique(Integer id);

	List<RelativeInformation> getRelativeInformations(int fromIndex, int toIndex);

	List<RelativeInformation> getRelativeInformations(int fromIndex, int toIndex, String search);
}