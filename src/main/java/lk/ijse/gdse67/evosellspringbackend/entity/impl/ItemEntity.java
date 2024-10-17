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
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String itemCode;
    private String itemName;
    private int QTYOnHand;
    private double unitPrice;
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderList;
}
