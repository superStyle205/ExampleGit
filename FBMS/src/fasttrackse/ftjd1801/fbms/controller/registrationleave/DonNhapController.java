package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.dao.security.UserAccountDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.UserAccount;
import fasttrackse.ftjd1801.fbms.service.registrationleave.SoanDonService;

@Controller
@RequestMapping("/QuanLyVangNghi/soandon/donnhap")
public class DonNhapController {

	@Autowired
	private SoanDonService soanDonService;
	@Autowired
	private UserAccountDao userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewDangKy(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount user = userDao.loadUserByUsername(username);
		List<RegistrationLeave> listDraftById = soanDonService.findListDraftById(user.getMaTaiKhoan());
		model.addAttribute("list", listDraftById);
		return "QuanLyVangNghi/donnhap/listDraftById";
	}

	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idAbsent") int maVangNghi, Model model) {

		model.addAttribute("vangNghi", soanDonService.findByMaVangNghi(maVangNghi));
		return "QuanLyVangNghi/donnhap/edit_form";
	}

	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("maVangNghi") RegistrationLeave rl,
			final RedirectAttributes redirectAttributes) {
		try {
			soanDonService.update(rl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "QuanLyVangNghi/donnhap/message";

	}

	@RequestMapping(value = "/delete/{idAbsent}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("idAbsent") int maVangNghi, Model model,
			final RedirectAttributes redirectAttributes) {
		soanDonService.delete(maVangNghi);
		redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		return "QuanLyVangNghi/donnhap/message";
	}

}
