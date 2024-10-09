package lk.ijse.gdse67.evosellspringbackend.service;

import lk.ijse.gdse67.evosellspringbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomer();
}
