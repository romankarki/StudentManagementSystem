package com.nuptse.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nuptse.model.Course;
import com.nuptse.model.Student;
import com.nuptse.model.StudentPayment;
import com.nuptse.service.StudentPaymentService;
import com.nuptse.service.StudentService;

@Controller
public class StudentPaymentController {
	@Autowired
	private StudentPaymentService studentpaymentService;

	@RequestMapping(value = "/student/addpayment", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		StudentPayment studentpayment = new StudentPayment();
		modelAndView.addObject("studentpayment", studentpayment);
		modelAndView.setViewName("/student/addpayment");
		return modelAndView;
	}

	@RequestMapping(value = "/student/addpayment", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@Valid StudentPayment studentpayment,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		try{
			System.out.println("Student id.......  " + studentpayment.getId());	
			StudentPayment studentExists = studentpaymentService.findStudentById(studentpayment.getId());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		StudentPayment studentExists = studentpaymentService.findStudentById(studentpayment.getId());
		System.out.println(studentpayment);
		if (studentExists != null) {
			bindingResult
					.rejectValue("id", "error.student",
							"There is already a student registered with the id provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/student/addpayment");
		} else {
			System.out.println("New ... ");
			studentpaymentService.saveStudentPayment(studentpayment);
			modelAndView.addObject("successMessage",
					"Student has been registered successfully");
			modelAndView.addObject("student", new StudentPayment());
			modelAndView.setViewName("/student/payment");
		}
		return modelAndView;
	}
	/*@RequestMapping(value = "/student/payment", method = RequestMethod.GET)
	public ModelAndView showPayment(
			@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView modelAndView = new ModelAndView();

		StudentPayment studentpayment = studentpaymentService.findStudentById(id);
		System.out.println("student " + studentpayment);
		modelAndView.addObject("student", studentpayment);
		modelAndView.setViewName("/student/payment");
		return modelAndView;
	}*/
	@RequestMapping(value = "/student/payment", method = RequestMethod.GET)
	public ModelAndView saveStudent(@ModelAttribute StudentPayment studentpayment) {
		List<StudentPayment> paymentlist = studentpaymentService.findAll();
		System.out.println("paymentList is" +paymentlist);
		// courseList.forEach(course -> System.out.println("user"))
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("paymentlist", paymentlist);
		modelAndView.setViewName("/student/payment");
		
		return modelAndView;
	}


}
