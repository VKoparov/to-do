package com.app.todo.mapper;

import com.app.todo.data.entity.Item;
import com.app.todo.data.model.ItemModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    Item toItem(ItemModel model);

    List<ItemModel> toItemModels(List<Item> entities);
}
