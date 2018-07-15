package jaumina.entidades.ventas;

public class PedidoAImprimir {
private String string;
private Integer horizontal;
private Integer vertical;

public PedidoAImprimir(String string, Integer horizontal, Integer vertical) {
this.string = string;
this.horizontal = horizontal;
this.vertical = vertical;
}

public String getString() {
	return string;
}
public void setString(String string) {
	this.string = string;
}
public Integer getHorizontal() {
	return horizontal;
}
public void setHorizontal(Integer horizontal) {
	this.horizontal = horizontal;
}
public Integer getVertical() {
	return vertical;
}
public void setVertical(Integer vertical) {
	this.vertical = vertical;
}
}
