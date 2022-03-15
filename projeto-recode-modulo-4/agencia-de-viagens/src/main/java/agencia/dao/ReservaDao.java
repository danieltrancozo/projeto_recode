package agencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import agencia.factory.connectionfactory;
import agencia.model.Reserva;

public class ReservaDao {
	public void save(Reserva reserva) {
		String sql = "INSERT INTO reserva(id_cliente, id_destino, data_inicio, tempo_reserva, val_reserva) VALUE(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, reserva.getId_cliente());
			pstm.setInt(2, reserva.getId_destino());
			pstm.setDate(3, new Date(reserva.getData_inicio().getTime()));
			pstm.setInt(4, reserva.getTempo_reserva());
			pstm.setDouble(5, reserva.getValor_reserva());
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Reserva reserva) {
		String sql = "UPDATE reserva SET id_cliente = ?, id_destino = ?, data_inicio = ?, tempo_reserva = ?, val_reserva = ? "+"WHERE id_reseva = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, reserva.getId_cliente());
			pstm.setInt(2, reserva.getId_destino());
			pstm.setDate(3, new Date(reserva.getData_inicio().getTime()));
			pstm.setInt(4, reserva.getTempo_reserva());
			pstm.setDouble(5, reserva.getValor_reserva());
			pstm.setInt(6, reserva.getId());
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteById(int id) {
		String sql = "DELETE FROM reserva WHERE id_cliente = ?";
		
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
	
	public List<Reserva> getReservas(){
		String sql = "SELECT * FROM reserva";
		List<Reserva> reservas = new ArrayList<Reserva>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while(rset.next()) {
				Reserva reserva = new Reserva();
				reserva.setId(rset.getInt("id_reserva"));
				reserva.setId_cliente(rset.getInt("id_cliente"));
				reserva.setId_destino(rset.getInt("id_destino"));
				reserva.setData_inicio(rset.getDate("data_inicio"));
				reserva.setTempo_reserva(rset.getInt("tempo_reserva"));
				reserva.setValor_reserva(rset.getDouble("val_reserva"));
			}
		} catch (Exception e){
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
			return reservas;
		}
}
