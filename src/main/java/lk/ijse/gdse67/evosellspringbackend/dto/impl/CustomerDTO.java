package lk.ijse.gdse67.evosellspringbackend.dto.impl;

import lk.ijse.gdse67.evosellspringbackend.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String Id;
    private String name;
    private String address;
    private String email;
    private String nic;
}
