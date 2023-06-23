package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/projetoES4A4?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "R3deL0c@l";
	
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	
	public ArrayList<VooBean> listarVoos(){
		String read = "select * from voos order by datavoo";
		ArrayList<VooBean> voos = new ArrayList<>();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String idvoo = rs.getString(1);
				String origem = rs.getString(2);
				String destino = rs.getString(3);
				String data = rs.getString(4);
				
				voos.add(new VooBean(idvoo, origem, destino, data));
			}
			
			con.close();
			
			return voos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarVoo(VooBean voo) {
		String read = "select * from voos where idvoo = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, voo.getIdvoo());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				voo.setIdvoo(rs.getString(1));
				voo.setOrigem(rs.getString(2));
				voo.setDestino(rs.getString(3));
				voo.setData(rs.getString(4));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void criarUsuario(UsuarioBean usuario) {
		String create = "insert into usuarios (iduser, nome, endereco, telefone, senha) values (?, ?, ?, ?, ?)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, usuario.getIdUser());
			pst.setString(2, usuario.getNome());
			pst.setString(3, usuario.getEndereco());
			pst.setString(4, usuario.getTelefone());
			pst.setString(5, usuario.getSenha());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
