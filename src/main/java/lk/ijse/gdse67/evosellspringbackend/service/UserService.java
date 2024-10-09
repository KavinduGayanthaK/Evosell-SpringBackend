package lk.ijse.gdse67.evosellspringbackend.service;

import lk.ijse.gdse67.evosellspringbackend.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    void updateUser(String gmail,UserDTO userDTO);

    void deleteUser(String gmail);
}
