package fasttrackse.ftjd1801.fbms.controller.personnel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ftjd1801.fbms.entity.personnel.LaborContract;
import fasttrackse.ftjd1801.fbms.service.personnel.LaborContractService;

@Controller
@RequestMapping("/QuanLyNhanSu/hopDong")
public class LaborContractController {

	String search = "";
	@Autowired
	LaborContractService service;

	@Autowired
	MessageSource message;

	List<String> loaiHopDong = new ArrayList<String>();
	List<Integer> listNgay = new ArrayList<Integer>();
	
	@RequestMapping(value = { "list/{nPage}" }, method = RequestMethod.GET)
	public String listLaborContracts(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LaborContract> listAllLaborContracts = service.findAllLaborContracts(search);
		if (listAllLaborContracts.size() < recordEnd) {
			recordEnd = listAllLaborContracts.size();
		}
		List<LaborContract> LaborContracts = service.getLaborContracts(currentPage, recordEnd, search);

		int totalPage = (int) Math.ceil((double) listAllLaborContracts.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LaborContracts", LaborContracts);

		return "QuanLyNhanSu/hopdonglaodong/list";
	}

	@RequestMapping(value = { "/", "list" }, method = RequestMethod.GET)
	public String listLaborContracts(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LaborContract> listAllLaborContracts = service.findAllLaborContracts();
		if (listAllLaborContracts.size() < recordEnd) {
			recordEnd = listAllLaborContracts.size();
		}
		List<LaborContract> LaborContracts = service.getLaborContracts(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLaborContracts.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LaborContracts", LaborContracts);

		return "QuanLyNhanSu/hopdonglaodong/list";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String saveLaborContract(ModelMap model) {
		LaborContract LaborContract = new LaborContract();
		loaiHopDong.removeAll(loaiHopDong);
		listNgay.removeAll(listNgay);
		for(int i = 0; i <=13; i++) {
			listNgay.add(i);
		}
		loaiHopDong.add("Dài hạn");
		loaiHopDong.add("Ngắn hạn");
		loaiHopDong.add("Thử việc");
		model.addAttribute("listLoai",loaiHopDong);
		model.addAttribute("listNgay",listNgay);
		model.addAttribute("LaborContract", LaborContract);
		model.addAttribute("edit", false);
		return "QuanLyNhanSu/hopdonglaodong/add_form";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveLaborContract(@Valid LaborContract LaborContract, BindingResult result, ModelMap model)
			throws IOException {

		service.saveLaborContract(LaborContract);

		return "redirect:/QuanLyNhanSu/hopDong/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editLaborContract(@PathVariable int id, ModelMap model) {
		LaborContract emp = service.findById(id);
		loaiHopDong.removeAll(loaiHopDong);
		listNgay.removeAll(listNgay);
		for(int i = 0; i <=13; i++) {
			listNgay.add(i);
		}
		loaiHopDong.add("Dài hạn");
		loaiHopDong.add("Ngắn hạn");
		loaiHopDong.add("Thử việc");
		model.addAttribute("listLoai",loaiHopDong);
		model.addAttribute("listNgay",listNgay);
		model.addAttribute("LaborContract", emp);
		model.addAttribute("edit", true);
		return "QuanLyNhanSu/hopdonglaodong/edit_form";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editLaborContract(@Valid LaborContract LaborContract, BindingResult result, ModelMap model)
			throws IOException {

		service.updateLaborContract(LaborContract);

		return "redirect:/QuanLyNhanSu/hopDong/list";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String removeLaborContract(@PathVariable int id, ModelMap model) {
		LaborContract emp = service.findById(id);
		loaiHopDong.removeAll(loaiHopDong);
		listNgay.removeAll(listNgay);
		for(int i = 0; i <=13; i++) {
			listNgay.add(i);
		}
		loaiHopDong.add("Dài hạn");
		loaiHopDong.add("Ngắn hạn");
		loaiHopDong.add("Thử việc");
		model.addAttribute("listLoai",loaiHopDong);
		model.addAttribute("listNgay",listNgay);
		model.addAttribute("LaborContract", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/hopdonglaodong/delete_form";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String removeLaborContract(@Valid LaborContract LaborContract, BindingResult result, ModelMap model)
			throws IOException {

		service.deleteById(LaborContract.getIdContract());

		return "redirect:/QuanLyNhanSu/hopDong/list";
	}
	
	@RequestMapping(value = { "/viewOne/{id}" }, method = RequestMethod.GET)
	public String viewLaborContract(@PathVariable int id, ModelMap model) {
		LaborContract emp = service.findById(id);
		loaiHopDong.removeAll(loaiHopDong);
		listNgay.removeAll(listNgay);
		for(int i = 0; i <=13; i++) {
			listNgay.add(i);
		}
		loaiHopDong.add("Dài hạn");
		loaiHopDong.add("Ngắn hạn");
		loaiHopDong.add("Thử việc");
		model.addAttribute("listLoai",loaiHopDong);
		model.addAttribute("listNgay",listNgay);
		model.addAttribute("LaborContract", emp);
		model.addAttribute("delete", true);
		return "QuanLyNhanSu/hopdonglaodong/viewOne";
	}
}
