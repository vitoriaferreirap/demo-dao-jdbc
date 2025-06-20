import java.util.Date;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {
    public static void main(String[] args) {
        // Criação de um departamento
        Departamento departamento = new Departamento(1, "Recursos Humanos");

        // Exibição do departamento
        System.out.println(departamento);

        // criando vendedor
        Vendedor vendedor = new Vendedor(1, "João Silva", "joao@gmail.com",
                new Date(), 3000.0, departamento);

        // injecao de dependência - Programa não conhece a implementação do DAO,somente
        // a interface
        VendedorDao vendodorDao = DaoFabrica.criarVendedorDao();

        // Exibição do vendedor
        System.out.println(vendedor);

    }
}
