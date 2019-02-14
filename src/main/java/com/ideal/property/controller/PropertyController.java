package com.ideal.property.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideal.property.service.impl.PropertyServiceImpl;


/**
 * @Auther: alan
 * @Date: 2019年1月25日
 * @Description:
 */

@Controller
public class PropertyController {
	
	@Autowired 
	private PropertyServiceImpl propertyService;
	
	//资产页面展示  2.14
	@RequestMapping("/showPropertys")
	@ResponseBody
	public List<Map> getPropertys(@RequestParam("data") String phoneNum){
		return propertyService.getPropertiesForPage(phoneNum);
	}
	

    
	
	
}
