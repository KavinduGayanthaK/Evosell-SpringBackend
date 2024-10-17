package lk.ijse.gdse67.evosellspringbackend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse67.evosellspringbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String Id;
    private String name;
    private String address;
    private String email;
    private String nic;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<OrderEntity> orderList;
}
