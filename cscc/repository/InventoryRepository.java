package edu.cscc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cscc.model.Record;

@Repository
public interface InventoryRepository extends CrudRepository<Record, Long> {}
