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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Project;
import fasttrackse.ftjd1801.fbms.service.projectmanage.DatabaseService;
import fasttrackse.ftjd1801.fbms.service.projectmanage.DomainService;
import fasttrackse.ftjd1801.fbms.service.projectmanage.FrameworkService;
import fasttrackse.ftjd1801.fbms.service.projectmanage.ProgramingLanguageService;
import fasttrackse.ftjd1801.fbms.service.projectmanage.ProjectService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/DuAn")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	DatabaseService databaseService;
	@Autowired
	FrameworkService frameworkService;
	@Autowired
	ProgramingLanguageService languageService;
	@Autowired
	DomainService domainService;
	String search = "";

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewProject(Model model) {
		List<Project> list = projectService.listAll();
		model.addAttribute("listProject", list);
		return "QuanLyDuAn/duan/list";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("id") int id, Model model) {
		model.addAttribute("project", projectService.findById(id));
		return "QuanLyDuAn/duan/viewOne";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("listDomain", domainService.findAll(search));
		model.addAttribute("database", databaseService.findAll(search));
		model.addAttribute("framework", frameworkService.findAll(search));
		model.addAttribute("Language", languageService.findAll(search));
		return "QuanLyDuAn/duan/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("project") Project project,
			final RedirectAttributes redirectAttributes) {
		try {
			projectService.addNew(project);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công ...");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại..");
		}
		return "redirect:/QuanLyDuAn/DuAn/";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute(projectService.findById(id));
		return "QuanLyDuAn/duan/edit_form";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("project") Project project,
			final RedirectAttributes redirectAttributes) {
		try {
			projectService.update(project);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công....");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi, xin thử lại");
		}
		return "redirect:/QuanLyDuAn/DuAn";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		try {
			projectService.delete(id);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công ..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi, xin thử lại ..");
		}
		return "redirect:/QuanLyDuAn/DuAn";
	}
}
