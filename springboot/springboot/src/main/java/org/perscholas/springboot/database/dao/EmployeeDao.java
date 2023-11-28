package org.perscholas.springboot.database.dao;
import org.perscholas.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    public Employee findById(int id);
}
