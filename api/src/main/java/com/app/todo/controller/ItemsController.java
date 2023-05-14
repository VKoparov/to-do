package com.app.todo.controller;

import com.app.todo.data.model.ItemModel;
import com.app.todo.service.ItemService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ItemsController {

    private final ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody ItemModel item) {
        this.itemService.create(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable String id, @RequestBody ItemModel item) {
        this.itemService.update(id, item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        this.itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
