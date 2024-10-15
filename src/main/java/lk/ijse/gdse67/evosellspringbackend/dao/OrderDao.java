package lk.ijse.gdse67.evosellspringbackend.dao;

import lk.ijse.gdse67.evosellspringbackend.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderEntity,String> {
}
