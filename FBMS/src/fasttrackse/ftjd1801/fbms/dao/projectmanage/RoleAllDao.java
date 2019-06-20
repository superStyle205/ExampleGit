package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.RoleAll;

public interface RoleAllDao {
	RoleAll findById(int id);

	void addNew(RoleAll role);

	void update(RoleAll role);

	void delete(int id);

	List<RoleAll> listAll();

	List<RoleAll> listForPagination(int fromIndex, int toIndex, String search);

}
