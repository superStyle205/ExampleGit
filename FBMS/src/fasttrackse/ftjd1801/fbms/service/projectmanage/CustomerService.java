package fasttrackse.ftjd1801.fbms.service.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);

	void update(Customer customer);

	void delete(int id);

	Customer findByIdCustomer(int id);

	List<Customer> findAll(String search);

	List<Customer> findCustomer(int fromIndex, int toIndex, String search);
}
