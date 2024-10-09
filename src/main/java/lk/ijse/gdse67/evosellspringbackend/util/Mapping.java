package lk.ijse.gdse67.evosellspringbackend.util;

import lk.ijse.gdse67.evosellspringbackend.dto.CustomerDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.UserDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.UserEntity;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO toUSerDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> toUserDtoList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities,new TypeToken<List<UserDTO>>() {}.getType());
    }

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }

    public CustomerDTO toCustomerDto(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public List<CustomerDTO> toCustomerList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities,new TypeToken<List<CustomerDTO>>() {}.getType());
    }

}
