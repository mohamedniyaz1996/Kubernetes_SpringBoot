package com.ugam.ems.dao;

import com.ugam.ems.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE name =:n")
    public Optional<List<Employee>> findByName(@Param("n") String name);
}
