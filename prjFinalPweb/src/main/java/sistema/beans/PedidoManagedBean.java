package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Pedido;
import sistema.modelos.Cadastro;
import sistema.service.PedidoService;
import sistema.service.CadastroService;

@ManagedBean(name = "pedidoManagedBean")
@ViewScoped
public class PedidoManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido = new Pedido();
	private Cadastro cadastro;
	private PedidoService pedidoService = new PedidoService();
	private CadastroService cadService = new CadastroService();
	private List<Pedido> pedidos;

	public void salvar() {

		if (cadastro != null) {
			cadastro.addPedido(pedido);
			pedido.setCadastro(cadastro);
		}

		pedido = pedidoService.salvar(pedido);

		if (pedidos != null)
			pedidos.add(pedido);

		pedido = new Pedido();
		cadastro = null;
	}

	
	public void remove(Pedido pedido) {
		pedidoService.remover(pedido);
		pedidos.remove(pedido);
	}


	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = pedidoService.getPedidos();

		return pedidos;
	}

	public void onRowEdit(RowEditEvent event) {

		Pedido p = ((Pedido) event.getObject());
		pedidoService.alterar(p);
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public PedidoService getPedidoService() {
		return pedidoService;
	}


	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}


	public CadastroService getMarrService() {
		return cadService;
	}


	public void setMarrService(CadastroService cadService) {
		this.cadService = cadService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Cadastro> getCadastros() {
		return cadService.getCadastros();

	}

}
