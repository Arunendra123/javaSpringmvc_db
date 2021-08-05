package userregistration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/processform")
	public String processform(@ModelAttribute UserA user,Model model) {
		ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
	   	UserService userService=context.getBean("userService",UserService.class);
	   	System.out.print(user);
	   	userService.insert(user);
		return "done";
	}
}
