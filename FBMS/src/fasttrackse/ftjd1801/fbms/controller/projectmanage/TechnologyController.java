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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Technology;
import fasttrackse.ftjd1801.fbms.service.projectmanage.TechnologyService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/CongNghe/list-congNghe")
public class TechnologyController {
	String search = "";
	@Autowired
	TechnologyService service;

	@RequestMapping(value = { "search" }, method = RequestMethod.GET)
	public String getSearch(@PathParam(value = "searchName") String searchName) {
		search = searchName;
		return "redirect:/QuanLyDuAn/CongNghe/list-congNghe/";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewTech(Model model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Technology> listAll = service.listAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Technology> listTech = service.listForPagination(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listTech", listTech);
		return "/QuanLyDuAn/congnghe/list";
	}

	@RequestMapping(value = { "/{page}" }, method = RequestMethod.GET)
	public String list(ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		List<Technology> listAll = service.listAll(search);
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Technology> listTech = service.listForPagination(recordStart, recordEnd, search);
		int nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listTech", listTech);
		return "/QuanLyDuAn/congnghe/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("technology", new Technology());
		model.addAttribute("edit", false);
		return "/QuanLyDuAn/congnghe/form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("technology") Technology tech,
			final RedirectAttributes redirectAttributes) {
		
			service.addNew(tech);

		return "redirect:/QuanLyDuAn/CongNghe/list-congNghe";
	}

	@RequestMapping(value = "/edit/{idTech}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idTech") int idTech, Model model) {
		model.addAttribute("technology", service.findById(idTech));
		model.addAttribute("edit", true);

		return "QuanLyDuAn/congnghe/form";
	}

	@RequestMapping(value = "/edit/{idTech}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("technology") Technology tech,
			final RedirectAttributes redirectAttributes) {

			service.update(tech);

		return "redirect:/QuanLyDuAn/CongNghe/list-congNghe";
	}

	@RequestMapping(value = "/delete/{idTech}", method = RequestMethod.GET)
	public String delete(@PathVariable("idTech") int idTech, ModelMap model) {
		model.addAttribute("technology", service.findById(idTech));
		model.addAttribute("delete", true);
		return "QuanLyDuAn/congnghe/form";
	}

	@RequestMapping(value = "/delete/{idTech}", method = RequestMethod.POST)
	public String doDelete(@PathVariable("idTech") int idTech, final RedirectAttributes redirectAttributes) {

			service.delete(idTech);

		return "redirect:/QuanLyDuAn/CongNghe/list-congNghe";
	}
	@RequestMapping(value="/view/{idTech}", method = RequestMethod.GET)
	public String viewOne (@PathVariable("idTech") int idTech, Model model) {
		model.addAttribute("technology", service.findById(idTech));
		return "QuanLyDuAn/congnghe/viewOne";
	}
}
