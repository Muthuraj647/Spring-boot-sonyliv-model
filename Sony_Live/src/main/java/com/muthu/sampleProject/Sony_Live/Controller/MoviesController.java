package com.muthu.sampleProject.Sony_Live.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.muthu.sampleProject.Sony_Live.Entity.MoviesEntity;
import com.muthu.sampleProject.Sony_Live.UserService.MoviesService;

@Controller
public class MoviesController {
	
	private MoviesService moviesService;

	public MoviesController(MoviesService moviesService) {
		super();
		this.moviesService = moviesService;
	}
	
	
	@RequestMapping("/myMovies")
	public String getMovies(Model model, HttpServletRequest request)
	{
		
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			int id=(Integer)session.getAttribute("id");
			List<MoviesEntity> list=moviesService.getMovies(id);
			
			model.addAttribute("movies", list);
			
			return "moviesList";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/newMovie")
	public String newMovies(Model model,HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			int userId=(Integer)session.getAttribute("id");
			MoviesEntity moviesEntity=new MoviesEntity(userId);
			
			model.addAttribute("movies", moviesEntity);
			return "addMovie";
		}
		return "redirect:/login";
	}

	@RequestMapping("/addMovie")
	public String addMovies(@ModelAttribute("movies") MoviesEntity moviesEntity, HttpServletRequest request)
	{ 
		/*
		 * int userid=moviesEntity.getUserId(); boolean check=
		 * moviesService.checkUser(userid,password);
		 */
		
		
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			int userid = (Integer)session.getAttribute("id");
			moviesService.addMovies(moviesEntity);
			return "redirect:/myMovies";
			//System.out.println("Password "+password);
		}
		return "redirect:/login";
	}
	
	//edit
	
	@RequestMapping("/movie/edit/{id}")
	public String editMovie(@PathVariable int id, Model model)
	{
		MoviesEntity moviesEntity=moviesService.getMovie(id);
		
		model.addAttribute("movies", moviesEntity);
		
		return "editMovie";
	}
	
	@RequestMapping("/updateMovie/{id}")
	public String updateMovie(@PathVariable(name = "id") int id,@ModelAttribute("movies") MoviesEntity moviesEntity)
	{
		
		moviesService.updateMovie(id,moviesEntity);
		
		return "redirect:/myMovies";
	}
	
	//delete
	
	@RequestMapping("/movie/delete/{id}")
	public String deleteMovie(@PathVariable("id") int id, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			moviesService.deleteMovie(id);
			return "redirect:/myMovies";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/search")
	public String searchMovie(@RequestParam String key,Model model)
	{
		System.out.println("Key "+key);
		List<MoviesEntity> list=moviesService.searchMovies(key);
		
		System.out.println(list.get(0).getMovieName());
		
		
		model.addAttribute("movies", list);
		
		return "searchResult";
	}
}
