package com.example.ProjectSeventeen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String viewpage(Model model) {
		List<Fruit> list = service.listAll();
		model.addAttribute("list",list);
		return "index";
	}
	@GetMapping("/new")
	public String showpage(Model model) {
		Fruit fruit = new Fruit();
		model.addAttribute("fruit",fruit);
		return "newproduct";
	}
	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute("fruit") Fruit fruit) {
	    service.save(fruit);
	     
	    return "redirect:/";
 	}
	@GetMapping("/edit/{id}")
	public ModelAndView showedit(@PathVariable(name="id")int id) {
		ModelAndView demo = new ModelAndView("editproduct");
		Fruit fruit = service.get(id);
		demo.addObject("fruit",fruit);
		return demo;
	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}
}
