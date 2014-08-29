package com.lazyload.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lazyload.model.Person;
import com.lazyload.model.Persons;

@Controller
public class LazyController {

	@RequestMapping(value="/lazyLoad.htm")
	public ModelAndView lazyLoad(HttpServletRequest request, HttpServletResponse response){
			request.setAttribute("personList", new Persons());
			return new ModelAndView("Home");
		
	}
		
	@RequestMapping(value="/filterPersonByName.htm")
	public ModelAndView filterPersonByName(HttpServletRequest request, HttpServletResponse response){
			
			String personName = request.getParameter("personName");
			request.setAttribute("personName", personName);
			request.setAttribute("filter", "personName=" + personName);
			
			request.setAttribute("personList", new Persons());
			
			return new ModelAndView("Home");
		
	}
	
	@RequestMapping(value="/submit.htm")
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response, Persons persons) throws Exception{
			
			try{
				
				//SElECTED RECORDS
				for(Person person : persons.getPersons()){
					System.out.println("------------------" + person.getUserId() + "----------------------");
					System.out.println("Person Name : " + person.getPersonName());
					System.out.println("Address : " + person.getAddress());
					System.out.println("Selected Hobby : " + person.getSelectedHobby());
					System.out.println("Remarks : " + person.getRemarks());
					System.out.println("------------------------------------------------------------------");
				}
				
				request.setAttribute("personList", persons.getPersons());
			}catch(Exception e){
				throw new Exception(e);				
			}
			return new ModelAndView("submittedRecords");
		
	}
	
}
