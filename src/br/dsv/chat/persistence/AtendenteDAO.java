package br.dsv.chat.persistence;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.dsv.chat.beans.Atendente;
import br.dsv.chat.util.HibernateUtil;

public class AtendenteDAO {
	
	public void salvar(Atendente atendente){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(atendente);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendente> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(Atendente.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}

}
