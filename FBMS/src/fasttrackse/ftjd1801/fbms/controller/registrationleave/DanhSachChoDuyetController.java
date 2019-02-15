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
import fasttrackse.ftjd1801.fbms.service.registrationleave.ChoDuyetService;

@Controller
@RequestMapping("/QuanLyVangNghi/danhsachcho")
public class DanhSachChoDuyetController {

	@Autowired
	private ChoDuyetService choDuyetService;
	int search = 0;
	
	@RequestMapping(value="/search",method = RequestMethod.POST)  
    public String Search(@RequestParam(value = "search") int searchId) {
    	
    	search = searchId;
       
    	return "redirect:/QuanLyVangNghi/danhsachcho/1";
    	
	}

	@RequestMapping(value =  "/{crPage}" , method = RequestMethod.GET)
	public String viewDraft(Model model,@PathVariable("crPage") String crPage) {
		
		int perPage = 5;
		List<RegistrationLeave> listPending= choDuyetService.listPending("Chờ Duyệt");
	
		if(search!=0) {
			listPending = choDuyetService.findById(search,"Chờ Duyệt");
		}
		int totalList = listPending.size();
		int totalPage = (int) Math.ceil((float) (totalList) / perPage);
		int currentPage = 1;
			
			if(Integer.parseInt(crPage) < 1) {
				currentPage = 1;
			}else if(Integer.parseInt(crPage) > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = Integer.parseInt(crPage);
			}

		List<RegistrationLeave> listPendingPage = choDuyetService.listPendingPage("Chờ Duyệt", currentPage, perPage);
		
		if(search!=0) {
			listPendingPage = choDuyetService.listPendingPage(search, "Chờ Duyệt", currentPage, perPage);
		}
			
	        model.addAttribute("listPendingPage",listPendingPage);
	        model.addAttribute("currentPage",currentPage);
	        model.addAttribute("totalPage",totalPage);
		return "QuanLyVangNghi/choduyet/listPending";
	}
	
	
	
	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idAbsent") int maVangNghi, Model model) {
		model.addAttribute("choDuyet", choDuyetService.findByMaVangNghi(maVangNghi));
		return "QuanLyVangNghi/choduyet/edit_form";
	}

	@RequestMapping(value = "/edit/{idAbsent}", method = RequestMethod.POST)
	public String doEdit(Model model, RegistrationLeave rl,
			final RedirectAttributes redirectAttributes) {
		try {
			choDuyetService.update(rl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyVangNghi/danhsachcho/1";
	}
	
}
