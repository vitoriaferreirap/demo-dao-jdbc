package aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        System.out.println("\n=== TESTE 3: vendendor findyAll ===");
        lista = vendodorDao.findAll(); // busca os vendedores do departamento com id
        for (Vendedor obj : lista) {
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 4: vendedor insert ===");
        Vendedor novoVendedor = new Vendedor(null, "Greg", "gregue@gmail.com", new Date(), 4000.0, departamento);
        vendodorDao.insert(novoVendedor); // insere um novo vendedor
        System.out.println("Inserido! Novo id = " + novoVendedor.getId()); // imprime o id do novo vendedor

        System.out.println("\n=== TESTE 5: vendedor update ===");
        vendedor = vendodorDao.findById(1); // busca o vendedor com id 1
        vendedor.setNome("Martha Waine"); // altera o nome do vendedor
        vendedor.setEmail("martha@gmail.com");
        vendodorDao.update(vendedor); // atualiza o vendedor
        System.out.println("Update completo!");

        System.out.println("\n=== TESTE 6: vendedor delete ===");
        System.out.println("Entre com o id do vendedor a ser deletado: ");
        int id = sc.nextInt();
        vendodorDao.deleteById(id); // deleta o vendedor com id 10
        System.out.println("Delete completo!");

        sc.close();
    }

}