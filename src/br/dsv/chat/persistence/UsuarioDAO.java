package br.dsv.chat.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.dsv.chat.beans.Usuario;
import br.dsv.chat.util.HibernateUtil;

public class UsuarioDAO {
	
	public void salvar(Usuario usuario){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(usuario);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(Usuario.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}
	

}
