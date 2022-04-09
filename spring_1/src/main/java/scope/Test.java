package scope;

public class Test {
    public static void main(String[] args) throws Exception {
        //启动工厂
//        ApplicationContext context = new ClassPathXmlApplicationContext("scope/spring.xml");
//        ManageDao manageDao = (ManageDao) context.getBean("manageDao");
//        System.out.println("userDao = " + manageDao);
//        ManageDao manageDao2 = (ManageDao) context.getBean("manageDao");
//        System.out.println("userDao2 = " + manageDao2);
//        if(manageDao == manageDao2) System.out.println("yy");
        ManageDao manageDao = (ManageDao) Class.forName("scope.ManageDaoImpl").newInstance();
        System.out.println(manageDao);
    }
}
