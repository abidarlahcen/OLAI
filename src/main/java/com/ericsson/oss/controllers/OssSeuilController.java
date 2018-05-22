package com.ericsson.oss.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.oss.entites.Df_kh_Seuil;
import com.ericsson.oss.services.IDf_kh_SeuilService;
import com.ericsson.oss.services.IDmr_dmtoolService;

@Controller
@RequestMapping (value="/Seuil")
public class OssSeuilController {
	
	String PbMineur;
	String PbMajeur;
	String PbCritique;
	@Autowired 
	private IDf_kh_SeuilService DfSeuilService ;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {

        return "Seuil/Seuil";
    }
	
	@RequestMapping(value="/Seuil",method=RequestMethod.POST)
	public  String ossSeuildfController(HttpServletRequest request) throws ParseException   {
		
		Df_kh_Seuil DfSeuil = new Df_kh_Seuil();
		
		PbMineur =request.getParameter("mineur");
		PbMajeur =request.getParameter("majeur");
		PbCritique =request.getParameter("critique");
		
		Float Mineur=Float.parseFloat(PbMineur);
		Float Majeur=Float.parseFloat(PbMajeur);
		Float Critique=Float.parseFloat(PbCritique);
		
		DfSeuil.setIdDfSeuil(Long.parseLong("1"));
		DfSeuil.setDfSeuilCriticalPb(Critique);
		DfSeuil.setDfSeuilMajorPb(Majeur);
		DfSeuil.setDfSeuilMinorPb(Mineur);
		
		DfSeuilService.update(DfSeuil);
		
		
		return "Seuil/Seuil";

	}
}

