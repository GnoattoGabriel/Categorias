package com.gnoatto.Categorias.repositories;

import com.gnoatto.Categorias.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
