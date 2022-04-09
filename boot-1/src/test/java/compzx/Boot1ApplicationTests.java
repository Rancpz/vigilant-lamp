package compzx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class Boot1ApplicationTests {

	@Test
	public void testBean(){
		// 获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//XmlBeanFactory beanFactory= new XmlBeanFactory(new ClassPathResource("bean.xml"));
		// 根据beanID获取对象
		// 调用前必须在springContext.xml中配置注解方式解析
//		UserService userService = (UserService) ac.getBean("Service");
//		userService.saveCustom();
	}
}
