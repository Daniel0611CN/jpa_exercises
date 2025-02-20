package org.iesvdm.exercises.service;

import org.iesvdm.exercises.domain.Categoria;
import org.iesvdm.exercises.exception.CategoriaNotFoundException;
import org.iesvdm.exercises.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) { return this.categoriaRepository.save(categoria); }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {
        return this.categoriaRepository.findById(id)
                .map(c -> (id.equals(categoria.getId()) ?
                        this.categoriaRepository.save(categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria delete(Long id) {
        return this.categoriaRepository.findById(id)
                .map(c -> {
                    this.categoriaRepository.delete(c);
                    return c;
                })
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

}
