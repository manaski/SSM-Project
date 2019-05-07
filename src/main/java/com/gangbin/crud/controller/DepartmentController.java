package com.gangbin.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gangbin.crud.bean.Department;
import com.gangbin.crud.bean.Message;
import com.gangbin.crud.service.DepartmentService;

 

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Message getDepts(){
		//查出的所有部门信息
		List<Department> list = departmentService.getDepts();
		return Message.success().add("depts", list);
	}
}
