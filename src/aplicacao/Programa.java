package aplicacao;

import java.util.List;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {
    public static void main(String[] args) {

        // injecao de dependência - Programa não conhece a implementação do DAO,somente
        // a interface
        VendedorDao vendodorDao = DaoFabrica.criarVendedorDao();
        System.out.println("=== TESTE 1: vendedor findById ===");
        Vendedor vendedor = vendodorDao.findById(3); // busca o vendedor com id 3
        System.out.println(vendedor);

        System.out.println("\n=== TESTE 2: vendendor findyByIdDepartment ===");
        Departamento departamento = new Departamento(2, null); // cria um novo departamento com id 2
        List<Vendedor> lista = vendodorDao.findByDepartamento(departamento); // busca os vendedores do departamento com
                                                                             // id
        for (Vendedor obj : lista) {
            System.out.println(obj);
        }

    }
}
