package sistema.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String produto1;
	private String produto2;
	private String produto3;
	private String produto4;
	private String produto5;
	
	
	public String getProduto1() {
		return produto1;
	}

	public void setProduto1(String produto1) {
		this.produto1 = produto1;
	}

	@ManyToOne
	private Cadastro cadastro;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProduto2() {
		return produto2;
	}

	public void setProduto2(String produto2) {
		this.produto2 = produto2;
	}

	public String getProduto3() {
		return produto3;
	}

	public void setProduto3(String produto3) {
		this.produto3 = produto3;
	}

	public String getProduto4() {
		return produto4;
	}

	public void setProduto4(String produto4) {
		this.produto4 = produto4;
	}

	public String getProduto5() {
		return produto5;
	}

	public void setProduto5(String produto5) {
		this.produto5 = produto5;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	
}
