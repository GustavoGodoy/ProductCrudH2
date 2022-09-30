package com.fiap.produto.controller;

import com.fiap.produto.repository.ProdutoModelRepository;
import com.fiap.produto.entities.ProdutoModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin("*")
@AllArgsConstructor
public class ProdutoConrtoller {

    private final ProdutoModelRepository produtoModelRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> allCourses(){
        return ResponseEntity.ok().body(produtoModelRepository.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoModel produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModelRepository.save(produto));
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id){
        produtoModelRepository.deleteById(id);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProdutoModel> allCourses(@PathVariable(name = "id") long id){
        return produtoModelRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
}

