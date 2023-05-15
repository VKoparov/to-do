package com.app.todo.service;

import com.app.todo.data.model.BoardModel;
import com.app.todo.data.model.ItemModel;

import java.util.List;

public interface BoardService {

    List<BoardModel> getAll();

    void create(BoardModel model);

    void addItem(String id, ItemModel model);
}
