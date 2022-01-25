package com.muthu.sampleProject.Sony_Live.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.muthu.sampleProject.Sony_Live.Entity.Users;
import com.muthu.sampleProject.Sony_Live.UserService.UserService;


@Controller
public class MainController {
	
	
	//wire to service interface
	
	private UserService userService;
	
	
	public MainController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	//mapping.....

	@RequestMapping("/home")
	public String homePage()
	{
		return "Index";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model model)
	{
		Users users=new Users();
		model.addAttribute("user", users);
		return "login";
	}
	
	@RequestMapping("/signin")
	public String signinPage(Model model)
	{
		Users users=new Users();
		model.addAttribute("user", users);
		return "signin";
	}
	
	
	
	@RequestMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") Users users)
	{
		userService.registerUsers(users);
		return "redirect:/login";
	}
	
	@RequestMapping("/checkUser")
	public String checkUSer(HttpServletRequest request,@ModelAttribute("user") Users users, Model model)
	{
		int id=users.getId();
		String password=users.getPassword();
		
		Users fromdb=userService.checkLogin(id);
		
		if(id==fromdb.getId() && password.equals(fromdb.getPassword())) {
			
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			model.addAttribute("user",fromdb);
			return "welcome";
		}
		else 
			return "redirect:/login";
			
	}
	
	//to view all users
	
	@RequestMapping("/showAll")
	public String viewAllUsers(HttpServletRequest request,Model model)
	{
		
		HttpSession session=request.getSession(false);
		
		if(session!=null) {
			List<Users> list=userService.listAllUser();
			
			model.addAttribute("user",list);
			
			return "userList";
		}
		else {
			return "redirect:/login";
		}
	}
	
	
	//edit user
	@RequestMapping("/user/edit/{id}")
	public String editUser(@PathVariable int id, Model model,HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			Users user=userService.findUser(id);
			model.addAttribute("user",user);
			return "editUser";
		}
		return "redirect:/login";
	}
	
	
	//save changes
	
	@RequestMapping("updateUser/{id}")
	public String updateUSer(@PathVariable int id,@ModelAttribute("user") Users user)
	{
		/* int Id=Integer.parseInt(id); */
		
		System.out.println("ID "+id);
		userService.updateUser(id, user);
		
		return "redirect:/showAll";
	}
	
	//delete user
	
	@RequestMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable int id, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null) {
			userService.deletUser(id);
			
			return "redirect:/showAll";
		}
		return "redirect:/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		session.invalidate();
		return "redirect:/login";
	}
}
