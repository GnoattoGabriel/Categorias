package com.gnoatto.Categorias.controllers;


import com.gnoatto.Categorias.models.CategoriaModel;
import com.gnoatto.Categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public CategoriaModel criarCategoria(@RequestBody CategoriaModel novaCategoria){
        return categoriaService.criarCategoria(novaCategoria);
    }

    @GetMapping
    public List<CategoriaModel> buscarTodos(){
        return categoriaService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaModel atualizarCategoria(@PathVariable Long id,@RequestBody CategoriaModel novaCategoria){
        return categoriaService.atualizarCategoria(id, novaCategoria);
    }


}
