package userregistration;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import userentity.UserA;
import userservice.UserService;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home controller");
		return "Welcome";
	}
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("Form controller");
		return "form";
	}
	
	/*
	@RequestMapping("/processform")
	public void processform(@ModelAttribute UserA user,Model model,HttpServletResponse response) throws IOException {
		ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
	   	UserService userService=context.getBean("userService",UserService.class);
	   	System.out.print(user);
	   	userService.insert(user);
		
		//HttpServlet Response 
	   	System.out.println("HttpServlet Response");
		response.sendRedirect("done");
	}
	*/
	
	/*
	@RequestMapping("/processform")
	public String processform(@ModelAttribute UserA user,Model model) {
		ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
	   	UserService userService=context.getBean("userService",UserService.class);
	   	System.out.print(user);
	   	userService.insert(user);
	   	
	    //Prefix redirect
	    System.out.println("Prefix redirect");
		return "redirect:/done";
	}
	*/
	
	@RequestMapping("/processform")
	public RedirectView processform(@ModelAttribute UserA user,Model model) {
		ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
	   	UserService userService=context.getBean("userService",UserService.class);
	   	System.out.print(user);
	   	userService.insert(user);
		
		//RedirectView
	   	System.out.println("Redirect View");
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("done");
		return redirectView;
	}
	
	@RequestMapping("/done")
	public String done() {
		return "done";
	}
}
