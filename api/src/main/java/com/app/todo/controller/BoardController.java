package com.app.todo.controller;

import com.app.todo.data.model.BoardModel;
import com.app.todo.data.model.ItemModel;
import com.app.todo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<List<BoardModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.boardService.getAll());
    }

    @PostMapping("/board/create")
    public ResponseEntity<HttpStatus> create(@RequestBody BoardModel model) {
        this.boardService.create(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/board/update/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable String id, @RequestBody ItemModel item) {
        this.boardService.addItem(id, item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
