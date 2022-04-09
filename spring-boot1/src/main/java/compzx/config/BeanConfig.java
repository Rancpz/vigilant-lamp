package compzx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
public class BeanConfig {
    @Bean
    public Calendar getCalendar() {
        return Calendar.getInstance();
    }

}
