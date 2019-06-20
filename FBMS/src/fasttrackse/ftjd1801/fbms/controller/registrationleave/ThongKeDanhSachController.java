package fasttrackse.ftjd1801.fbms.controller.registrationleave;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ftjd1801.fbms.entity.registrationleave.RegistrationLeave;
import fasttrackse.ftjd1801.fbms.service.registrationleave.ThongKeService;

@Controller
@RequestMapping("/QuanLyVangNghi/danhsachngaynghi")
public class ThongKeDanhSachController {

	@Autowired
	private ThongKeService thongKeService;
	int search = 0;
	Date day;
	Date toDay;
	
	
	@RequestMapping(value="/chonngay",method = RequestMethod.GET)  
    public  String chooseDay() {
       
    	return "QuanLyVangNghi/thongkedanhsach/chooseday";
    	
	}
	
	
	@RequestMapping(value="/searchDay",method = RequestMethod.POST)  
    public String Search(@RequestParam(value = "day") @DateTimeFormat(pattern="yyyy-MM-dd") Date beginDate ,
    		@RequestParam(value = "toDay") @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate) {
    	
    	day = beginDate;
    	toDay = endDate;
       
    	return "redirect:/QuanLyVangNghi/danhsachngaynghi/1";
    	
	}
	
	@RequestMapping(value="/search",method = RequestMethod.POST)  
    public String Search(@RequestParam(value = "day") @DateTimeFormat(pattern="yyyy-MM-dd") Date beginDate ,
    		@RequestParam(value = "toDay") @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
    		@RequestParam(value = "searchId") int searchId) {
    	
    	day = beginDate;
    	toDay = endDate;
        search = searchId;
    	return "redirect:/QuanLyVangNghi/danhsachngaynghi/1";
    	
	}
	
	@RequestMapping(value =  "/{crPage}" , method = RequestMethod.GET)
	public String viewApproved(Model model,@PathVariable("crPage") String crPage) {
		
		int perPage = 5;
		List<RegistrationLeave> listRestDay = thongKeService.findByDay(day, toDay, "Phê Duyệt");
		
		if(search!=0) {
			listRestDay = thongKeService.findByDayAndId(search, day, toDay,"Phê Duyệt");
		}
		int totalList = listRestDay.size();
		int totalPage = (int) Math.ceil((float) (totalList) / perPage);
		int currentPage = 1;
			
			if(Integer.parseInt(crPage) < 1) {
				currentPage = 1;
			}else if(Integer.parseInt(crPage) > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = Integer.parseInt(crPage);
			}
		
		 List<RegistrationLeave> listRestDayPage = thongKeService.listRestDayPage(day, toDay, "Phê Duyệt", currentPage, perPage);
		 
		 if(search!=0) {
			 listRestDayPage = thongKeService.listRestDayPageAndId(search, day, toDay, "Phê Duyệt", currentPage, perPage);
			}
		 	model.addAttribute("day", day);
		 	model.addAttribute("toDay", toDay);
	        model.addAttribute("listRestDayPage",listRestDayPage);
	        model.addAttribute("currentPage",currentPage);
	        model.addAttribute("totalPage",totalPage);
	        
		return "QuanLyVangNghi/thongkedanhsach/listRestDay";
	}
	
}
