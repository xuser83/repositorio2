 package jaumina.commons.util.test;

import jaumina.commons.util.MensajesController;

public class Test {
 
	public static void main(String[] args) {
		try{
		String s = "";
		String s1 = s.substring(0, 10);
		System.out.println(s1);
		} catch(Exception e) {
MensajesController m = new MensajesController();
			m.escribirArchivo("Clase: ProductosVentasBean, "
					+ " Método: verificarCodigoRepetido, Error al intentar verificar código Repetido,"
					+ " Exception: " + e.getMessage());		
		}
	}
}

