package com.leaomulti.leaocentermultimarcas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leaomulti.leaocentermultimarcas.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long>{

}
