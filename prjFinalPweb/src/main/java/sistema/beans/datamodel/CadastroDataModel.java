package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Cadastro;
import sistema.service.CadastroService;

public class CadastroDataModel extends ListDataModel<Cadastro> implements SelectableDataModel<Cadastro> {
	private CadastroService servico = new CadastroService();

	public CadastroDataModel() {

	}

	public CadastroDataModel(List<Cadastro> list) {
		super(list);
	}

	@Override
	public Cadastro getRowData(String rowKey) {

		for (Cadastro f : servico.getCadastros())
			if (Integer.parseInt(rowKey) == f.getCodigo())
				return servico.pesquisar(f);

		return null;
	}

	@Override
	public Object getRowKey(Cadastro cadastro) {
		return cadastro.getCodigo();
	}

}