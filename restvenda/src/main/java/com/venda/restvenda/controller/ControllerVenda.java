package com.venda.restvenda.controller;

import java.util.List;

import com.venda.restvenda.database.DataBaseVenda;
import com.venda.restvenda.entidade.ModeloVenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class ControllerVenda {

    @Autowired
    private DataBaseVenda database;

    @GetMapping
    public List<ModeloVenda> lista() {

        return database.findAll();
    }

    @PutMapping
    public void alterar(@RequestBody ModeloVenda venda) {
        if (venda.getId() > 0)

            venda.calculoDesconto();
        database.save(venda);

    }

    @PostMapping
    public void salvar(@RequestBody ModeloVenda venda) {

        venda.calculoDesconto();
        database.save(venda);

    }

    @DeleteMapping
    public void excluir(@RequestBody ModeloVenda venda) {

        database.delete(venda);
    }
}
