package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftjd1801.fbms.dao.projectmanage.CustomerDao;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public Customer findByIdCustomer(int id) {
		return dao.findByIdCustomer(id);
	}

	@Override
	public List<Customer> findAll(String search) {
		return dao.findAll(search);
	}

	@Override
	public List<Customer> findCustomer(int fromIndex, int toIndex, String search) {
		return dao.findCustomer(fromIndex, toIndex, search);
	}

	@Override
	public void update(Customer customer) {
		dao.update(customer);
	}

}
