package lk.ijse.gdse67.evosellspringbackend.dao;

import lk.ijse.gdse67.evosellspringbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
}
