package com.trillon.camp.schedule.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@RequestMapping("/calendar")
	public void calendarPage() {
		System.out.println("calendar.jsp");
	}
	
	@RequestMapping("/schedulePopUp")
	public void schedulePopUp() {
		System.out.println("schedulePopUp.jsp");
	}
	
	@ResponseBody
	@RequestMapping(value="/get.do")
	public List ajax() {
		
		
		//테스트 데이터
//		HashMap<String, String> data = new HashMap<String, String>();
//		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
//
//		data.put("reservationTitle","study");
//		data.put("reservationDate","2023-03-23");
//		data.put("reservationDateEnd","2023-03-24");
//		data.put("reservationTime","13:30:00");
//		data.put("reservationIdx","1");
//		data.put("reservationDetail","test");
//		
//		list.add(data);
		Map data;
		
		List<Object> list = new ArrayList<Object>();
		
		data = new HashMap();
		data.put("reservationTitle","camping");
		data.put("reservationDate","2023-03-23");
		data.put("reservationDateEnd","2023-03-24");
		data.put("reservationTime","13:30:00");
		data.put("reservationIdx","1");
		data.put("reservationDetail","test");
		list.add(data);
		
		data = new HashMap();
		data.put("reservationTitle","study");
		data.put("reservationDate","2023-03-27");
		data.put("reservationDateEnd","2023-03-28");
		data.put("reservationTime","13:30:00");
		data.put("reservationIdx","2");
		data.put("reservationDetail","test2");
		list.add(data);
		
		System.out.println("실행되나요");
		return list;
		
	}
	
	@PostMapping("/addTodo")
	public String addTodo(@RequestParam("title") String title,@RequestParam("dateStart") String dateStart,
			@RequestParam("dateEnd") String dateEnd,
			@RequestParam("timeStart") String timeStart) {
		
		System.out.println(title);
		System.out.println(dateStart);
		System.out.println(dateEnd);
		System.out.println(timeStart);
		
		
		return "redirect:/schedule/calendar";
	}
	
	
}
