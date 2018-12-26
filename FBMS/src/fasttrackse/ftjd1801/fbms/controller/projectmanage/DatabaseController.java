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
	@Autowired
	private DatabaseService databaseService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String viewDatabase(Model model) {
		List<Database> listAll = databaseService.findAll();
		model.addAttribute("listDatabase", listAll);
		return "QuanLyDuAn/database/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("database", new Database());
		return "/QuanLyDuAn/database/add_form";
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
		return "QuanLyDuAn/database/edit_form";
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
	public String delete(@PathVariable("idDatabase") int idDatabase, final RedirectAttributes redirectAttributes) {
		try {
			databaseService.delete(idDatabase);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Thử lại");
		}
		return "redirect:/QuanLyDuAn/Database/list-database";
	}
}
