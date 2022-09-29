package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository <Transaction,Long>{

	
}
