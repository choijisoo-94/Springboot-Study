package io.playdata.dao;

import org.springframework.data.repository.CrudRepository;

import io.playdata.model.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
