package jaumina.commons.util;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.List;
import jaumina.entidades.ventas1.PedidoAImprimir1;
//import jaumina.entidades.ventas.PedidoAImprimir;

public class ObjetoDeImpresion implements Printable{
	
		
private List<PedidoAImprimir1> lista;
	
	public int print(Graphics g, PageFormat f, int pageIndex){
if(pageIndex == 0){
	
	if(lista!= null && !lista.isEmpty()){

		for (PedidoAImprimir1 p: lista) {
			g.drawString(p.getString(), p.getHorizontal(), p.getVertical());
		}
	}

return PAGE_EXISTS;
}else{
return NO_SUCH_PAGE;
}
}
	public List<PedidoAImprimir1> getLista() {
		return lista;
	}

	public void setLista(List<PedidoAImprimir1> lista) {
		this.lista = lista;
	}


}
