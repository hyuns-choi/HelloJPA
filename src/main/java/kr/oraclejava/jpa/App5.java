package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App5 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();
		
		PhoneDao<Phone> dao = new PhoneDaoImpl(manager);
		
		//Phone iphonex = new Phone("아이폰x", 50000);
		//dao.addEntity(iphonex);
		Phone phone = manager.find(Phone.class, 17);
		//phone.setPrice(40000);
		//dao.updateEntity(phone);
		
		// delete
		//dao.removeEntity(phone);
		//dao.removeEntity(16);
		
		
		List<Phone> pList = dao.getAllEntity();		
		
		for(Phone p : pList) {
			System.out.printf("%s %s %s\n", p.getId(), p.getName(), p.getPrice());
		}
	}

}
