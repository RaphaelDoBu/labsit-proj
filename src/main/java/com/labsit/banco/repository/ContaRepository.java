package com.labsit.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labsit.banco.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
