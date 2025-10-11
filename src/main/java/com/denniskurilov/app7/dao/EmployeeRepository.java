package com.denniskurilov.app7.dao;

import com.denniskurilov.app7.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
