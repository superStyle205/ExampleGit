package fasttrackse.ftjd1801.fbms.controller.quanlithoigian;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import fasttrackse.ftjd1801.fbms.entity.personnel.EmployeeProfile;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.Project;
import fasttrackse.ftjd1801.fbms.entity.projectmanage.RoleAll;
import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;
import fasttrackse.ftjd1801.fbms.service.personnel.EmployeeProfileService;
import fasttrackse.ftjd1801.fbms.service.projectmanage.ProjectService;
import fasttrackse.ftjd1801.fbms.service.projectmanage.RoleAllService;
import fasttrackse.ftjd1801.fbms.service.quanlithoigian.LogTimeService;

@Controller
@RequestMapping("/QuanLyThoiGian/nhanVien")
public class LogTimeControllerStatistical {

	String search = "";

	@Autowired
	LogTimeService service;

	@Autowired
	EmployeeProfileService servicePer;
	
	@Autowired
	RoleAllService serviceRole;
	
	@Autowired
	ProjectService servicePro;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		LogTime LogTime = new LogTime();
		List<Project> list=servicePro.listAll();
		List<EmployeeProfile> listEmpl=servicePer.findAllEmployeeProfiles();
		List<RoleAll> listRole= serviceRole.findAll();
		model.addAttribute("LogTime", LogTime);
		model.addAttribute("servicePro",list );
		model.addAttribute("servicePer", listEmpl);
		model.addAttribute("serviceRole", listRole);
		
		model.addAttribute("edit", false);
		return "QuanLyThoiGian/ThongKeTinhHinh/New/add";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("LogTime") LogTime LogTime, ModelMap model) throws IOException {

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

	@RequestMapping(value = { "/", "danhsachchopheduyetlan1" }, method = RequestMethod.GET)
	public String listLogTimes(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes();
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 1) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachChoPheDuyet1/list";
	}

	@RequestMapping(value = { "/", "danhsachchopheduyetlan2" }, method = RequestMethod.GET)
	public String listLogTimes2(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes();
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 2) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachChoPheDuyet2/list";
	}

	@RequestMapping(value = { "/", "danhsachdapheduyet" }, method = RequestMethod.GET)
	public String listLogTimes3(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes();
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 3) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachDaPheDuyet/list";
	}

	@RequestMapping(value = { "/", "danhsachnhap" }, method = RequestMethod.GET)
	public String listLogTimes4(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes();
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 4) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachNhap/list";
	}

	@RequestMapping(value = { "/", "danhsachbituchoi" }, method = RequestMethod.GET)
	public String listLogTimes5(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes();
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 5) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachBiTuChoi/list";
	}
}
