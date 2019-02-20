package fasttrackse.ftjd1801.fbms.controller.personnel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import fasttrackse.ftjd1801.fbms.entity.personnel.EmployeeProfile;
import fasttrackse.ftjd1801.fbms.entity.security.ChucDanh;
import fasttrackse.ftjd1801.fbms.entity.security.PhongBan;
import fasttrackse.ftjd1801.fbms.service.personnel.EmployeeProfileService;
import fasttrackse.ftjd1801.fbms.service.security.ChucDanhService;
import fasttrackse.ftjd1801.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/QuanLyNhanSu/hoSoNhanVien")
public class EmployeeProfileController {
	private static final String UPLOAD_DIRECTORY = "E:\\upload";
	String search = "";
	@Autowired
	EmployeeProfileService service;
	
	@Autowired
	PhongBanService phongBanService;
	
	@Autowired
	ChucDanhService chucDanhService;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listEmployeeProfiles(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<EmployeeProfile> listAllEmployeeProfiles = service.findAllEmployeeProfiles(search);
		if (listAllEmployeeProfiles.size() < recordEnd) {
			recordEnd = listAllEmployeeProfiles.size();
		}
		List<EmployeeProfile> EmployeeProfiles = service.getEmployeeProfiles(currentPage, recordEnd, search);

		int totalPage = (int) Math.ceil((double) listAllEmployeeProfiles.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("employeeProfiles", EmployeeProfiles);

		return "QuanLyNhanSu/hosonhanvien/list";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listEmployeeProfiles(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<EmployeeProfile> listAllEmployeeProfiles = service.findAllEmployeeProfiles();
		if (listAllEmployeeProfiles.size() < recordEnd) {
			recordEnd = listAllEmployeeProfiles.size();
		}
		List<EmployeeProfile> EmployeeProfiles = service.getEmployeeProfiles(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllEmployeeProfiles.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("employeeProfiles", EmployeeProfiles);

		return "QuanLyNhanSu/hosonhanvien/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String saveEmployee(ModelMap model) {
		EmployeeProfile EmployeeProfile = new EmployeeProfile();
		List<PhongBan> listPhongBan = phongBanService.findAll();
		List<ChucDanh> listChucDanh = chucDanhService.findAll();
		model.addAttribute("employeeProfile", EmployeeProfile);
		model.addAttribute("listPhongBan",listPhongBan);
		model.addAttribute("listChucDanh", listChucDanh);
		model.addAttribute("edit", false);
		return "QuanLyNhanSu/hosonhanvien/add_form";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveEmployee(@PathParam(value = "chucDanh") String chucDanh, @PathParam(value ="phongBan") String phongBan, @Valid EmployeeProfile employeeProfile, BindingResult result, ModelMap model,
			@RequestParam CommonsMultipartFile file) throws IOException {
		
		if (result.hasErrors()) {
			return "QuanLyNhanSu/hosonhanvien/add_form";
		}
		if (service.isEmployeeProfileIdUnique(employeeProfile.getIdEmployee())) {
			FieldError idError = new FieldError("EmployeeProfile", "idEmployee", message.getMessage("non.unique.id",
					new String[] { String.valueOf(employeeProfile.getIdEmployee()) }, Locale.getDefault()));
			result.addError(idError);
			return "QuanLyNhanSu/hosonhanvien/add_form";
		}

		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			employeeProfile.setAvatar(filename);
		} else {
			employeeProfile.setAvatar("avatar.jpg");
		}
		employeeProfile.setIdDepartment(phongBan);
		employeeProfile.setIdRights(chucDanh);
		service.saveEmployeeProfile(employeeProfile);

		return "redirect:/QuanLyNhanSu/hoSoNhanVien/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, ModelMap model) {
		EmployeeProfile emp = service.findById(id);
		model.addAttribute("employeeProfile", emp);
		model.addAttribute("edit", true);
		return "QuanLyNhanSu/hosonhanvien/edit_form";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editEmployee(@Valid EmployeeProfile EmployeeProfile, BindingResult result, ModelMap model)
			throws IOException {

		service.updateEmployeeProfile(EmployeeProfile);

		return "redirect:/QuanLyNhanSu/hoSoNhanVien/list";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String removeEmployee(@PathVariable int id, ModelMap model) {
		EmployeeProfile emp = service.findById(id);
		model.addAttribute("employeeProfile", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/hosonhanvien/add_form";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String removeEmployee(@Valid EmployeeProfile EmployeeProfile, BindingResult result, ModelMap model)
			throws IOException {

		service.deleteById(EmployeeProfile.getIdEmployee());

		return "redirect:/QuanLyNhanSu/hoSoNhanVien/list";
	}
}
