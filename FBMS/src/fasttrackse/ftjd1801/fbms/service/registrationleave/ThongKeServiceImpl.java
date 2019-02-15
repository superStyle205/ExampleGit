package fasttrackse.ftjd1801.fbms.service.registrationleave;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.registrationleave.ThongKeDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

@Service
public class ThongKeServiceImpl implements ThongKeService {

	@Autowired
	private ThongKeDao thongKeDao;
	

	@Override
	public List<RegistrationLeave> listRestDayPage(Date day, Date toDay, String approved, int currentPage, int perPage) {
		// TODO Auto-generated method stub
		currentPage = (currentPage -1)*perPage;
		return thongKeDao.listRestDayPage(day, toDay, approved, currentPage,perPage);
	}

	

	@Override
	public List<RegistrationLeave> findByDay(Date day, Date toDay, String approved) {
		return thongKeDao.findByDay(day, toDay, approved);
	}



	@Override
	public List<RegistrationLeave> findByDayAndId(int id, Date day, Date toDay, String approved) {
		 return thongKeDao.findByDayAndId(id, day, toDay, approved);
	}



	@Override
	public List<RegistrationLeave> listRestDayPageAndId(int id, Date day, Date toDay, String approved, int currentPage,
			int perPage) {
		currentPage = (currentPage -1)*perPage;
		return thongKeDao.listRestDayPageAndId(id, day, toDay, approved, currentPage, perPage);
	}



	

	

	

	

	



}
