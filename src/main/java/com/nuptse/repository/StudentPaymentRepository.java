package com.nuptse.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nuptse.model.Student;
//import com.nuptse.model.Student;
import com.nuptse.model.StudentPayment;

public interface StudentPaymentRepository  extends JpaRepository<StudentPayment, Long> {
	StudentPayment findById(int id);
}
