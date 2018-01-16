package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App3 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();
	
		Phone phone = new Phone();
		phone.setName("중고폰");
		phone.setPrice(10000);
		
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(phone);		// insert
		manager.flush();
		tran.commit();
		
	}

}
