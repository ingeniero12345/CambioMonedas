package com.hernan.cambioMoneda.iDao;

import java.util.List;

import com.hernan.vo.Rates;

public interface IRatesDao {
	public boolean registrar(Rates rate);
	public List<Rates> obtener();
	public abstract boolean actualizar(Rates rate);

}
