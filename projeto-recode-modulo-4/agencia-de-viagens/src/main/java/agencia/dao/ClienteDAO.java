package agencia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import agencia.factory.connectionfactory;
import agencia.model.Cliente;

public class ClienteDAO {
	
	public void save(Cliente cliente) {
			String sql ="INSERT INTO cliente(nome_cliente, cpf_cliente, login, senha, contato_cliente) VALUES(?,?,?,?,?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = connectionfactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getCpf());
				pstm.setString(3, cliente.getLogin());
				pstm.setString(4, cliente.getPassword());
				pstm.setString(5, cliente.getContato());
				pstm.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
	
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nome_cliente = ?, cpf_cliente = ?, login = ?, senha = ?, contato_cliente = ? "+"WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getLogin());
			pstm.setString(4, cliente.getPassword());
			pstm.setString(5, cliente.getContato());
			pstm.setInt(6, cliente.getId());
			pstm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
			}
		}
	}
	
	public void deleteById(int id) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Cliente> getClientes() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while(rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome_cliente"));
				cliente.setCpf(rset.getString("cpf_cliente"));
				cliente.setLogin(rset.getString("login"));
				cliente.setPassword(rset.getString("senha"));
				cliente.setContato(rset.getString("contato_cliente"));
				clientes.add(cliente);
			}
		}catch (Exception e){
				e.printStackTrace();
			} finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		return clientes;
		}
}
