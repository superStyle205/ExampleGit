package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.service.registrationleave.TuChoiService;

@Controller
@RequestMapping("/QuanLyVangNghi/danhsachbituchoi")
public class DanhSachTuChoiController {

	@Autowired
	private TuChoiService tuChoiService;
	int search = 0;
	
	@RequestMapping(value="/search",method = RequestMethod.POST)  
    public String Search(@RequestParam(value = "search") int searchId) {
    	
    	search = searchId;
       
    	return "redirect:/QuanLyVangNghi/danhsachbituchoi/1";
    	
	}

	@RequestMapping(value =  "/{crPage}" , method = RequestMethod.GET)
	public String viewRefused(Model model,@PathVariable("crPage") String crPage) {
		
		int perPage = 5;
		List<RegistrationLeave> listRefused= tuChoiService.listRefused("Từ Chối");
	
		if(search!=0) {
			listRefused = tuChoiService.findById(search,"Từ Chối");
		}
		int totalList = listRefused.size();
		int totalPage = (int) Math.ceil((float) (totalList) / perPage);
		int currentPage = 1;
			
			if(Integer.parseInt(crPage) < 1) {
				currentPage = 1;
			}else if(Integer.parseInt(crPage) > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = Integer.parseInt(crPage);
			}

		List<RegistrationLeave> listRefusedPage = tuChoiService.listRefusedPage("Từ Chối", currentPage, perPage);
		
		if(search!=0) {
			listRefusedPage = tuChoiService.listRefusedPage(search, "Từ Chối", currentPage, perPage);
		}
			
		if(listRefusedPage.size() > 0) {
			  model.addAttribute("listRefusedPage",listRefusedPage);
		        model.addAttribute("currentPage",currentPage);
		        model.addAttribute("totalPage",totalPage);
			return "QuanLyVangNghi/tuchoi/listRefused";
		}else{
			String comeBack = "FBMS/QuanLyVangNghi/danhsachbituchoi/1";
			model.addAttribute("comeBack",comeBack );
			return "QuanLyVangNghi/error-404";
		}
	      
		
		
		
	}
	
	
	

	
}
