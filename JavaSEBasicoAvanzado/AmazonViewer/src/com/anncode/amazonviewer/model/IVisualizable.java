package com.anncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	
	/**
	 * Este m�todo captura el tiempo exacto inicial de visualizaci�n.
	 * 
	 * @param dateI es un objeto {@code date}
	 * @return Devuelve fecha y hora capturada
	 */
	Date startToSee(Date dateI);
	
	/**
	 * Este m�todo captura el tiempo exacto final de visualizaci�n.
	 * 
	 * @param dateI
	 * @param dateF
	 */
	void stopToSee(Date dateI, Date dateF);
	
}
