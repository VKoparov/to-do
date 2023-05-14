package com.app.todo.repo;

import com.app.todo.data.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<Item, String> {
}
