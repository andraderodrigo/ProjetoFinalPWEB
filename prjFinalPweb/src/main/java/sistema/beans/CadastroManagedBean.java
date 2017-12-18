package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.primefaces.event.RowEditEvent;
import sistema.beans.datamodel.CadastroDataModel;
import sistema.modelos.Pedido;
import sistema.modelos.Cadastro;
import sistema.service.CadastroService;

@ManagedBean
@ViewScoped
public class CadastroManagedBean {

	private Cadastro cadastro = new Cadastro();
	private Cadastro cadastroSelecionado;
	private CadastroService servico = new CadastroService();
	private List<Cadastro> cadastros;

	public CadastroService getServico() {
		return servico;
	}

	public void setServico(CadastroService servico) {
		this.servico = servico;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public Cadastro getCadastroSelecionado() {
		return cadastroSelecionado;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public Cadastro getLocadoraSelecionado() {
		return cadastroSelecionado;
	}

	public void setCadastroSelecionado(Cadastro cadastroSelecionado) {
		this.cadastroSelecionado = servico.pesquisar(cadastroSelecionado);
	}

	public void salvar() {
		cadastro = servico.salvar(cadastro);

		if (cadastros != null)
			cadastros.add(cadastro);

		cadastro = new Cadastro();

	}

	public DataModel<Cadastro> getCadastros() {
		if (cadastros == null)
			cadastros = servico.getCadastros();

		return new CadastroDataModel(cadastros);
	}

	public Cadastro getLocadora() {
		return cadastro;
	}

	public void remove(Cadastro cadastro) {
		if (servico.pesquisarPedidosCadastro(cadastro).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover locadora",
					"Locadora possui produtos!"));
		} else {
			servico.remover(cadastro);
			cadastros.remove(cadastro);
		}
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Pedido> getPedidosCadastro() {
		if (cadastroSelecionado != null) {
			return servico.pesquisarPedidosCadastro(cadastroSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Cadastro f = ((Cadastro) event.getObject());
		servico.alterar(f);
	}
}
