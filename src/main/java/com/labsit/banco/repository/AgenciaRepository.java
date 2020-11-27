package com.labsit.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labsit.banco.model.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

}
