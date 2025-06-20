package model.dao;

import db.DB;
import model.daoImplementacao.DepartamentoDaoJDBC;
import model.daoImplementacao.VendedorDaoJDBC;

/* A classe DaoFabrica é responsável por criar instâncias de DAOs (Data Access Objects).
 *Ela encapsula a lógica de criação dos DAOs, permitindo que o código cliente não precise se preocupar com a implementação específica.
*/

public class DaoFabrica {
    public static VendedorDao criarVendedorDao() {
        return new VendedorDaoJDBC(DB.getConnection());
    }

    public static DepartamentoDao criarDepartamentoDao() {
        return new DepartamentoDaoJDBC(DB.getConnection());
    }

}
