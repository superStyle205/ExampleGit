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

import fasttrackse.ftjd1801.fbms.entity.personnel.Certificate;
import fasttrackse.ftjd1801.fbms.service.personnel.CertificateService;

@Controller
@RequestMapping("/QuanLyNhanSu/thongTinChungChi")
public class CertificateController {
	@SuppressWarnings("unused")
	private static final String UPLOAD_DIRECTORY = "E:\\upload";
	String search = "";
	@Autowired
	CertificateService service;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listCertificates(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<Certificate> listAllCertificates = service.findAllCertificates(search);
		if (listAllCertificates.size() < recordEnd) {
			recordEnd = listAllCertificates.size();
		}
		List<Certificate> Certificates = service.getCertificates(currentPage, recordEnd, search);

		int totalPage = (int) Math.ceil((double) listAllCertificates.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("Certificates", Certificates);

		return "QuanLyNhanSu/thongtinchungchi/list";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listCertificates(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<Certificate> listAllCertificates = service.findAllCertificates();
		if (listAllCertificates.size() < recordEnd) {
			recordEnd = listAllCertificates.size();
		}
		List<Certificate> Certificates = service.getCertificates(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllCertificates.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("Certificates", Certificates);

		return "QuanLyNhanSu/thongtinchungchi/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String saveCertificate(ModelMap model) {
		Certificate Certificate = new Certificate();
		model.addAttribute("Certificate", Certificate);
		model.addAttribute("edit", false);
		return "QuanLyNhanSu/thongtinchungchi/add_form";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveCertificate(@Valid Certificate Certificate, BindingResult result, ModelMap model)
			throws IOException {

		service.saveCertificate(Certificate);

		return "redirect:/QuanLyNhanSu/thongTinChungChi/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editCertificate(@PathVariable int id, ModelMap model) {
		Certificate emp = service.findById(id);
		model.addAttribute("Certificate", emp);
		model.addAttribute("edit", true);
		return "QuanLyNhanSu/thongtinchungchi/edit_form";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editCertificate(@Valid Certificate Certificate, BindingResult result, ModelMap model)
			throws IOException {

		service.updateCertificate(Certificate);

		return "redirect:/QuanLyNhanSu/thongTinChungChi/list";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String removeCertificate(@PathVariable int id, ModelMap model) {
		Certificate emp = service.findById(id);
		model.addAttribute("Certificate", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/thongtinchungchi/delete_form";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String removeCertificate(@Valid Certificate Certificate, BindingResult result, ModelMap model)
			throws IOException {

		service.deleteById(Certificate.getIdCertificate());

		return "redirect:/QuanLyNhanSu/thongTinChungChi/list";
	}
	
	@RequestMapping(value = { "/viewOne/{id}" }, method = RequestMethod.GET)
	public String viewCertificate(@PathVariable int id, ModelMap model) {
		Certificate emp = service.findById(id);
		model.addAttribute("Certificate", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/thongtinchungchi/viewOne";
	}
}
