package fasttrackse.ftjd1801.fbms.service.quanlithoigian;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;

public interface LogTimeService {
	LogTime findById(int id);

	void saveLogTime(LogTime LogTime);

	void updateLogTime(LogTime LogTime);

	void deleteById(int id);

	List<LogTime> findAllLogTimes();

	boolean isLogTimeIdUnique(Integer id);

	

	

}
