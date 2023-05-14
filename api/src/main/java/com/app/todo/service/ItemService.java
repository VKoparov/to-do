package com.app.todo.service;

import com.app.todo.data.model.ItemModel;

import java.util.List;

public interface ItemService {

    void create(ItemModel model);

    void update(String id, ItemModel model);

    List<ItemModel> getAll();

    void delete(String id);
}
