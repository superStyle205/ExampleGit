package fasttrackse.ftjd1801.fbms.dao.quanlithoigian;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;

public interface LogTimeDao {
	LogTime findById(int id);

	void saveLogTime(LogTime LogTime);

	void deleteLogTimeById(int id);

	List<LogTime> findAllLogTimes();

	List<LogTime> findAllLogTimes(String search);

	List<LogTime> getLogTimes(int fromIndex, int toIndex);

	List<LogTime> getLogTimes(int fromIndex, int toIndex, String search);

}
