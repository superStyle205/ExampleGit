package fasttrackse.ftjd1801.fbms.service.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ftjd1801.fbms.entity.security.ChucNang;

public interface ChucNangService {
	public List<ChucNang> findAll();

	public void save(ChucNang cn);

	public void update(ChucNang cn);

	public void delete(String ma_chuc_nang);

	public void active(String ma_chuc_nang);

	public ChucNang getChucNangByCode(String ma_chuc_nang);

	public ChucNang findByMaChucNang(String ma_chuc_nang);
	
	public List<ChucNang> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

	public String getSQL(HttpServletRequest request);

	public String toJson(ChucNang cn);
}
