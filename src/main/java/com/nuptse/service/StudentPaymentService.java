package com.nuptse.service;

import java.util.List;

//import com.nuptse.model.Student;
import com.nuptse.model.StudentPayment;

public interface StudentPaymentService {
	public StudentPayment findStudentById(int id);
    public void saveStudentPayment(StudentPayment studentpayment);
	public List<StudentPayment> findAll();
}
