package org.iesvdm.exercises.repository;

import org.iesvdm.exercises.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
