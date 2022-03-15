package agencia.aplicacao;
import agencia.model.Reserva;
import agencia.model.Destino;
import agencia.model.Cliente;

import java.sql.Date;

import agencia.dao.ClienteDAO;
import agencia.dao.DestinoDAO;
import agencia.dao.ReservaDao;

public class Main {
	public static void main(String[] args) {
		
		ClienteDAO clienteDao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setNome("Maria Gabriela Dias");
		cliente.setCpf("99998888111");
		cliente.setContato("11122233344");
		cliente.setLogin("teste");
		cliente.setPassword("teste123");
		
		clienteDao.save(cliente);
		
		for(Cliente c : clienteDao.getClientes()) {
			System.out.println("Cliente: "+c.getNome());
		}
		
		DestinoDAO destinoDao = new DestinoDAO();
		
		Destino destino = new Destino();
		destino.setAdress("endereco");
		destino.setContato("99988877766");
		destino.setTipo("Pousada");
		destino.setDescricao("descricao");
		destino.setVal_diaria(100.20);
		
		destinoDao.save(destino);
		
		for(Destino d : destinoDao.getDestinos()) {
			System.out.println("Destino: " + d.getAdress());
		}
		
		ReservaDao reservaDao = new ReservaDao();
		
		Reserva reserva = new Reserva();
		reserva.setId_cliente(1);
		reserva.setId_destino(1);
		reserva.setTempo_reserva(33);
		reserva.setData_inicio((java.sql.Date) new Date(0, 0, 0));
		reserva.setValor_reserva(336.60);
		
		reservaDao.save(reserva);
		
		for(Reserva r : reservaDao.getReservas()) {
			System.out.println("Reserva: "+ r.getId_cliente());
		}
	}
}
