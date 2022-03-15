package agencia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import agencia.factory.connectionfactory;
import agencia.model.Destino;

public class DestinoDAO {
	public void save(Destino destino) {
		String sql = "INSERT INTO destino(contato_destino, adress, tipo, descricao, val_diaria) VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, destino.getContato());
			pstm.setString(2, destino.getAdress());
			pstm.setString(3, destino.getTipo());
			pstm.setString(4, destino.getDescricao());
			pstm.setDouble(5, destino.getVal_diaria());
			pstm.execute();
		} catch(Exception e) {
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
	
	public void update(Destino destino) {
		String sql = "UPDATE destino = ?, contato_destino = ?, adress = ?, tipo = ?, descricao = ?, val_diaria = ? " + "WHERE id_destino = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, destino.getContato());
			pstm.setString(2, destino.getAdress());
			pstm.setString(3, destino.getTipo());
			pstm.setString(4, destino.getDescricao());
			pstm.setDouble(5, destino.getVal_diaria());
			pstm.setInt(6, destino.getId());
			pstm.execute();
		} catch(Exception e) {
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
	
	public void deleteById(int id) {
		String sql = "DELETE FROM destino WHERE id_cliente = ?";
		
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
	
	public List<Destino> getDestinos(){
		String sql = "SELECT * FROM destino";
		List<Destino> destinos = new ArrayList<Destino>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while(rset.next()) {
				Destino destino = new Destino();
				destino.setId(rset.getInt("id_destino"));
				destino.setContato(rset.getString("contato_destino"));
				destino.setAdress(rset.getString("adress"));
				destino.setTipo(rset.getString("tipo"));
				destino.setDescricao(rset.getString("descricao"));
				destino.setVal_diaria(rset.getDouble("val_diaria"));
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
		return destinos;
	}
}
