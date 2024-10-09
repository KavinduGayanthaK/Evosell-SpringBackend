package lk.ijse.gdse67.evosellspringbackend.controller;

import lk.ijse.gdse67.evosellspringbackend.dto.CustomerDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.UserDTO;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/custo")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        try{
            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomer();
    }
}
