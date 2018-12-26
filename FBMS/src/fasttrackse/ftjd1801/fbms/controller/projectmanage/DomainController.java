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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Domain;
import fasttrackse.ftjd1801.fbms.service.projectmanage.DomainService;

@Controller
@RequestMapping("/QuanLyDuAn/Domain/list-domain")
public class DomainController {

	String search = "";
	@Autowired
	private DomainService domainService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewDomain(Model model) {
		List<Domain> listAll = domainService.findAll();
		model.addAttribute("listDomain", listAll);
		return "QuanLyDuAn/domain/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("domain", new Domain());
		return "QuanLyDuAn/domain/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("domain") Domain dm, final RedirectAttributes redirectAttributes) {

			domainService.addNew(dm);

		return "redirect:/QuanLyDuAn/Domain/list-domain";
	}

	@RequestMapping(value = "/edit/{maDomain}", method = RequestMethod.GET)
	public String editForm(@PathVariable("maDomain") int maDomain, Model model) {
		model.addAttribute("domain", domainService.findByMaChucDanh(maDomain));
		return "QuanLyDuAn/domain/edit_form";
	}

	@RequestMapping(value = "/edit/{maDomain}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("domain") Domain dm,
			final RedirectAttributes redirectAttributes) {
		try {
			domainService.update(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/Domain/list-domain";
	}

	@RequestMapping(value = "/delete/{maChucDanh}", method = RequestMethod.GET)
	public String delete(@PathVariable("maChucDanh") int maChucDanh, final RedirectAttributes redirectAttributes) {
		try {
			domainService.delete(maChucDanh);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyDuAn/Domain/list-domain";
	}
}
