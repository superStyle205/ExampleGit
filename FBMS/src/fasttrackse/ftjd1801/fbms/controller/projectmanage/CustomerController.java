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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;
import fasttrackse.ftjd1801.fbms.service.projectmanage.CustomerService;

@Controller
@RequestMapping("/QuanLyDuAn/KhachHang/list-khachHang")
public class CustomerController {
	
	String search = "";
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = { "search" }, method = RequestMethod.GET)
	public String getSearch(@PathParam(value = "searchName") String searchName) {
		search = searchName;
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang/";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewCustomer(Model model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Customer> listAll = customerService.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Customer> listCustomer = customerService.findCustomer(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listCustomer", listCustomer);

		return "/QuanLyDuAn/khachhang/list";
	}

	@RequestMapping(value = { "/{page}" }, method = RequestMethod.GET)
	public String list(ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		List<Customer> listAll = customerService.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Customer> listCustomer = customerService.findCustomer(recordStart, recordEnd, search);
		int nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listCustomer", listCustomer);

		return "/QuanLyDuAn/khachhang/list";

	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("edit", false);
		return "/QuanLyDuAn/khachhang/form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("customer") Customer ct,
			final RedirectAttributes redirectAttributes) {

			customerService.saveCustomer(ct);

		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";

	}

	@RequestMapping(value = "/edit/{idCustomer}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idCustomer") int idCustomer, Model model) {
		model.addAttribute("customer", customerService.findByIdCustomer(idCustomer));
		model.addAttribute("edit", true);

		return "QuanLyDuAn/khachhang/form";
	}

	@RequestMapping(value = "/edit/{idCustomer}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("customer") Customer ct,
			final RedirectAttributes redirectAttributes) {
		
			customerService.update(ct);

		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";
	}

	@RequestMapping(value = "/delete/{idCustomer}", method = RequestMethod.GET)
	public String delete(@PathVariable("idCustomer") int idCustomer, ModelMap model) {
		model.addAttribute("customer", customerService.findByIdCustomer(idCustomer));
		model.addAttribute("delete", true);
		return "QuanLyDuAn/khachhang/form";
	}

	@RequestMapping(value = "/delete/{idCustomer}", method = RequestMethod.POST)
	public String doDelete(@PathVariable("idCustomer") int idCustomer, final RedirectAttributes redirectAttributes) {
		try {
			customerService.delete(idCustomer);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";
	}
	@RequestMapping(value="/view/{idCustomer}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("idCustomer") int idCustomer, ModelMap model) {
		model.addAttribute("customer", customerService.findByIdCustomer(idCustomer));
		return "QuanLyDuAn/khachhang/viewOne";
	}
}
