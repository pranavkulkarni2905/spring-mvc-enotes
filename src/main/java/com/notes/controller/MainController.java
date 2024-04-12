package com.notes.controller;






import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.notes.dao.NotesDao;
import com.notes.dao.UserDao;
import com.notes.entities.Note;
import com.notes.entities.User;




@Controller
public class MainController {

	@Autowired
	public UserDao userDao;
	
	@Autowired
	public NotesDao notesDao;
	
	
	@RequestMapping("/signup")
	public String register(Model model) {
		return "register";
	}
	
	@RequestMapping("/signin")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		//List<Note> allNotes = this.notesDao.getAllNotes();
		
		//model.addAttribute("notes",allNotes);
		
		return "home";
	}
	
	@RequestMapping(value = "/create-user",method = RequestMethod.POST)
	public RedirectView handleForm(@ModelAttribute User user,HttpServletRequest request,Model model) {
		
		RedirectView redirectView = new RedirectView();
		
		this.userDao.createUser(user);
		System.out.println(user);
		
		request.getSession().setAttribute("registerSuccess", true);
		
		redirectView.setUrl(request.getContextPath()+"/signin");
		return redirectView;
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public RedirectView login(@RequestParam String email, @RequestParam String password, Model model,HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 ServletContext sContext=request.getServletContext();
		 RedirectView redirectView = new RedirectView();
	        User user = userDao.findByUsernameAndPassword(email, password);
	        if (user != null) {
	            request.getSession().setAttribute("loginSuccess", true);
	            sContext.setAttribute("user", user);
	            redirectView.setUrl(request.getContextPath()+"/home");
	            return redirectView;
	        } else {
	        	request.getSession().setAttribute("loginFail", true);	            
	            redirectView.setUrl(request.getContextPath()+"/signin");
	            return redirectView;
	        }
	    }
	 
	 @RequestMapping(value = "/add-note",method = RequestMethod.POST)
		public RedirectView addNote(@ModelAttribute Note note,HttpServletRequest request,Model model) {
			
			RedirectView redirectView = new RedirectView();
			
			this.notesDao.addNote(note);
			System.out.println(note);
			
			request.getSession().setAttribute("noteAdded", true);
			
			redirectView.setUrl(request.getContextPath()+"/home");
			return redirectView;
		}
	
	
//	@RequestMapping(value = "/delete",method = RequestMethod.POST)
//	public RedirectView deleteHandle(HttpServletRequest request,@RequestParam("productIdToDelete") int id) {
//		RedirectView redirectView=new RedirectView();
//		
//		this.productDao.deleteProduct(id);
//		
//		redirectView.setUrl(request.getContextPath()+"/");
//		return redirectView;
//	}
}
