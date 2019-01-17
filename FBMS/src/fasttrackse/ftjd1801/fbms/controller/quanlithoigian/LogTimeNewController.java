package fasttrackse.ftjd1801.fbms.controller.quanlithoigian;

import java.io.IOException;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Customer;
import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;
import fasttrackse.ftjd1801.fbms.service.quanlithoigian.LogTimeService;

@Controller
@RequestMapping("/QuanLyThoiGian/nhanVien")
public class LogTimeNewController {

	@Autowired
	LogTimeService service;
	
	@Autowired
	MessageSource message;

	
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		LogTime LogTime = new LogTime();
		model.addAttribute("LogTime", LogTime);
		model.addAttribute("edit", false);
		return "QuanLyThoiGian/ThongKeTinhHinh/New/add";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("LogTime")  LogTime LogTime, ModelMap model) throws IOException {

		service.saveLogTime(LogTime);
		return "redirect:/QuanLyThoiGian/nhanVien/add";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-LogTime" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, ModelMap model) {
		LogTime LogTime = service.findById(id);
		model.addAttribute("LogTime", LogTime);
		model.addAttribute("edit", true);
		return "Add";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-LogTime" }, method = RequestMethod.POST)
	public String editLogTime(@Valid LogTime LogTime, BindingResult result, ModelMap model, @PathVariable int id)
			throws IOException {
		if (result.hasErrors()) {
			return "Add";
		}
		if (!service.isLogTimeIdUnique(LogTime.getIdLog())) {
			FieldError idError = new FieldError("LogTime", "id", message.getMessage("non.unique.id",
					new String[] { String.valueOf(LogTime.getIdLog()) }, Locale.getDefault()));
			result.addError(idError);
			return "Add";
		}

		service.updateLogTime(LogTime);
		return "redirect:/paging";
	}

	/*
	 * This method will delete an employee by it's id value.
	 */
	@RequestMapping(value = { "/delete-{id}-LogTime" }, method = RequestMethod.POST)
	public String delete(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/list";
	}

	@RequestMapping(value = { "/delete-{id}-LogTime" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, ModelMap model) {
		LogTime LogTime = service.findById(id);
		model.addAttribute("LogTime", LogTime);
		model.addAttribute("delete", true);
		return "Add";
	}
}
