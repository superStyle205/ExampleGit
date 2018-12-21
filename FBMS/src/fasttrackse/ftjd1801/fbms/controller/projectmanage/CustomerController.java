package fasttrackse.ftjd1801.fbms.controller.projectmanage;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.service.projectmanage.CustomerService;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;

@Controller
@RequestMapping("/QuanLyDuAn/KhachHang/list-khachHang")
public class CustomerController {

	String search = "";
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String viewCustomer(Model model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;

		List<Customer> listAll = customerService.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Customer> list = customerService.findCustomer(recordStart, recordEnd, search);

		int nOfPages = (int) Math.ceil((double) list.size() / recordsPerPage);

		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listCustomer", list);

		return "/QuanLyDuAn/khachhang/list";
	}

	@RequestMapping(value = "/view/{customerName}", method = RequestMethod.GET)
	public String viewOneCustomer(@PathParam("customerName") String customerName, Model model) {
		model.addAttribute("customer", customerService.findAll(customerName));
		return "/QuanLyDuAn/KhachHang/list-khachHang/viewOne";
	}

	@RequestMapping(value = { "search" }, method = RequestMethod.POST)
	public String search(@PathParam(value = "search") String searchName) {
		search = searchName;
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";
	}

	@RequestMapping(value = "/view/getListCustomer/{page}", method = RequestMethod.GET)
	public String getListCustomer(Model model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;

		List<Customer> listAllCustomer = customerService.findAll(search);
		if (listAllCustomer.size() < recordEnd) {
			recordEnd = listAllCustomer.size();
		}
		List<Customer> listCustomer = customerService.findCustomer(recordStart, recordEnd, search);

		int nOfPages = (int) Math.ceil((double) listAllCustomer.size() / recordsPerPage);

		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listCustomer", listCustomer);
		return "/QuanLyDuAn/KhachHang/list-khachHang/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "/QuanLyDuAn/khachhang/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("customer") Customer ct) {
			customerService.saveCustomer(ct);
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang/list/1";
	}

	@RequestMapping(value = "/edit/{idCustomer}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idCustomer") int idCustomer, Model model) {
		model.addAttribute("customer", customerService.findByIdCustomer(idCustomer));
		return "QuanLyDuAn/khachhang/edit_form";
	}

	@RequestMapping(value = "/edit/{idCustomer}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("customer") Customer ct) {
			customerService.saveCustomer(ct);
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";
	}

	@RequestMapping(value = "/delete/{idCustomer}", method = RequestMethod.GET)
	public String delete(@PathVariable("idCustomer") int idCustomer) {
			customerService.delete(idCustomer);
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";

	}
}
