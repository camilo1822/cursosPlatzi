package com.anncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	
	/**
	 * Este método captura el tiempo exacto inicial de visualización.
	 * 
	 * @param dateI es un objeto {@code date}
	 * @return Devuelve fecha y hora capturada
	 */
	Date startToSee(Date dateI);
	
	/**
	 * Este método captura el tiempo exacto final de visualización.
	 * 
	 * @param dateI
	 * @param dateF
	 */
	void stopToSee(Date dateI, Date dateF);
	
}
