package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Technology;

public interface TechnologyDao {
	Technology findById(int id);

	void addNew(Technology tech);

	void update(Technology tech);

	void delete(int id);

	List<Technology> listAll(String search);

	List<Technology> listForPagination(int fromIndex, int toIndex, String search);
}
