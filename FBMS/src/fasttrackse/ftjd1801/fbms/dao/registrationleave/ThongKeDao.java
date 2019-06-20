package fasttrackse.ftjd1801.fbms.dao.registrationleave;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;

public interface ThongKeDao {

	public List<RegistrationLeave> findByDay(Date day, Date toDay, String approved) ;
	
	public List<RegistrationLeave> listRestDayPage(Date day, Date toDay, String approved, int currentPage, int perPage) ;

	public List<RegistrationLeave> findByDayAndId(int id, Date day, Date toDay, String approved) ;
	
	public List<RegistrationLeave> listRestDayPageAndId(int id, Date day, Date toDay, String approved, int currentPage, int perPage) ;
}
