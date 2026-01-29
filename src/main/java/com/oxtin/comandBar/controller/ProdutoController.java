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

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PutMapping("/{id}")
    public Produto atualizar(
            @PathVariable Long id,
            @RequestBody Produto produtoAtualizado) {

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
        // adicione outros campos conforme surgirem

        return repository.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        repository.deleteById(id);
    }
}
