package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/QuanLyVangNghi/soandon/danhsachdon")
public class DanhSachDonController {
	
	@Autowired
	private SoanDonService soanDonService;
	@Autowired
	private UserAccountDao userDao;
	int search = 0;
	String status = "";
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewDanhSachDon(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount user = userDao.loadUserByUsername(username);
		 List<RegistrationLeave> listById= soanDonService.findListById(user.getMaTaiKhoan());
	        model.addAttribute("list",listById);
		return "redirect:/QuanLyVangNghi/soandon/danhsachdon/1";
	}
	

	@RequestMapping(value =  "/{crPage}" , method = RequestMethod.GET)
	public String viewDraft(Model model,@PathVariable("crPage") int crPage) {
		
		int perPage = 5;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount user = userDao.loadUserByUsername(username);
		List<RegistrationLeave> listById= soanDonService.findListById(user.getMaTaiKhoan());
		
		if(search!=0) {
			
			listById = soanDonService.findByIdAbsent(search,user.getMaTaiKhoan(),status);
		}
		int totalList = listById.size();
		int totalPage = (int) Math.ceil((float) (totalList) / perPage);
		int currentPage = 1;
			
			if(crPage < 1) {
				currentPage = 1;
			}else if(crPage > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = crPage;
			}

		List<RegistrationLeave> listPage = soanDonService.listPage(status, user.getMaTaiKhoan(), currentPage, perPage);
		
		if(search!=0) {
			listPage = soanDonService.listPage(search, status, user.getMaTaiKhoan(), currentPage, perPage);
		}
			
	        model.addAttribute("listPage",listPage);
	        model.addAttribute("currentPage",currentPage);
	        model.addAttribute("totalPage",totalPage);
		return "QuanLyVangNghi/soandon/listById";
	}
	
	

	
}
