package com.app.todo.service;

import com.app.todo.data.entity.Item;
import com.app.todo.mapper.ItemMapper;
import com.app.todo.data.model.ItemModel;
import com.app.todo.repo.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemsRepository itemsRepository;

    private final ItemMapper itemMapper;

    @Override
    public void create(ItemModel model) {
        try {
            Item item = this.itemMapper.toItem(model);
            this.itemsRepository.save(item);
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("Item was not created! -> {0}", e.getMessage())
            );
        }
    }

    @Override
    public void update(String id, ItemModel model) {
        try {
            Item itemToUpdate = this.itemMapper.toItem(model);
            Item item = this.itemsRepository.findById(id)
                    .orElseThrow((() -> new IllegalStateException("Requested Item does not exist!")));
            item.setStatus(itemToUpdate.getStatus());
            this.itemsRepository.save(item);
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("Item was not updated -> {0}", e.getMessage())
            );
        }
    }

    @Override
    public List<ItemModel> getAll() {
        try {
            return this.itemMapper.toItemModels(
                    this.itemsRepository.findAll()
            );
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("No records were found! -> {0}", e.getMessage())
            );
        }
    }

    @Override
    public void delete(String id) {
        try {
            this.itemsRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("No records were found! -> {0}", e.getMessage())
            );
        }
    }
}
