package kz.iitu.lab5.repository;

import kz.iitu.lab5.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    List<Employee> findByName(String name);
}
