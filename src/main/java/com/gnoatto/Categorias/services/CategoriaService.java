package com.gnoatto.Categorias.services;

import com.gnoatto.Categorias.models.CategoriaModel;
import com.gnoatto.Categorias.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel criarCategoria(CategoriaModel categoriaNovo){
        return categoriaRepository.save(categoriaNovo);
    }

    public List<CategoriaModel> listarTodos(){
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    public Optional<CategoriaModel> buscarPorId(Long id){
        return categoriaRepository.findById(id);
    }

    public CategoriaModel atualizarCategoria(Long id, CategoriaModel categoriaNovo){
        Optional<CategoriaModel> categoriaNobanco = categoriaRepository.findById(id);

        if(categoriaNobanco.isPresent()){
            CategoriaModel categoriaEditar = categoriaNobanco.get();

            categoriaEditar.setNome(categoriaNovo.getNome());
            categoriaEditar.setDescricao(categoriaNovo.getDescricao());

            return categoriaRepository.save(categoriaEditar);

        } else return null;

    }

}
