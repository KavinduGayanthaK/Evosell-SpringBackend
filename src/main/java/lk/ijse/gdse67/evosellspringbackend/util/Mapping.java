package lk.ijse.gdse67.evosellspringbackend.util;

import lk.ijse.gdse67.evosellspringbackend.dto.UserDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.UserEntity;
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


}
