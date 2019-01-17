package fasttrackse.ftjd1801.fbms.service.quanlithoigian;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;

public interface LogTimeService {
	LogTime findById(int id);

	void saveLogTime(LogTime LogTime);

	void updateLogTime(LogTime LogTime);

	void deleteById(int id);

	List<LogTime> findAllLogTimes();

	List<LogTime> findAllLogTimes(String search);

	boolean isLogTimeIdUnique(Integer id);

	List<LogTime> getLogTimes(int fromIndex, int toIndex);

	List<LogTime> getLogTimes(int fromIndex, int toIndex, String search);

}
