package com.app.todo.service;

import com.app.todo.data.entity.Board;
import com.app.todo.data.entity.Item;
import com.app.todo.data.model.BoardModel;
import com.app.todo.data.model.ItemModel;
import com.app.todo.mapper.BoardMapper;
import com.app.todo.mapper.ItemMapper;
import com.app.todo.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final BoardMapper boardMapper;

    private final ItemMapper itemMapper;

    @Override
    public List<BoardModel> getAll() {
        try {
            return this.boardMapper.toBoardModels(
                    this.boardRepository.findAll()
            );
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("No records were found! -> {0}", e.getMessage())
            );
        }
    }

    @Override
    public void create(BoardModel model) {
        try {
            Board board = this.boardMapper.toBoard(model);
            this.boardRepository.save(board);
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("Board was not created! -> {0}", e.getMessage())
            );
        }
    }

    @Override
    public void addItem(String id, ItemModel model) {
        try {
            Board board = this.boardRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Board was not found!"));
            board.getItems().add(itemMapper.toItem(model));
            this.boardRepository.save(board);
        } catch (Exception e) {
            throw new IllegalStateException(
                    MessageFormat.format("Something went wrong! -> {0}", e.getMessage())
            );
        }
    }
}
