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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Framework;
import fasttrackse.ftjd1801.fbms.service.projectmanage.FrameworkService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/Framework/list-framework")
public class FrameworkController {
	String search = "";
	@Autowired
	FrameworkService frameworkService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String getSearch(@PathParam(value = "search") String searchName) {
		search = searchName;
		return "redirect:/QuanLyDuAn/Framework/list-framework/";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewFrawork(Model model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Framework> listAll = frameworkService.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Framework> listFramework = frameworkService.findFramework(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listFramework", listFramework);
		return "QuanLyDuAn/framework/list";
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String list(ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Framework> listAll = frameworkService.findAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Framework> listFramework = frameworkService.findFramework(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listFramework", listFramework);
		return "QuanLyDuAn/framework/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("framework", new Framework());
		model.addAttribute("edit", false);
		return "QuanLyDuAn/framework/form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("framework") Framework fw,
			final RedirectAttributes redirectAttributes) {
		try {
			frameworkService.addNew(fw);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại");
		}
		return "redirect:/QuanLyDuAn/Framework/list-framework";
	}

	@RequestMapping(value = "/edit/{maFramework}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("maFramework") int maFramework, Model model) {
		model.addAttribute("framework", frameworkService.findById(maFramework));
		model.addAttribute("edit", true);
		return "QuanLyDuAn/framework/form";
	}

	@RequestMapping(value = "/edit/{maFramework}", method = RequestMethod.POST)
	public String doUpdate(Model model, @ModelAttribute("framework") Framework fw,
			final RedirectAttributes redirectAttributes) {
		try {
			frameworkService.update(fw);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/Framework/list-framework";
	}

	@RequestMapping(value = "/delete/{maFramework}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("maFramework") int maFramework, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		model.addAttribute("framework", frameworkService.findById(maFramework));
		model.addAttribute("delete", true);
		return "QuanLyDuAn/framework/form";
	}

	@RequestMapping(value = "/delete/{maFramework}", method = RequestMethod.POST)
	public String doDelete(@PathVariable("maFramework") int maFramework, final RedirectAttributes redirectAttributes) {
		try {
			frameworkService.delete(maFramework);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyDuAn/Framework/list-framework";
	}
	@RequestMapping(value = "view/{maFramework}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("maFramework") int maFramework,ModelMap model) {
		model.addAttribute("framework", frameworkService.findById(maFramework));
		return "QuanLyDuAn/framework/viewOne";
	}
	
}
