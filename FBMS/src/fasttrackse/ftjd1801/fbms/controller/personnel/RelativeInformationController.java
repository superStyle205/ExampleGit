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

import fasttrackse.ftjd1801.fbms.entity.personnel.RelativeInformation;
import fasttrackse.ftjd1801.fbms.service.personnel.RelativeInformationService;

@Controller
@RequestMapping("/QuanLyNhanSu/thongTinGiaDinh")
public class RelativeInformationController {
	
	String search = "";
	@Autowired
	RelativeInformationService service;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listRelativeInformations(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<RelativeInformation> listAllRelativeInformations = service.findAllRelativeInformations(search);
		if (listAllRelativeInformations.size() < recordEnd) {
			recordEnd = listAllRelativeInformations.size();
		}
		List<RelativeInformation> RelativeInformations = service.getRelativeInformations(currentPage, recordEnd, search);

		int totalPage = (int) Math.ceil((double) listAllRelativeInformations.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("RelativeInformations", RelativeInformations);

		return "QuanLyNhanSu/thongtingiadinh/list";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listRelativeInformations(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<RelativeInformation> listAllRelativeInformations = service.findAllRelativeInformations();
		if (listAllRelativeInformations.size() < recordEnd) {
			recordEnd = listAllRelativeInformations.size();
		}
		List<RelativeInformation> RelativeInformations = service.getRelativeInformations(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllRelativeInformations.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("RelativeInformations", RelativeInformations);

		return "QuanLyNhanSu/thongtingiadinh/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String saveRelativeInformation(ModelMap model) {
		RelativeInformation RelativeInformation = new RelativeInformation();
		model.addAttribute("RelativeInformation", RelativeInformation);
		model.addAttribute("edit", false);
		return "QuanLyNhanSu/thongtingiadinh/add_form";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveRelativeInformation(@Valid RelativeInformation RelativeInformation, BindingResult result, ModelMap model)
			throws IOException {

		service.saveRelativeInformation(RelativeInformation);

		return "redirect:/QuanLyNhanSu/thongTinGiaDinh/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editRelativeInformation(@PathVariable int id, ModelMap model) {
		RelativeInformation emp = service.findById(id);
		model.addAttribute("RelativeInformation", emp);
		model.addAttribute("edit", true);
		return "QuanLyNhanSu/thongtingiadinh/edit_form";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editRelativeInformation(@Valid RelativeInformation RelativeInformation, BindingResult result, ModelMap model)
			throws IOException {

		service.updateRelativeInformation(RelativeInformation);

		return "redirect:/QuanLyNhanSu/thongTinGiaDinh/list";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String removeRelativeInformation(@PathVariable int id, ModelMap model) {
		RelativeInformation emp = service.findById(id);
		model.addAttribute("RelativeInformation", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/thongtingiadinh/delete_form";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String removeRelativeInformation(@Valid RelativeInformation RelativeInformation, BindingResult result, ModelMap model)
			throws IOException {

		service.deleteById(RelativeInformation.getIdRelative());

		return "redirect:/QuanLyNhanSu/thongTinGiaDinh/list";
	}
	
	@RequestMapping(value = { "/viewOne/{id}" }, method = RequestMethod.GET)
	public String viewRelativeInformation(@PathVariable int id, ModelMap model) {
		RelativeInformation emp = service.findById(id);
		model.addAttribute("RelativeInformation", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/thongtingiadinh/viewOne";
	}
}

