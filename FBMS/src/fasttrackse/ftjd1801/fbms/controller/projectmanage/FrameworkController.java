package fasttrackse.ftjd1801.fbms.controller.projectmanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftjd1801.fbms.entity.projectmanage.Framework;
import fasttrackse.ftjd1801.fbms.service.projectmanage.FrameworkService;

@Controller
@RequestMapping(value="/QuanLyDuAn/Framework/list-framework")
public class FrameworkController {
	@Autowired
	FrameworkService frameworkService;
	
	@RequestMapping(value= {"","/"},method = RequestMethod.GET)
	public String viewFrawork(Model model) {
		List<Framework> listAll = frameworkService.findAll();
		model.addAttribute("listFramework",listAll);
		return "QuanLyDuAn/framework/list";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("framework", new Framework());
		return "QuanLyDuAn/framework/add_form";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String doAdd(Model model,@ModelAttribute("framework") Framework fw,final RedirectAttributes redirectAttributes) {
		frameworkService.addNew(fw);
		return "redirect:/QuanLyDuAn/Framework/list-framework";
	}
	
	@RequestMapping(value="/edit/{maFramework}",method = RequestMethod.GET)
	public String updateForm(@PathVariable("maFramework") int maFramework,Model model) {
		model.addAttribute("framework", frameworkService.findById(maFramework));
		return "QuanLyDuAn/framework/edit_form";
	}
	
	@RequestMapping(value="/edit/{maFramework}",method = RequestMethod.POST)
	public String doUpdate(Model model,@ModelAttribute("framework") Framework fw,final RedirectAttributes redirectAttributes) {

			frameworkService.update(fw);

		return "redirect:/QuanLyDuAn/Framework/list-framework";
	}
	
	@RequestMapping(value="/delete/{maFramework}",method = RequestMethod.GET)
	public String delete(@PathVariable("maFramework") int maFramework,final RedirectAttributes redirectAttributes) {
		try {
			frameworkService.delete(maFramework);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyDuAn/Framework/list-framework";
	}
}
