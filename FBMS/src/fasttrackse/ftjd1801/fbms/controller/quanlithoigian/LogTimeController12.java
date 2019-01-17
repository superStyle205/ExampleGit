package fasttrackse.ftjd1801.fbms.controller.quanlithoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ftjd1801.fbms.entity.quanlithoigian.LogTime;
import fasttrackse.ftjd1801.fbms.service.quanlithoigian.LogTimeService;

@Controller
@RequestMapping("/QuanLyThoiGian/nhanVien")
public class LogTimeController12 {

	private static final String UPLOAD_DIRECTORY = "E:\\upload";
	String search = "";
	@Autowired
	LogTimeService service;

	@Autowired
	MessageSource message;
	
	@RequestMapping(value = { "danhsachchopheduyetlan2/{nPage}" }, method = RequestMethod.GET)
	public String listLogTimes(ModelMap model, @PathVariable int nPage) {
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes(search);
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd,search);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", LogTimes);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachChoPheDuyet2/list";
	}

	@RequestMapping(value = {"/", "danhsachchopheduyetlan2" }, method = RequestMethod.GET)
	public String listLogTimes(ModelMap model) {
		int nPage = 1;
		int perPage = 4;
		int currentPage = (nPage - 1) * perPage;
		int recordEnd = currentPage + perPage;

		List<LogTime> listAllLogTimes = service.findAllLogTimes();
		if (listAllLogTimes.size() < recordEnd) {
			recordEnd = listAllLogTimes.size();
		}
		List<LogTime> LogTimes = service.getLogTimes(currentPage, recordEnd);

		int totalPage = (int) Math.ceil((double) listAllLogTimes.size() / perPage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("crPage", nPage);
		model.addAttribute("LogTimes", listAllLogTimes);

		return "QuanLyThoiGian/ThongKeTinhHinh/DanhSachChoPheDuyet2/list";
	}
}
