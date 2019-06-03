package com.care.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.dto.InfoDTO;
import com.care.scheduler.MyScheduler;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	static int cnt=0;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/*
	public HomeController() {
		String configLocation = "classpath:applicationContext-batch.xml";
		GenericXmlApplicationContext ctx = 
					new GenericXmlApplicationContext(configLocation);
		ctx.getBean("myScheduler",MyScheduler.class);
	}
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("non_ajax")
	public String non_ajax() {
		System.out.println("non_ajax ����");
		return "ajax/non_ajax";
	}
	@RequestMapping("ajax")
	public String ajax() {
		System.out.println("ajax ����");
		return "ajax/ajax";
	}
	@RequestMapping("ajax_result")
	@ResponseBody
	public String ajax_result() {
		System.out.println("ajax_result ����");
		return ++cnt + "";
	}
	@RequestMapping(value="ajax_result01", 
							produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajax_result01(InfoDTO info) {
		System.out.println("ajax_result01 ����");
		System.out.println("�̸� : "+info.getName());
		System.out.println("���� : "+info.getAge());
		return info.getName()+" : "+info.getAge();
	}
	@RequestMapping(value="ajax_json", method=RequestMethod.POST 
						  ,produces="application/json;charset=utf8")
	@ResponseBody 
	public String ajax_json (InfoDTO info)throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaa", "a �̸� : "+info.getName());
		map.put("bbb", "b ���� : "+info.getAge());
		// map���� ���ڿ��� ��� ���� ObjectMapper ����
		ObjectMapper mapper = 
				new com.fasterxml.jackson.databind.ObjectMapper();
		// �ڷḦ ��Ƽ� ���ڿ��� �ٲ��ش� => {aaa:a�Դϴ�, bbb:b�Դϴ�}
		String strJson = mapper.writeValueAsString(map); 
		return strJson; // �ش� json ���ڿ��� ��ȯ�� �ش�.
	}
}











