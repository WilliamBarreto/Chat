package br.dsv.chat.beans;

import java.io.Serializable;
import java.util.List;

public class Chat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Chat(){

	}
	
	private Usuario usuario;
	private int id;
	private List<String> texto;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<String> getTexto() {
		return texto;
	}
	public void setTexto(List<String> texto) {
		this.texto = texto;
	}

}
