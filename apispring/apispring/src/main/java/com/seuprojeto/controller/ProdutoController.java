package com.seuprojeto.controller;

import com.seuprojeto.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    private Long contador = 1L;

    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        produto.setId(contador++);
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                p.setNome(produtoAtualizado.getNome());
                p.setPreco(produtoAtualizado.getPreco());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }
}
