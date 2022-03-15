package agencia.model;

public class Destino {
    private int id;
    private String adress;
    private String tipo;
    private String contato;
    private String descricao;
    private Double val_diaria;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getVal_diaria() {
		return val_diaria;
	}
	public void setVal_diaria(Double val_diaria) {
		this.val_diaria = val_diaria;
	}
}
