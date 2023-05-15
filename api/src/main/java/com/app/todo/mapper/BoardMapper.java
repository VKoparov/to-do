package com.app.todo.mapper;

import com.app.todo.data.entity.Board;
import com.app.todo.data.model.BoardModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {

    Board toBoard(BoardModel model);

    List<BoardModel> toBoardModels(List<Board> entities);
}
