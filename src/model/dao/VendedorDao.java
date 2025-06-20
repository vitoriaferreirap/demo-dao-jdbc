package model.dao;

import java.util.List;

import model.entidades.Vendedor;

public interface VendedorDao {
    void insert(Vendedor vendedor); // insere um novo vendedor

    void update(Vendedor vendedor); // atualiza um vendedor existente

    void deleteById(Integer id); // deleta um vendedor pelo ID

    Vendedor findById(Integer id); // encontra um vendedor pelo ID

    List<Vendedor> findAll(); // encontra todos os vendedores'
}
