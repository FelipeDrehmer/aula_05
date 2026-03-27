package com.saas.catalogoapi.service;

import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.ProdutoResponse;
import com.saas.catalogoapi.exception.CategoriaNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoriaService {

    private final List<CategoriaResponse> categorias = new ArrayList<>();

    private final AtomicLong contadorId = new AtomicLong();

    public CategoriaService() {
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Enlatados", "Produtos enlatados"
        ));
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Frios", "Produtos frios"
        ));
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Frutas", "Produtos frutiferos"
        ));
    }

    public List<CategoriaResponse> listarTodos() {
        return categorias;
    }

    public CategoriaResponse buscardPorId(Long id) {
        return categorias.stream()
                .filter(c -> c.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public CategoriaResponse criar(CategoriaRequest request) {
        CategoriaResponse novaCategorias = new CategoriaResponse(
                contadorId.incrementAndGet(),
                request.nome(),
                request.descricao()
        );
        categorias.add(novaCategorias);
        return novaCategorias;
    }

}
