package fasttrackse.ftjd1801.fbms.dao.quanlithoigian;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;

@Repository("LogTimeDao")
public class LogTimeDaoImpl extends AbstractDao<Integer, LogTime> implements LogTimeDao {
	public LogTime findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveLogTime(LogTime LogTime) {
		persist(LogTime);
	}

	@Override
	public void deleteLogTimeById(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogTime> findAllLogTimes() {
		Criteria criteria = createEntityCriteria();
		return (List<LogTime>) criteria.list();
	}

}