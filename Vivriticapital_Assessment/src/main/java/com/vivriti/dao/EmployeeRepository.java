package com.vivriti.dao;

import com.vivriti.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    public Boolean existsByMobileNumber(String mobileNumber);
}
