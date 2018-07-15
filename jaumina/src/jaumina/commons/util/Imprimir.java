package jaumina.commons.util;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

//http://granodearena.blogspot.com/2012/06/utilizar-la-impresora-en-java.html
public class Imprimir{
	
	private static ObjetoDeImpresion o;
	
static public void main(String []args){
PrinterJob job = PrinterJob.getPrinterJob();
job.setPrintable(o);
if(job.printDialog()){
try{
job.print();
}catch(PrinterException e){
System.out.println(e);
}
}
}

public ObjetoDeImpresion getO() {
	return o;
}

public void setO(ObjetoDeImpresion o) {
	Imprimir.o = o;
}
}
