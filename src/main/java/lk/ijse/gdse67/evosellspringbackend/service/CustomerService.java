package lk.ijse.gdse67.evosellspringbackend.service;

import lk.ijse.gdse67.evosellspringbackend.dto.CustomerStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomer();

    CustomerStatus getSelectedCustomer(String nicNumber);

    void updateCustomer(String nic,CustomerDTO customerDTO);

    void deleteCustomer(String nic);
}
