package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.dao.security.UserAccountDao;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.LaborContract;
import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.entity.security.UserAccount;
import fasttrackse.ftjd1801.fbms.service.registrationleave.SoanDonService;

@Controller
@RequestMapping("/QuanLyVangNghi/soandon/soandonmoi")
public class SoanDonController {
	
	@Autowired
	private SoanDonService soanDonService;
	@Autowired
	private UserAccountDao userDao;

	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String soanDonMoi(Model model, final RedirectAttributes redirectAttributes) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication().getName();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount user = userDao.loadUserByUsername(username);
		
		RegistrationLeave registrationLeave = new RegistrationLeave();
		registrationLeave.setIdEmployee(user.getMaTaiKhoan());
		model.addAttribute("registrationLeave", registrationLeave);
		
		LaborContract lb = soanDonService.dayOfRest(user.getMaTaiKhoan());	
	
		model.addAttribute("laborContract",lb );
		return "QuanLyVangNghi/soandon/add_form";
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("registrationLeave") RegistrationLeave rl,
			@RequestParam("dayOfRest") int dayOfRest, @RequestParam("idContract") int idContract,
			final RedirectAttributes redirectAttributes) {
		try {			
			if(dayOfRest >= rl.getTotalDay()) {
				soanDonService.addNew(rl,dayOfRest,idContract);
				redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
				 return "QuanLyVangNghi/soandon/message";
			}else {
				redirectAttributes.addFlashAttribute("messageError", "Số ngày nghĩ lớn hơn số ngày còn lại");
				return "QuanLyVangNghi/soandon/add_form";
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "QuanLyVangNghi/soandon/add_form";
		}
		
	}

}
