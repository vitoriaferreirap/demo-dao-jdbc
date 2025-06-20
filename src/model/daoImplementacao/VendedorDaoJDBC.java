package model.daoImplementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao { // implementa interface vendedorDao

    // dependência de conexão com o banco de dados
    private Connection conexao;

    public VendedorDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void insert(Vendedor vendedor) {

    }

    @Override
    public void update(Vendedor vendedor) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Vendedor findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?");

            st.setInt(1, id);// recebe id que veio como paramentro na função
            rs = st.executeQuery();// recebe o resultado da consulta

            // posição 0 do ResultSet é inválida, então é necessário chamar next()
            if (rs.next()) {
                // criando um novo obj departamento (AGORA EM UMA FUNÇÃO SEPARADA)
                Departamento dep = instanciandoDepartamento(rs);
                // criando um novo obj vendedor interligado com o departamento(AGORA EM UMA
                // FUNÇÃO SEPARADA)
                Vendedor vendedor = instanciandoVendedor(rs, dep);
                return vendedor; // retorna o vendedor com o departamento associado
            }
            return null; // se não encontrar o vendedor, retorna null

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Vendedor instanciandoVendedor(ResultSet rs, Departamento dep) throws SQLException {
        Vendedor vendedor = new Vendedor(); // instanciando um novo vendedor
        vendedor.setId(rs.getInt("Id"));// acessando coluna Id
        vendedor.setNome(rs.getString("Name"));// acessando coluna Name
        vendedor.setEmail(rs.getString("Email"));// acessando coluna Email
        vendedor.setSalario(rs.getDouble("BaseSalary"));// acessando coluna BaseSalary
        vendedor.setAniversario(rs.getDate("BirthDate"));// acessando coluna BirthDate

        vendedor.setDepartamento(dep);// setando o departamento do vendedor
        return vendedor; // retorna o vendedor instanciado
    }

    private Departamento instanciandoDepartamento(ResultSet rs) throws SQLException { // propagando exceção
        Departamento dep = new Departamento();
        dep.setId(rs.getInt("DepartmentId"));// acessando coluna DepartmentId
        dep.setNome(rs.getString("DepName"));// acessando coluna DepName
        return dep; // retorna o departamento instanciado
    }

    @Override
    public List<Vendedor> findAll() {

        return null;
    }

    @Override
    public List<Vendedor> findByDepartamento(Departamento departamentoId) {
        List<Vendedor> lista = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE DepartmentId = ? " +
                            "ORDER BY Name ");

            st.setInt(1, departamentoId.getId());// recebe id que veio como paramentro na função
            rs = st.executeQuery();// recebe o resultado da consulta

            Map<Integer, Departamento> map = new HashMap<>(); // para evitar duplicação de departamentos (vazio)

            // percorre enquando tiver um proximo
            while (rs.next()) {

                Departamento dep = map.get(map.get(rs.getInt("DepartmentId"))); // busca o departamento no mapa

                if (dep == null) {
                    dep = instanciandoDepartamento(rs); // se não existir, instancia um novo departamento
                    map.put(dep.getId(), dep); // adiciona o departamento no map
                }

                Vendedor vendedor = instanciandoVendedor(rs, dep);
                lista.add(vendedor); // adiciona o vendedor na lista
            }
            return lista; // se não encontrar o vendedor, retorna null

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
