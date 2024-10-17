package lk.ijse.gdse67.evosellspringbackend.util;

import lk.ijse.gdse67.evosellspringbackend.dto.impl.*;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.*;
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

    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public ItemDTO toItemDto(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public List<ItemDTO> itemDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities,new TypeToken<List<ItemDTO>>() {}.getType());
    }
    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }
    public OrderDTO toOrderDTO(OrderEntity orderEntity){
        return modelMapper.map(orderEntity,OrderDTO.class);
    }
    public List<OrderDTO> toOrderList(List<OrderEntity> orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDTO>>(){}.getType());
    }
    public List<OrderDetailsEntity> toOrderEntityList(List<OrderDetailsDTO> orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDetailsEntity>>(){}.getType());
    }
    public OrderDetailsEntity toOrderDetailEntity(OrderDetailsDTO orderDetailDTO) {
        return modelMapper.map(orderDetailDTO, OrderDetailsEntity.class);
    }


}
