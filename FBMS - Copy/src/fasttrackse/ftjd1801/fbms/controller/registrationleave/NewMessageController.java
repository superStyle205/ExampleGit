package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.service.registrationleave.RegistrationLeaveService;

@Controller
@RequestMapping("/QuanLyVangNghi")
public class NewMessageController {
	
	@Autowired
	private RegistrationLeaveService registrationLeaveService;

	@RequestMapping(value = "/soandonmoi", method = RequestMethod.GET)
	public String soanDonMoi(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("registrationLeave", new RegistrationLeave());
		return "RegistrationLeave/newmessage";
	}
	

	@RequestMapping(value = "/soandonmoi", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("registrationLeave") RegistrationLeave rl,
			final RedirectAttributes redirectAttributes) {
		try {
			registrationLeaveService.addNew(rl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyVangNghi/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewDangKy(Model model) {
		 List<RegistrationLeave> list= registrationLeaveService.getEmployees();
	        
	      
         
		return "RegistrationLeave/list";
	}
	
        
   
	
}
