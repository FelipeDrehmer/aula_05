package com.saas.catalogoapi.exception;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(Long id) {
        super("Produto nao encontrado com o ID: " + id);
    }
}
