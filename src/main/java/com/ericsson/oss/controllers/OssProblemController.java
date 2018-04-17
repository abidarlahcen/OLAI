package com.ericsson.oss.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.services.IOssProblemsService;

@Controller
@RequestMapping (value="/OSSproblems")
public class OssProblemController {
	@RequestMapping (value="/",method = RequestMethod.GET)
	
	
		
		
	
	public String ossproblems(Model model) {
		List<OssProblems> probid = OssProblemsService.findproblemsnotresol();
		if (probid == null) {
			probid = new ArrayList<OssProblems>();
		}
		
		model.addAttribute("probid", probid);
		return "OSSproblems/OSSproblems";
		}
	@Autowired
	private IOssProblemsService OssProblemsService ;
	@RequestMapping(value="/done",method=RequestMethod.POST)

	public  String Alerte(HttpServletRequest request ) throws ParseException   {
		Long id =Long.parseLong(request.getParameter("problemid"));
		String prsol= request.getParameter("proposed_solution");
		OssProblems ossproblems =new OssProblems();
		ossproblems=OssProblemsService.getById(id);
		ossproblems.setProposed_solution(prsol);
		OssProblemsService.update(ossproblems);
		return "redirect:/OSSproblems/";
	}
	
}

