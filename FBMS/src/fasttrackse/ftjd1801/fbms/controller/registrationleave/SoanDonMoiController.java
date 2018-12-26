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
public class SoanDonMoiController {
	
	@Autowired
	private VangNghiService vangNghiService;
	

	@RequestMapping(value = "/soandonmoi", method = RequestMethod.GET)
	public String soanDonMoi(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("registrationLeave", new RegistrationLeave());
		return "QuanLyVangNghi/add_form";
	}
	

	@RequestMapping(value = "/soandonmoi", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("registrationLeave") RegistrationLeave rl,
			final RedirectAttributes redirectAttributes) {
		try {
			vangNghiService.addNew(rl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyVangNghi/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewDangKy(Model model) {
		 List<RegistrationLeave> list= vangNghiService.findAll();
	        model.addAttribute("list",list);
	      
         
		return "QuanLyVangNghi/list";
	}
	
	
        
	@RequestMapping(value = "/view/{maVangNghi}", method = RequestMethod.GET)
	public String viewOneVangNghi(@PathVariable("maVangNghi") String maVangNghi, Model model) {
		model.addAttribute("vangNghi", vangNghiService.findByMaVangNghi(maVangNghi));
		return "QuanLyVangNghi/viewOne";
	}
	
	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idAbsent") String maVangNghi, Model model) {
		model.addAttribute("vangNghi", vangNghiService.findByMaVangNghi(maVangNghi));
		return "QuanLyVangNghi/edit_form";
	}

	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("maVangNghi") RegistrationLeave rl,
			final RedirectAttributes redirectAttributes) {
		try {
			vangNghiService.update(rl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyVangNghi/listDrafts";
	}
	
	
	@RequestMapping(value = "/delete/{maVangNghi}", method = RequestMethod.GET)
	public String delete(@PathVariable("maVangNghi") String maVangNghi, final RedirectAttributes redirectAttributes) {
		try {
			vangNghiService.delete(maVangNghi);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyVangNghi/listDrafts";
	}
   
	
}
