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

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Database;
import fasttrackse.ftjd1801.fbms.service.projectmanage.DatabaseService;

@Controller
@RequestMapping(value = "/QuanLyDuAn/Database/list-database")
public class DatabaseController {
	String search = "";
	@Autowired
	private DatabaseService databaseService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewDatabase(Model model) {
		int page = 1;
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Database> listAll = databaseService.findAll();
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Database> listDatabase = databaseService.findDatabase(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}
		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listDatabase", listDatabase);
		return "QuanLyDuAn/database/list";
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String list(ModelMap model, @PathVariable int page) {
		int recordsPerPage = 3;
		int recordStart = (page - 1) * recordsPerPage;
		int recordEnd = recordStart + recordsPerPage;
		int nOfPages;
		List<Database> listAll = databaseService.findAll();
		if (listAll.size() < recordEnd) {
			recordEnd = listAll.size();
		}
		List<Database> listDatabase = databaseService.findDatabase(recordStart, recordEnd, search);
		if (recordEnd == 0) {
			nOfPages = 1;
		} else {
			nOfPages = (int) Math.ceil((double) listAll.size() / recordsPerPage);
		}		model.addAttribute("noOfPages", nOfPages);
		model.addAttribute("pageid", page);
		model.addAttribute("listDatabase", listDatabase);
		return "QuanLyDuAn/database/list";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("database", new Database());
		model.addAttribute("edit", false);
		return "/QuanLyDuAn/database/form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("database") Database db,
			final RedirectAttributes redirectAttributes) {
		try {
			databaseService.addNew(db);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại");
		}
		return "redirect:/QuanLyDuAn/Database/list-database";
	}

	@RequestMapping(value = "/edit/{idDatabase}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idDatabase") int idDatabase, Model model) {
		model.addAttribute("database", databaseService.findById(idDatabase));
		model.addAttribute("edit", true);
		return "QuanLyDuAn/database/form";
	}

	@RequestMapping(value = "/edit/{idDatabase}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("database") Database db,
			final RedirectAttributes redirectAttributes) {
		try {
			databaseService.update(db);
			redirectAttributes.addFlashAttribute("messageSuccess", "Sửa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại");
		}
		return "redirect:/QuanLyDuAn/Database/list-database";
	}

	@RequestMapping(value = "/delete/{idDatabase}", method = RequestMethod.GET)
	public String delete(@PathVariable("idDatabase") int idDatabase, ModelMap model) {
		model.addAttribute("database", databaseService.findById(idDatabase));
		model.addAttribute("delete", true);
		return "QuanLyDuAn/database/form";
	}

	@RequestMapping(value = "/delete/{idDatabase}", method = RequestMethod.POST)
	public String doDelete(@PathVariable("idDatabase") int idDatabase, final RedirectAttributes redirectAttributes) {
		try {
			databaseService.delete(idDatabase);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyDuAn/KhachHang/list-database";
	}

}
