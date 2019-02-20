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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.ProgramingLanguage;
import fasttrackse.ftjd1801.fbms.service.projectmanage.ProgramingLanguageService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/NgonNgu/list-ngonNgu")
public class ProgramingLanguageController {
	String search="";
	
	@Autowired
	ProgramingLanguageService service;
	
	@RequestMapping(value = "search",method = RequestMethod.GET)
	public String getSearch (@PathParam("search") String searchName) {
		search = searchName;
		return "redirect:/QuanLyDuAn/NgonNgu/list-ngonNgu";
	}
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewLanguage(Model model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<ProgramingLanguage> listAll = service.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<ProgramingLanguage> list = service.findProgramingLanguage(recordStart	, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listLanguage", list);
		return "QuanLyDuAn/programinglanguage/list";
	}
	@RequestMapping(value = "/{page}",method = RequestMethod.GET)
	public String list (ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<ProgramingLanguage> listAll = service.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<ProgramingLanguage> list = service.findProgramingLanguage(recordStart	, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listLanguage", list);
		return "QuanLyDuAn/programinglanguage/list";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("language", new ProgramingLanguage());
		model.addAttribute("edit", false);
		return "QuanLyDuAn/programinglanguage/form";
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
		model.addAttribute("edit", true);
		return "QuanLyDuAn/programinglanguage/form";
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
	@RequestMapping(value = "/delete/{maLanguage}",method = RequestMethod.GET)
	public String deleteForm(@PathVariable("maLanguage") int maLanguage, ModelMap model) {
		model.addAttribute("language", service.findById(maLanguage));
		model.addAttribute("delete", true);
		return "QuanLyDuAn/programinglanguage/form";
	}
	@RequestMapping(value = "/delete/{maLanguage}", method = RequestMethod.POST)
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
