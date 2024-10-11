package lk.ijse.gdse67.evosellspringbackend.dao;

import lk.ijse.gdse67.evosellspringbackend.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {

    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.nic = ?1")
    CustomerEntity findByNic(String nicNumber);

    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.nic = ?1")
    Optional<CustomerEntity> findByNicNumber(String nic);
}
