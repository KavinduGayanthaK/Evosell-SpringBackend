package lk.ijse.gdse67.evosellspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userName;
    private String password;
    private String reEntrePassword;

}
