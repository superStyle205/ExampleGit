package fasttrackse.ftjd1801.fbms.controller.quanlithoigian;

import java.util.ArrayList;
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
@RequestMapping("/QuanLyThoiGian/pheDuyet")
public class LogTimeControllerApproved {

	String search = "";
	@Autowired
	LogTimeService service;

	@Autowired
	MessageSource message;

	@RequestMapping(value = { "danhsachchopheduyet" }, method = RequestMethod.GET)
	public String listLogTimes(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();

		List<LogTime> listAllLogTimes = service.findAllLogTimes();

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 6) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/PheDuyet/DanhSachChoPheDuyet/list";
	}

	@RequestMapping(value = { "/", "danhsachpheduyet" }, method = RequestMethod.GET)
	public String listLogTimes6(ModelMap model) {
		List<LogTime> listLog = new ArrayList<LogTime>();

		List<LogTime> listAllLogTimes = service.findAllLogTimes();

		for (int i = 0; i < listAllLogTimes.size(); i++) {
			if (listAllLogTimes.get(i).getStatus() == 3) {
				listLog.add(listAllLogTimes.get(i));
			}
		}

		model.addAttribute("LogTimes", listLog);

		return "QuanLyThoiGian/PheDuyet/DanhSachDaPheDuyet/list";
	}
}
