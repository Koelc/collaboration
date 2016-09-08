package service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import dao.StudentDao;
	import model.Student;

	@Service
	public class StudentService {
		
		@Autowired
		StudentDao custdao;
		
		public void insertUser(Student cust)
		{
			custdao.insertUser(cust);
		}
		
		 public boolean login(String user,String pass)
		 {
			 return custdao.login(user, pass);
		 }
		
		    
		
	}



