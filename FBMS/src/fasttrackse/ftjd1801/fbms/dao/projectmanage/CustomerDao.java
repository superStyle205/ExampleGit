package fasttrackse.ftjd1801.fbms.dao.projectmanage;

import java.util.List;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;

public interface CustomerDao {

	void saveCustomer(Customer customer);

	void delete(int id);

	Customer findByIdCustomer(int id);
		
	List<Customer> findAll(String customerName);

	List<Customer> findCustomer(int fromIndex, int toIndex, String search);

}
