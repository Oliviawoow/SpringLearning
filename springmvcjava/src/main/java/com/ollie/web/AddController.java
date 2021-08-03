package com.ollie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// import com.ollie.services.AddService;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int num1, @RequestParam("t2") int num2
//			, HttpServletRequest request, HttpServletResponse response
	) {
//		int i = Integer.parseInt(request.getParameter("t1"));
//		int j = Integer.parseInt(request.getParameter("t2"));
//		int k = i + j;
//		AddService as = new AddService();
//		int k = as.add(i, j);
		// System.out.println(i + " " + j);

		ModelAndView mv = new ModelAndView();
		int k = num1 + num2;
		mv.setViewName("result.jsp");
		mv.addObject("result", k);

		return mv;
	}
}