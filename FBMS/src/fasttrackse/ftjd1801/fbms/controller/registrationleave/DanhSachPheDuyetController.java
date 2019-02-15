package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.service.registrationleave.PheDuyetService;

@Controller
@RequestMapping("/QuanLyVangNghi/danhsachduyet")
public class DanhSachPheDuyetController {

	@Autowired
	private PheDuyetService pheDuyetService;
	int search = 0;
	List<RegistrationLeave> listApproved ;
	List<RegistrationLeave> listApprovedPage;


	
	
	@RequestMapping(value =  "/notfound" , method = RequestMethod.GET)
	public String fileNotFound(Model model ) {
			return "QuanLyVangNghi/error-404";
		
	}
	
	
	@RequestMapping(value =  "/{crPage}" , method = RequestMethod.GET)
	public String viewApproved1(Model model,@PathVariable("crPage") String crPage) {	
		 listApproved= pheDuyetService.listApproved("Phê Duyệt");
		 
		 int perPage = 5;	
			int totalList = listApproved.size();
			int totalPage = (int) Math.ceil((float) (totalList) / perPage);
			int currentPage = 1;
				
				if(Integer.parseInt(crPage) < 1) {
					currentPage = 1;
				}else if(Integer.parseInt(crPage) > totalPage) {
					currentPage = totalPage;	
				}else {
					currentPage = Integer.parseInt(crPage);
				}

				listApprovedPage = pheDuyetService.listApprovedPage("Phê Duyệt", currentPage, perPage);
			
				model.addAttribute("listApprovedPage",listApprovedPage);
		        model.addAttribute("currentPage",currentPage);
		        model.addAttribute("totalPage",totalPage);
			return "QuanLyVangNghi/pheduyet/listApproved";
	}	
	
	@RequestMapping(value =  "/search" , method = RequestMethod.GET)
	public String viewApprovedPage(Model model,@RequestParam(value = "search") int searchId) {
		
		listApproved = pheDuyetService.findById(searchId,"Phê Duyệt");
		search = searchId;	
		if(listApproved.size() > 0){
		
			return "redirect:/QuanLyVangNghi/danhsachduyet/search/1";	
		}else{
			return "redirect:/QuanLyVangNghi/danhsachduyet/notfound";
		}
	}
	
	@RequestMapping(value =  "/search/{crPage}" , method = RequestMethod.GET)
	public String viewApproved(Model model,@PathVariable("crPage") String crPage) {
		
		int perPage = 5;	
		int totalList = listApproved.size();
		int totalPage = (int) Math.ceil((float) (totalList) / perPage);
		int currentPage = 1;
			
			if(Integer.parseInt(crPage) < 1) {
				currentPage = 1;
			}else if(Integer.parseInt(crPage) > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = Integer.parseInt(crPage);
			}

			  listApprovedPage = pheDuyetService.listApprovedPage(search, "Phê Duyệt", currentPage, perPage);

			   model.addAttribute("listApprovedPage",listApprovedPage);
		        model.addAttribute("currentPage",currentPage);
		        model.addAttribute("totalPage",totalPage);
			return "QuanLyVangNghi/pheduyet/listApproved";
	}	
	
	

	
}
