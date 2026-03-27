package com.saas.catalogoapi.controller;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "Categorias", description = "Endpoints para gerenciamento de categorias do catalogo")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listarTodos() {
        return ResponseEntity.ok(categoriaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscardPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> criarCategoria(@RequestBody CategoriaRequest request) {
        CategoriaResponse criado = categoriaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

}
