package fasttrackse.ftjd1801.fbms.controller.personnel;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ftjd1801.fbms.entity.personnel.Experience;
import fasttrackse.ftjd1801.fbms.service.personnel.ExperienceService;

@Controller
@RequestMapping("/QuanLyNhanSu/kinhNghiemDuAn")
public class ExperienceController {

	String search = "";
	@Autowired
	ExperienceService service;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listExperiences(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<Experience> listAllExperiences = service.findAllExperiences(search);
		if (listAllExperiences.size() < recordEnd) {
			recordEnd = listAllExperiences.size();
		}
		List<Experience> Experiences = service.getExperiences(currentPage, recordEnd, search);

		int totalPage = (int) Math.ceil((double) listAllExperiences.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("Experiences", Experiences);

		return "QuanLyNhanSu/quanlykinhnghiem/list";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listExperiences(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<Experience> listAllExperiences = service.findAllExperiences();
		if (listAllExperiences.size() < recordEnd) {
			recordEnd = listAllExperiences.size();
		}
		List<Experience> Experiences = service.getExperiences(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllExperiences.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("Experiences", Experiences);

		return "QuanLyNhanSu/quanlykinhnghiem/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String saveExperience(ModelMap model) {
		Experience Experience = new Experience();
		model.addAttribute("Experience", Experience);
		model.addAttribute("edit", false);
		return "QuanLyNhanSu/quanlykinhnghiem/add_form";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveExperience(@Valid Experience Experience, BindingResult result, ModelMap model)
			throws IOException {

		service.saveExperience(Experience);

		return "redirect:/QuanLyNhanSu/kinhNghiemDuAn/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editExperience(@PathVariable int id, ModelMap model) {
		Experience emp = service.findById(id);
		model.addAttribute("Experience", emp);
		model.addAttribute("edit", true);
		return "QuanLyNhanSu/quanlykinhnghiem/edit_form";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editExperience(@Valid Experience Experience, BindingResult result, ModelMap model)
			throws IOException {

		service.updateExperience(Experience);

		return "redirect:/QuanLyNhanSu/kinhNghiemDuAn/list";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String removeExperience(@PathVariable int id, ModelMap model) {
		Experience emp = service.findById(id);
		model.addAttribute("Experience", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/quanlykinhnghiem/delete_form";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String removeExperience(@Valid Experience Experience, BindingResult result, ModelMap model)
			throws IOException {

		service.deleteById(Experience.getIdExperience());

		return "redirect:/QuanLyNhanSu/kinhNghiemDuAn/list";
	}
	
	@RequestMapping(value = { "/viewOne/{id}" }, method = RequestMethod.GET)
	public String viewExperience(@PathVariable int id, ModelMap model) {
		Experience emp = service.findById(id);
		model.addAttribute("Experience", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/quanlykinhnghiem/viewOne";
	}
}
