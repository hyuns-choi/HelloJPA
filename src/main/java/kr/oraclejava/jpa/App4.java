package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App4 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();
		
		PhoneDao<Phone> dao = new PhoneDaoImpl(manager);
		
		//List<Phone> pList = dao.getAllEntity();
		List<Phone> pList = dao.findByField("name", "갤럭시s8");
		
		for(Phone p : pList) {
			System.out.printf("%s %s %s\n", p.getId(), p.getName(), p.getPrice());
		}
	}

}
