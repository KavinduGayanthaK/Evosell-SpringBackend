package lk.ijse.gdse67.evosellspringbackend.service;

import lk.ijse.gdse67.evosellspringbackend.dto.ItemStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItem();
    ItemStatus getSelectedItem(String itemCode);
    void updateItem(String itemCode,ItemDTO itemDTO);
}
