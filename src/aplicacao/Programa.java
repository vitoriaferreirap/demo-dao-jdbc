package aplicacao;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Programa {
    public static void main(String[] args) {

        // injecao de dependência - Programa não conhece a implementação do DAO,somente
        // a interface
        VendedorDao vendodorDao = DaoFabrica.criarVendedorDao();

        System.out.println("=== TESTE 1: vendedor findById ===");

        Vendedor vendedor = vendodorDao.findById(3); // busca o vendedor com id 3

        // Exibição do vendedor
        System.out.println(vendedor);

    }
}
