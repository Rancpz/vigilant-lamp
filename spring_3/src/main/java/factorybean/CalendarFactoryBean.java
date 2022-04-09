package factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

//用来书写复杂对象的创建方式
public class CalendarFactoryBean implements FactoryBean {
    @Override
    public Calendar getObject() throws Exception {
        return Calendar.getInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
