package lk.ijse.gdse67.evosellspringbackend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse67.evosellspringbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name= "customerNic",nullable = false)
    private CustomerEntity customerNic;
    private String customerName;

}
