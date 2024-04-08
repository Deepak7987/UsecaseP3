package com.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.ChannelDTO;

public class ChannelModel {
	
	public void add(ChannelDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);
		tx.commit();
		session.close();

		
	}
    public void update(ChannelDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.update(dto);
		tx.commit();
		session.close();

		
	}
     public void delete(ChannelDTO dto) {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();

	session.delete(dto);
	tx.commit();
	session.close();

	
}
     
     public List search(ChannelDTO dto) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			 
			Criteria c =  session.createCriteria(ChannelDTO.class);
			
			if(dto !=null) {
				if(dto.getChannelname() !=null && dto.getChannelname().length() > 0) {
					c.add(Restrictions.like("channelname", dto.getChannelname()+ "%"));
				}
				if(dto.getId() !=0 && dto.getId()>0) {
				c.add(Restrictions.eq("id", dto.getId()));	
				}
			}
			List list = c.list();
			tx.commit();
			
			return list;
			
		}
		public ChannelDTO findByPk(long id) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			ChannelDTO dto =  (ChannelDTO) session.get(ChannelDTO.class, id);
			
			
			return dto;
			
		}

}
