package dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Student;

@Repository
@Transactional
public class StudentDao {
	
		@Autowired
		private SessionFactory sessionFactory;

		
		public void insertUser(Student cust)
		{
			Session sess=sessionFactory.openSession();
			sess.save(cust);
			sess.flush();
			SQLQuery sq=sess.createSQLQuery("insert into user_authorization values(2,'"+cust.getCust_id()+"','ROLE_USER')");
			sq.executeUpdate();
		}
		
		public boolean login(String un,String pass)
		{
			boolean b=false;
			
			Session sess=sessionFactory.openSession();
			Criteria c=sess.createCriteria(Student.class);
			c.add(Restrictions.and(Restrictions.eq("username", un), Restrictions.eq("password", pass)));
			List<Student>l=c.list();
			if(l.isEmpty())
				b=false;
			else
				b=true;
				
			return b;
		}
	}



