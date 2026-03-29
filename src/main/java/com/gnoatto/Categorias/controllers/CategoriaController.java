package com.gnoatto.Categorias.controllers;


import com.gnoatto.Categorias.models.CategoriaModel;
import com.gnoatto.Categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel novaCategoria){
        CategoriaModel categoria = categoriaService.criarCategoria(novaCategoria);
        return ResponseEntity.status(201).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> buscarTodos(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@PathVariable Long id,@RequestBody CategoriaModel novaCategoria){
        CategoriaModel categoria = categoriaService.atualizarCategoria(id, novaCategoria);
        return ResponseEntity.ok(categoria);
    }


}
