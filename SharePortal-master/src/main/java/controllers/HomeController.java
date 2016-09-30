package controllers;


import org.springframework.stereotype.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.StudentService;
import com.google.gson.Gson;

import model.Student;

@EnableWebMvc
@Controller
public class HomeController

{
	
	
	@RequestMapping("/")
	public String home()
	{
		return "/index";
	}

	@RequestMapping("/register")
	public String signup()
	{
		return "signup";
	}

	@RequestMapping("/login")
	public String sigin()
	{
		return "login";
	}
	
	/*	@Autowired 
		private ChatMessageService chatseervice;
*/		
		String name;
		@Autowired
		StudentService custs;
		
	/*	@Autowired
		MailConfirmationService mailConfirm;*/
		
		

		

		@RequestMapping("/signup")
		public String openRegister()
		{
			return "signup";
		}
		
		@ModelAttribute("cust")
		public Student returnObject()
		{
			return new Student();
		}
		
		@RequestMapping("/signsuccess")
		public ModelAndView insertCustome(@ModelAttribute("cust") Student cust)
		{
			cust.setRole_id(2);
			cust.setEnabled(true);
			System.out.println(cust.getEmail());
			custs.insertUser(cust);
		//	mailConfirm.sendMail(cust.getUsername(), cust.getPassword(),cust.getEmail());
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("msg","Please Check your mail to view the login credentials");
			return mv;
		}
		
		/*@RequestMapping("/logincheck")
		public ModelAndView login(@RequestParam (value="error", required = false) String error,Model model,Authentication auth,HttpServletRequest request) 
		{
			 String go=null;
			name=request.getParameter("username");
			 String pass=request.getParameter("password");
			 if(custs.login(name, pass))
			 {
				 go="login";
			 }
			 else
			 {
				 model.addAttribute("error", "Invalid username and password!");
				 go="login";
			 }
			 	HttpSession hs=request.getSession();
			 	hs.setAttribute("nn", name);
		       ModelAndView mv=new ModelAndView(go);
		       mv.addObject("name",name);
		       return mv;
		   }*/
		
		@RequestMapping("/logincheck")
	    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
	            required = false) String logout, Model model) {
	        if (error!=null) {
	            model.addAttribute("error", "Invalid username and password");
	        }

	        if(logout!=null) {
	            model.addAttribute("msg", "You have been logged out successfully.");
	        }

	        return "home";
	    }

		/*@RequestMapping("/chat")
		public String goToChat(HttpServletRequest request,Model model)
		{
			//System.out.println(chatseervice);
			String name=request.getParameter("user");
			model.addAttribute("name",name);
			return "chat";
		}*/
		
	}

