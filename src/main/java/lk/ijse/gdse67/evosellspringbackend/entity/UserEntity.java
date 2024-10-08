package lk.ijse.gdse67.evosellspringbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String password;
}
