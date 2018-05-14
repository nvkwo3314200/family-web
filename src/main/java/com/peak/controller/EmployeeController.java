package com.peak.controller;

import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
	
	/*@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/emps")
	public String getEmps(@RequestParam(value="pn", defaultValue = "1")Integer pn, Model model) {
		
		PageHelper.startPage(pn , 5);
		List<Employee> emps = employeeService.getEmps();
		
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		return "list";
	}*/
	
}
