package com.hernan.cambioMoneda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hernan.cambioMoneda.conexion.Conexion;
import com.hernan.cambioMoneda.iDao.IRatesDao;
import com.hernan.vo.Rates;
 
public class RatesDAOImpl implements IRatesDao {	
	
	
	public boolean registrar(Rates rate) {
		List registrosColl=consultarRegistro(rate);		
		boolean registrar = false;
		if(registrosColl.isEmpty()) {
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO rates values ('"+rate.getNombreMoneda()+"','"+rate.getValor()+"','"+rate.getSimbolo()+"')";
		
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ratesDaoImple, método registrar");
			e.printStackTrace();
		}
		}else {
			actualizar(rate);
			registrar=true;
		}
		return registrar;
	}
 

	public List<Rates> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM rates ORDER BY nombre";
		
		List<Rates> listaCliente= new ArrayList<Rates>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Rates c=new Rates();
				c.setNombreMoneda(rs.getString(1));
				c.setValor(rs.getString(2));
				c.setSimbolo(rs.getString(3));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ratesDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
	}
 
	public List<Rates> consultarRegistro(Rates rate) {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM rates where nombre='"+rate.getNombreMoneda()+"'";
		
		List<Rates> listaCliente= new ArrayList<Rates>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Rates c=new Rates();
				c.setNombreMoneda(rs.getString(1));
				c.setValor(rs.getString(2));
				c.setSimbolo(rs.getString(3));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ratesDaoImple, método consultar");
			e.printStackTrace();
		}
		
		return listaCliente;
	}
	public boolean actualizar(Rates rates) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE rates SET nombre='"+rates.getNombreMoneda()+"', valor='"+rates.getValor()+"', simbolo='"+rates.getSimbolo()+"'" +" WHERE nombre='"+rates.getNombreMoneda()+"'";
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ratesDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
//	@Override
//	public boolean eliminar(Cliente cliente) {
//		Connection connect= null;
//		Statement stm= null;
//		
//		boolean eliminar=false;
//				
//		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
//		try {
//			connect=Conexion.conectar();
//			stm=connect.createStatement();
//			stm.execute(sql);
//			eliminar=true;
//		} catch (SQLException e) {
//			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
//			e.printStackTrace();
//		}		
//		return eliminar;
//	}

//	public boolean registrar(Rates rate) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	public boolean actualizar(Rates rate) {
//		// TODO Auto-generated method stub
//		return false;
//	}
 
}
