package fasttrackse.ftjd1801.fbms.service.security;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.security.ChucNangPhongBan;

public interface ChucNangPhongBanService {
	public List<ChucNangPhongBan> findAll();

	public void addNew(ChucNangPhongBan cd);

	public void update(ChucNangPhongBan cd);

	public void delete(int id);

	public List<ChucNangPhongBan> findAllForPaging(int startPosition, int maxResult);

	public ChucNangPhongBan findById(int id);
}
