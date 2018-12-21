package fasttrackse.ftjd1801.fbms.controller.projectmanage;

import java.util.List;

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

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewCustomer(Model model) {
		List<Customer> listAll = customerService.findAll();
		model.addAttribute("listCustomer", listAll);
		return "/QuanLyDuAn/khachhang/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "/QuanLyDuAn/khachhang/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("customer") Customer ct,
			final RedirectAttributes redirectAttributes) {
		try {
			customerService.saveCustomer(ct);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";
	}

	@RequestMapping(value = "/edit/{idCustomer}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idCustomer") int idCustomer, Model model) {
		model.addAttribute("customer", customerService.findByIdCustomer(idCustomer));
		return "QuanLyDuAn/khachhang/edit_form";
	}

	@RequestMapping(value = "/edit/{idCustomer}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("customer") Customer ct,
			final RedirectAttributes redirectAttributes) {
		try {
			customerService.update(ct);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";
	}

	@RequestMapping(value = "/delete/{idCustomer}", method = RequestMethod.GET)
	public String delete(@PathVariable("idCustomer") int idCustomer, final RedirectAttributes redirectAttributes) {
		try {
			customerService.delete(idCustomer);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/KhachHang/list-khachHang";

	}
}
