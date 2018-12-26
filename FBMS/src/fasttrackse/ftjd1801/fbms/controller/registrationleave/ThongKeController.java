package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.service.registrationleave.VangNghiService;

@Controller
@RequestMapping("/QuanLyVangNghi")
public class ThongKeController {
	
	@Autowired
	private VangNghiService vangNghiService;

	@RequestMapping(value = "/danhsachnhap", method = RequestMethod.GET)
	public String viewDraft(Model model) {
		 List<RegistrationLeave> listDrafts= vangNghiService.listDrafts("Nháp");
		
	        model.addAttribute("listDrafts",listDrafts);
	      
         
		return "QuanLyVangNghi/listDrafts";
	}
	
	
	
	
}

	
	