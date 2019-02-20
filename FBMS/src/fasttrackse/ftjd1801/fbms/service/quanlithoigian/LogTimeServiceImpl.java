package fasttrackse.ftjd1801.fbms.service.quanlithoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ftjd1801.fbms.dao.quanlithoigian.LogTimeDao;
import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;

@Transactional
@Service("LogTimeService")
public class LogTimeServiceImpl implements LogTimeService {
	@Autowired
	private LogTimeDao dao;

	@Override
	public LogTime findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveLogTime(LogTime LogTime) {
		dao.saveLogTime(LogTime);
	}

	@Override
	public void updateLogTime(LogTime LogTime) {
		LogTime entity = dao.findById(LogTime.getIdLog());
		if (entity != null) {
			entity.setIdEmployee(LogTime.getIdEmployee());
			entity.setIdProject(LogTime.getIdProject());
			entity.setRole(LogTime.getRole());
			entity.setTime(LogTime.getTime());
			entity.setDescribes(LogTime.getDescribes());
			entity.setDayLog(LogTime.getDayLog());
			entity.setStatus(LogTime.getStatus());
		}
	}

	@Override
	public void deleteById(int id) {
		dao.deleteLogTimeById(id);
	}

	@Override
	public List<LogTime> findAllLogTimes() {
		return dao.findAllLogTimes();
	}

	@Override
	public boolean isLogTimeIdUnique(Integer id) {
		LogTime LogTime = findById(id);
		return (LogTime == null || (id != null));
	}

}
