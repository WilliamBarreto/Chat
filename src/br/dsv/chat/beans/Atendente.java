package br.dsv.chat.beans;
import java.io.Serializable;

public class Atendente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String nome;
	private Chat sala;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Chat getSala() {
		return sala;
	}
	public void setSala(Chat sala) {
		this.sala = sala;
	}
	
	

}