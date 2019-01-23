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
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Domain> listAll = domainService.findAll();
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Domain> listDomain = domainService.findAll(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listDomain", listDomain);
		return "QuanLyDuAn/domain/list";
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String list(ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Domain> listAll = domainService.findAll();
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Domain> listDomain = domainService.findAll(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listDomain", listDomain);
		return "QuanLyDuAn/domain/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("domain", new Domain());
		model.addAttribute("edit", false);
		return "QuanLyDuAn/domain/form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("domain") Domain dm, final RedirectAttributes redirectAttributes) {
		try {
			domainService.addNew(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại");
		}
		return "redirect:/QuanLyDuAn/Domain/list-domain";
	}

	@RequestMapping(value = "/edit/{maDomain}", method = RequestMethod.GET)
	public String editForm(@PathVariable("maDomain") int maDomain, Model model) {
		model.addAttribute("domain", domainService.findByMaDomain(maDomain));
		model.addAttribute("edit", true);
		return "QuanLyDuAn/domain/form";
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

	@RequestMapping(value = "/delete/{maDomain}", method = RequestMethod.GET)
	public String delete(@PathVariable("maDomain") int maDomain, ModelMap model) {
		model.addAttribute("domain", domainService.findByMaDomain(maDomain));
		model.addAttribute("delete", true);
		return "QuanLyDuAn/domain/form";
	}

	@RequestMapping(value = "/delete/{maDomain}", method = RequestMethod.POST)
	public String doDelete(@PathVariable("maDomain") int maDomain, final RedirectAttributes redirectAttributes) {
		try {
			domainService.delete(maDomain);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyDuAn/Domain/list-domain";
	}
}
