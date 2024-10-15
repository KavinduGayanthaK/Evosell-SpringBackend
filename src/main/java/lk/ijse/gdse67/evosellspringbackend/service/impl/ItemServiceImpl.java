package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.dao.ItemDao;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.ItemDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.ItemEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.ItemService;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
