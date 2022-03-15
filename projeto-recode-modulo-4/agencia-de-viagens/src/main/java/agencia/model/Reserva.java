package agencia.model;

public class Reserva {
    private int id;
    private int id_cliente;
    private int id_destino;
    private java.sql.Date data_inicio;
    private int tempo_reserva;
    private Double valor_reserva;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public java.sql.Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(java.sql.Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public int getTempo_reserva() {
		return tempo_reserva;
	}
	public void setTempo_reserva(int tempo_reserva) {
		this.tempo_reserva = tempo_reserva;
	}
	public Double getValor_reserva() {
		return valor_reserva;
	}
	public void setValor_reserva(Double valor_reserva) {
		this.valor_reserva = valor_reserva;
	}
}
