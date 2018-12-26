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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.ProgramingLanguage;
import fasttrackse.ftjd1801.fbms.service.projectmanage.ProgramingLanguageService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/NgonNgu/list-ngonNgu")
public class ProgramingLanguageController {
	@Autowired
	ProgramingLanguageService service;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewLanguage(Model model) {
		List<ProgramingLanguage> list = service.findAll();
		model.addAttribute("listLanguage", list);
		return "QuanLyDuAn/programinglanguage/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("language", new ProgramingLanguage());
		return "QuanLyDuAn/programinglanguage/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("language") ProgramingLanguage pl,
			final RedirectAttributes redirectAttributes) {
		try {
			service.addNew(pl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/NgonNgu/list-ngonNgu";
	}

	@RequestMapping(value = "/edit/{maLanguage}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("maLanguage") int maLanguage, Model model) {
		model.addAttribute("language", service.findById(maLanguage));
		return "QuanLyDuAn/programinglanguage/edit_form";
	}

	@RequestMapping(value = "/edit/{maLanguage}", method = RequestMethod.POST)
	public String doUpdate(Model model, @ModelAttribute("maLanguage") ProgramingLanguage pl,
			final RedirectAttributes redirectAttributes) {
		try {
			service.update(pl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/NgonNgu/list-ngonNgu";
	}

	@RequestMapping(value = "/delete/{maLanguage}", method = RequestMethod.GET)
	public String delete(@PathVariable("maLanguage") int maLanguage, final RedirectAttributes redirectAttributes) {
		try {
			service.delete(maLanguage);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyDuAn/NgonNgu/list-ngonNgu";
	}
}
