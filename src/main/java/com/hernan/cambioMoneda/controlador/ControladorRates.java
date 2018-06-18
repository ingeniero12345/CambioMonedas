package com.hernan.cambioMoneda.controlador;

import java.util.ArrayList;
import java.util.List;

import com.hernan.cambioMoneda.dao.RatesDAOImpl;
import com.hernan.cambioMoneda.iDao.IRatesDao;
import com.hernan.cambioMoneda.vista.VistaRates;
import com.hernan.vo.Rates;
 
public class ControladorRates {
	
	private VistaRates vista= new VistaRates();
	
	public ControladorRates() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(Rates rates ) {
		RatesDAOImpl dao= new  RatesDAOImpl();
		dao.registrar(rates);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Rates rates) {
		IRatesDao dao= new  RatesDAOImpl();
		dao.actualizar(rates);
	}
	
//	//llama al DAO para eliminar un cliente
//	public void eliminar(Rates rates) {
//		IRatesDao dao= new  RatesDAOImpl();
//		dao.eliminar(rates);
//	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verRates(){
		List<Rates> rates = new ArrayList<Rates>();
		IRatesDao dao= new  RatesDAOImpl();
		rates=dao.obtener();
		vista.verClientes(rates);
	}
}