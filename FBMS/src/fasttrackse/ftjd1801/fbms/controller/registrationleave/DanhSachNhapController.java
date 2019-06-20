package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.service.registrationleave.DonNhapService;

@Controller
@RequestMapping("/QuanLyVangNghi/danhsachnhap")
public class DanhSachNhapController {
	
	
	
	@Autowired
	private DonNhapService donNhapService;
	int search = 0;
	
	@RequestMapping(value="/search",method = RequestMethod.POST)  
    public String Search(@RequestParam(value = "search") int searchId) {
    	
    	search = searchId;
       
    	return "redirect:/QuanLyVangNghi/danhsachnhap/1";
    	
	}

	@RequestMapping(value =  "/{crPage}" , method = RequestMethod.GET)
	public String viewDraft(Model model,@PathVariable("crPage") String crPage) {
		
		int perPage = 5;
		List<RegistrationLeave> listDrafts= donNhapService.listDrafts("Nháp");
	
		if(search!=0) {
			listDrafts = donNhapService.findById(search,"Nháp");
		}
		int totalList = listDrafts.size();
		int totalPage = (int) Math.ceil((float) (totalList) / perPage);
		int currentPage = 1;
			
			if(Integer.parseInt(crPage) < 1) {
				currentPage = 1;
			}else if(Integer.parseInt(crPage) > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = Integer.parseInt(crPage);
			}

		List<RegistrationLeave> listDraftsPage = donNhapService.listDraftsPage("Nháp", currentPage, perPage);
		
		if(search!=0) {
			listDraftsPage = donNhapService.listDraftsPage(search, "Nháp", currentPage, perPage);
		}
		
		 
		 
		
			
	        model.addAttribute("listDraftsPage",listDraftsPage);
	        model.addAttribute("currentPage",currentPage);
	        model.addAttribute("totalPage",totalPage);
		return "QuanLyVangNghi/donnhap/listDrafts";
	}
	
	
	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idAbsent") int maVangNghi, Model model) {
		model.addAttribute("donNhap", donNhapService.findByMaVangNghi(maVangNghi));
		return "QuanLyVangNghi/donnhap/edit_form";
	}

	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.POST)
	public String doEdit(Model model, RegistrationLeave rl,
			final RedirectAttributes redirectAttributes) {
		try {
			donNhapService.update(rl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyVangNghi/danhsachnhap/1";
	}
	

	@RequestMapping(value = "/delete/{idAbsent}", method = RequestMethod.GET)
	public String delete(@PathVariable("idAbsent") int maVangNghi, 
			final RedirectAttributes redirectAttributes) {
		try {
			donNhapService.delete(maVangNghi);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyVangNghi/danhsachnhap/1";
	}
	
	
	
	
}

	
	