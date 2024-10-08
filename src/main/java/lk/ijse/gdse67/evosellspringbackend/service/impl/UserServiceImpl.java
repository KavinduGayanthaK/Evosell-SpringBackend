package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.dao.UserDao;
import lk.ijse.gdse67.evosellspringbackend.dto.UserDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.UserEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.UserService;
import lk.ijse.gdse67.evosellspringbackend.util.AppUtil;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
