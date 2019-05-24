package com.nuptse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuptse.model.StudentPayment;
import com.nuptse.repository.StudentPaymentRepository;
import com.nuptse.repository.StudentRepository;
@Service("studentpaymentService")
public class StudentPaymentServiceImpl implements StudentPaymentService {

	@Autowired
	private StudentPaymentRepository studentpaymentRepository;

	@Override
	public StudentPayment findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentpaymentRepository.findById(id);
	}
	@Override
	public void saveStudentPayment(StudentPayment studentpayment) {
		// TODO Auto-generated method stub
		studentpaymentRepository.save(studentpayment);
	}
	@Override
	public List<StudentPayment> findAll() {
		// TODO Auto-generated method stub
		return studentpaymentRepository.findAll();	

}
}