package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App2 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();
		
		List<Phone> phoneList =
				// HQL (Hibernate Query Language)
				//manager.createQuery("SELECT p FROM Phone p").getResultList();
				manager.createQuery("SELECT p FROM Phone p").getResultList();
		
		Phone phone = manager.find(Phone.class, 1);
		System.out.println(phone.getName());
		
	}

}
