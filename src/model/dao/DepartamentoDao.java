package model.dao;

import java.util.List;

import model.entidades.Departamento;

public interface DepartamentoDao {
    void insert(Departamento departamento);// insere um novo departamento

    void update(Departamento departamento); // atualiza um departamento existente

    void deleteById(Integer id);//

    Departamento findById(Integer id);//

    List<Departamento> findAll();//

}