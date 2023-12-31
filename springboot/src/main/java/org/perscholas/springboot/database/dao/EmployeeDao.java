package org.perscholas.springboot.database.dao;
import org.perscholas.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    public Employee findById(int id);
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE :firstName or e.lastName LIKE :lastName")
    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
}
