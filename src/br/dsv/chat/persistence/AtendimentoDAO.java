package br.dsv.chat.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.dsv.chat.beans.Chat;
import br.dsv.chat.util.HibernateUtil;

public class AtendimentoDAO {
	
	public void salvar(Chat atendimento){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(atendimento);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Chat> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(Chat.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}

}
