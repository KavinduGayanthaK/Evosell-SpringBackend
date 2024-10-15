package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.customStatusCode.SelectedItemErrorStatus;
import lk.ijse.gdse67.evosellspringbackend.dao.ItemDao;
import lk.ijse.gdse67.evosellspringbackend.dto.ItemStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.ItemDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.ItemEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.CustomerNotFoundException;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.exception.ItemNotFoundException;
import lk.ijse.gdse67.evosellspringbackend.service.ItemService;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Autowired
    Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity save = itemDao.save(mapping.toItemEntity(itemDTO));
        if (save == null) {
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapping.itemDTOList(itemDao.findAll());
    }

    @Override
    public ItemStatus getSelectedItem(String itemCode) {
        if (itemDao.existsById(itemCode)) {
            ItemEntity itemEntity = itemDao.getReferenceById(itemCode);
            return mapping.toItemDto(itemEntity);
        }else {
            return new SelectedItemErrorStatus(1,"Item with itemCode "+itemCode+" not found");
        }
    }

    @Override
    public void updateItem(String itemCode,ItemDTO itemDTO) {
        Optional<ItemEntity> tempItem = itemDao.findById(itemCode);
        if (!tempItem.isPresent()) {
            throw new ItemNotFoundException("Item with code "+itemCode+" not found");
        }else {
            tempItem.get().setItemCode(itemDTO.getItemCode());
            tempItem.get().setName(itemDTO.getName());
            tempItem.get().setQuantityOnHand(itemDTO.getQuantityOnHand());
            tempItem.get().setPrice(itemDTO.getPrice());
        }
    }

    @Override
    public void deleteItem(String itemCode) {
        Optional<ItemEntity> existItem = itemDao.findById(itemCode);
        if (!existItem.isPresent()) {
            throw new CustomerNotFoundException("Item with code " + itemCode + " not found");
        } else {
            itemDao.deleteById(itemCode);
        }
    }
}
