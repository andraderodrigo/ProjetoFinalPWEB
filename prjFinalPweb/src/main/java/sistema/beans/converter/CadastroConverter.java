package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Cadastro;
import sistema.service.CadastroService;

@FacesConverter("converterCadastro")
public class CadastroConverter implements Converter {

	private CadastroService servico = new CadastroService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		if (value != null && !value.isEmpty()) {

			for (Cadastro f : servico.getCadastros())
				if (f.getCliente().equals(value))
					return f;

		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object marratona) {
		if (marratona == null || marratona.equals("")) {
			return null;
		} else {
			return ((Cadastro) marratona).getCliente();

		}
	}

}
