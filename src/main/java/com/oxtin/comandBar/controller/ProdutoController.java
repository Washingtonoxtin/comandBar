package com.oxtin.comandBar.controller;

import com.oxtin.comandBar.entity.Produto;
import com.oxtin.comandBar.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor

public class ProdutoController {

    private final ProdutoRepository repository;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salva(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping("/listar")
    public List<Produto> listar() {
        return repository.findAll();
    }
}
