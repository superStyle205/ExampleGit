package fasttrackse.ftjd1801.fbms.controller.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.RoleAll;
import fasttrackse.ftjd1801.fbms.service.projectmanage.RoleAllService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/VaiTro/list-vaiTro")
public class RoleAllController {
	@Autowired
	RoleAllService service;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewRole(Model model) {
		List<RoleAll> listRole = service.findAll();
		model.addAttribute("listRole", listRole);
		return "/QuanLyDuAn/role/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("role", new RoleAll());
		return "/QuanLyDuAn/role/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("role") RoleAll role,
			final RedirectAttributes redirectAttributes) {
		try {
			service.addNew(role);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công ...");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại..");
		}
		return "redirect:/QuanLyDuAn/VaiTro/list-vaiTro";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("role", service.findById(id));
		return "/QuanLyDuAn/role/edit_form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("role") RoleAll role,
			final RedirectAttributes redirectAttributes) {
		try {
			service.update(role);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công ...");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại..");
		}
		return "redirect:/QuanLyDuAn/VaiTro/list-vaiTro";
	}
	
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		try {
			service.delete(id);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công ..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi, xin thử lại ..");
		}
		return "redirect:/QuanLyDuAn/VaiTro/list-vaiTro";
	}
}
