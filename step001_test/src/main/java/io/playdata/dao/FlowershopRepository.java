package io.playdata.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.playdata.model.domain.Flowershop;

public interface FlowershopRepository extends CrudRepository<Flowershop, Long>{
	List<Flowershop> findFlowershopByTitle(String title);
	List<Flowershop> findFlowershopByTitleContaining(String titldData);
}
