package sistema.service;

import java.util.List;

import sistema.dao.CadastroDAO;
import sistema.modelos.Pedido;
import sistema.modelos.Cadastro;

public class CadastroService {

	private CadastroDAO cadastroDAO = new CadastroDAO();

	public Cadastro salvar(Cadastro cadastro) {

		cadastro = cadastroDAO.save(cadastro);
		cadastroDAO.closeEntityManager();
		return cadastro;
	}

	public List<Cadastro> getCadastros() {
		List<Cadastro> list = cadastroDAO.getAll(Cadastro.class);
		cadastroDAO.closeEntityManager();
		return list;
	}

	public void alterar(Cadastro cadastro) {

		cadastroDAO.save(cadastro);
		cadastroDAO.closeEntityManager();

	}

	public void remover(Cadastro cadastro) {

		cadastro = cadastroDAO.getById(Cadastro.class, cadastro.getCodigo());
		cadastroDAO.remove(cadastro);
		cadastroDAO.closeEntityManager();
	}

	public Cadastro pesquisar(Cadastro cadastro) {

		cadastro = cadastroDAO.getById(Cadastro.class, cadastro.getCodigo());
		cadastroDAO.closeEntityManager();
		return cadastro;
	}

	public List<Pedido> pesquisarPedidosCadastro(Cadastro cadastro) {

		List<Pedido> pedidos;
		cadastro = cadastroDAO.getById(Cadastro.class, cadastro.getCodigo());
		pedidos = cadastro.getPedidos();
		return pedidos;
	}
}
