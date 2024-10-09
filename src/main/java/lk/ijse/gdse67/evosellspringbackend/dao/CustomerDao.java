package lk.ijse.gdse67.evosellspringbackend.dao;

import lk.ijse.gdse67.evosellspringbackend.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
