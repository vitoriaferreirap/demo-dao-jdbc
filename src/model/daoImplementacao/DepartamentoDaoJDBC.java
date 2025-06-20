package model.daoImplementacao;

import java.sql.Connection;
import java.util.List;

import model.dao.DepartamentoDao;
import model.entidades.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao {

    private Connection conexao;

    public DepartamentoDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void insert(Departamento departamento) {
    }

    @Override
    public void update(Departamento departamento) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Departamento findById(Integer id) {
        return null;
    }

    @Override
    public List<Departamento> findAll() {
        return new java.util.ArrayList<>();
    }

}