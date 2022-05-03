package com.venda.restvenda.database;

import com.venda.restvenda.entidade.ModeloVenda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseVenda extends JpaRepository<ModeloVenda, Long> {

}
