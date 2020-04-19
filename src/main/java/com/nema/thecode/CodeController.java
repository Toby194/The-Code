package com.nema.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeController {
		@RequestMapping("/")
		public String index(HttpSession session) {
			if (null == session.getAttribute("giveaccess")) {
				session.setAttribute("giveaccess", "0");
			}
			return "index.jsp";
		}
		
	    @RequestMapping(value="/testCode", method=RequestMethod.POST)
	    public String testcode(@RequestParam(value="code") String code, HttpSession session) {
	    	if (code.equals("bushido")) {
	    		session.setAttribute("giveaccess", "1");
	    		return "redirect:/code";
	    	}
	    	else {
	    		return "redirect:/";
	    	}
		}
	    
		@RequestMapping("/code")
		public String showcode(HttpSession session) {
			if (null == session.getAttribute("giveaccess")) {
				session.setAttribute("giveaccess", "0");
			}
			else if (session.getAttribute("giveaccess") == "1") {
				return "code.jsp";
			}
			return "redirect:/";
		}

}
