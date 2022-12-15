package jpa;

import jpa.dao.ClienteDao;
import jpa.dao.FabricaConexao;
import jpa.dao.ProfissaoDao;
import jpa.model.Profissao;

import java.util.List;

public class JpaClienteApplication {
    private static ClienteDao clienteCrud;
    public static void main(String[] args) {
        FabricaConexao.iniciarConexao();
        clienteCrud = new ClienteDao();
    }

}
