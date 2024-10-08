package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.dao.UserDao;
import lk.ijse.gdse67.evosellspringbackend.dto.UserDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.UserEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.exception.UserNotFoundException;
import lk.ijse.gdse67.evosellspringbackend.service.UserService;
import lk.ijse.gdse67.evosellspringbackend.util.AppUtil;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    Mapping mapping;

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.generateUserid());
        UserEntity saveUser = userDao.save(mapping.toUserEntity(userDTO));
        if (saveUser == null) {
            throw new DataPersistException("User not saved");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.toUserDtoList(userDao.findAll());
    }



    @Override
    public void updateUser(String gmail, UserDTO userDTO) {
        Optional<UserEntity> tempUser = userDao.findByGmail(gmail);
        if (!tempUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }else {
            tempUser.get().setUserName(userDTO.getUserName());
            tempUser.get().setPassword(userDTO.getPassword());
            tempUser.get().setGmail(userDTO.getGmail());
        }
    }
}
