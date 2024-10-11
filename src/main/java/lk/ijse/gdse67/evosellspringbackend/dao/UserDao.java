package lk.ijse.gdse67.evosellspringbackend.dao;

import lk.ijse.gdse67.evosellspringbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    @Query(value = "SELECT u FROM UserEntity u WHERE u.gmail =?1")
    Optional<UserEntity> findByGmail(String gmail);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UserEntity u WHERE u.gmail = ?1")
    void deleteByUser(String gmail);
}
