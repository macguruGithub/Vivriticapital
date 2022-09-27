package com.vivriti.service;

import com.vivriti.Exception.CustomException;
import com.vivriti.dao.EmployeeRepository;
import com.vivriti.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService  {
    EmployeeRepository employeeRepository;


    public Object addEmployee(EmployeeEntity employeeEntity){
        if(employeeRepository.existsById(employeeEntity.getUserId())){
            throw new CustomException("Data already present in the db");
        }
        return employeeRepository.save(employeeEntity);
    }

    public Object updateEmployee(String  firstName, Long userId){
        if(!employeeRepository.existsById(userId)){
            throw new CustomException("Data not found so unable to update");
        }
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(userId);
        EmployeeEntity responseEntity = employeeEntityOptional.get();
        responseEntity.setFirstName(firstName);
        return employeeRepository.save(responseEntity);
    }

    public Boolean deleteEmployee(Long userId){
        if(!employeeRepository.existsById(userId)){
            throw new CustomException("Data not found so unable to delete");
        }
        employeeRepository.deleteById(userId);
        return true;
    }

    public Object getEmployeeList(){
        return employeeRepository.findAll();
    }

}
