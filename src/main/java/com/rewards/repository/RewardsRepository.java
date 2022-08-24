package com.rewards.repository;

import com.rewards.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardsRepository extends CrudRepository<Transaction, Long> {
}
