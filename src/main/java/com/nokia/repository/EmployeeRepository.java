/**
 * 
 */
package com.nokia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokia.model.Employee;

/**
 * @author ravindra
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
