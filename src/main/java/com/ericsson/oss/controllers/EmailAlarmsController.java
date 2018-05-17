package com.ericsson.oss.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ericsson.oss.entites.Article;
import com.ericsson.oss.entites.Client;
import com.ericsson.oss.entites.CommandeClient;
import com.ericsson.oss.entites.Email_alarms;
import com.ericsson.oss.entites.Idemail_alarms;
import com.ericsson.oss.entites.LigneCommandeClient;
import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.model.ModelCommandeClient;
import com.ericsson.oss.model.StringResponse;
import com.ericsson.oss.services.IArticleService;
import com.ericsson.oss.services.IClientService;
import com.ericsson.oss.services.ICommandeClientService;
import com.ericsson.oss.services.IEmail_alarmsService;
import com.ericsson.oss.services.IFlickrService;
import com.ericsson.oss.services.ILigneCommandeClientService;

@Controller
@RequestMapping(value = "/emailalarms")
public class EmailAlarmsController {
	
	@Autowired
	private IEmail_alarmsService EmailAlarmsService;
	
	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Email_alarms> EmailAlarms = EmailAlarmsService.selectAll();
		if (EmailAlarms == null) {
			EmailAlarms = new ArrayList<Email_alarms>();
		}
		model.addAttribute("EmailAlarms", EmailAlarms);
		return "Email_alarms/Email_alarms";
	}
	@RequestMapping(value = "/nouveau")
	public String ajoutermail(Model model) {
		
		return "Email_alarms/ajouter_email";
	}@RequestMapping(value = "/enregistrer",method=RequestMethod.POST)
	public String enregistrerClient(HttpServletRequest request ) throws ParseException {
		 

			
			String[] res = request.getParameterValues("object" ); 
			for (int i = 0; i < res.length; ++i){ 
				System.out.println(res[i]); 
				
				String name= request.getParameter("name");
				String position= request.getParameter("positin");
				String mail= request.getParameter("mail");
				String company= request.getParameter("company");
				Email_alarms alarm = new Email_alarms();
				Idemail_alarms idemailalarms=new Idemail_alarms(res[i],name,mail);
				alarm.setIdemail_alarms(idemailalarms);
				alarm.setCompany(company);
				alarm.setPosition(position);
				EmailAlarmsService.update(alarm); 
			}
			
			return "redirect:/emailalarms/nouveau";
		}
		
		
	
	
	@RequestMapping(value = "/modifier/{idemail_alarms}")
	public String modifierClient(Model model, @PathVariable Long idemail_alarms) {
		if (idemail_alarms != null) {
			Email_alarms alarmodif = EmailAlarmsService.getById(idemail_alarms);
			if (alarmodif != null) {
				model.addAttribute("alarmodif", alarmodif);
			}
		}
		return "Email_alarms/ajouter_email";
	}
	
	@RequestMapping(value = "/supprimer/{idemail_alarms}")
	public String supprimerClient(Model model, @PathVariable Long idemail_alarms) {
		if (idemail_alarms != null) {
			Email_alarms alarmsup = EmailAlarmsService.getById(idemail_alarms);
			if (alarmsup != null) {
				//TODO Verification avant suppression
				EmailAlarmsService.remove(idemail_alarms);
			}
		}
		return "redirect:/Email_alarms/";
	}
	

}
