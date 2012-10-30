package br.dsv.chat.controls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.dsv.chat.beans.Atendente;
import br.dsv.chat.beans.Chat;
import br.dsv.chat.beans.Usuario;


@ManagedBean
@SessionScoped
public class AtendimentoControle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Atendente atendente;
	private Chat chat;
	private List<Chat> chats;
	private List<Usuario> usuarios;
	private int aux = 0;
	
	public AtendimentoControle(){
		
		FacesContext.getCurrentInstance().getAttributes();
		
		this.usuario = new Usuario();
		this.atendente = new Atendente();
		this.chats = new ArrayList<Chat>();
		this.setUsuarios(new ArrayList<Usuario>());
		this.chat = new Chat();
	}
	
	public void solicitar(){
		this.usuario.setNome("William");
		this.chat.setId(aux);
		this.chat.setUsuario(usuario);
		this.chats.add(this.chat);
		this.aux++;
		this.chat = new Chat();
		this.usuario = new Usuario();
	}
	
	public String Atender(){
		return "atender";
	}
	
	public String chamarFila(){

		try{
		this.atendente.setSala(chats.get(0));
		chats.remove(0);			
		}catch(Exception ex){
		
			System.out.println("Sem ninguem animal...");
		}
		return "chat";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Atendente getAtendente() {
		return atendente;
	}
	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}