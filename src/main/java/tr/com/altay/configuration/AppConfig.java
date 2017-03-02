package tr.com.altay.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by mustafa.ergan
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"tr.com.altay"})
public class AppConfig extends WebMvcConfigurerAdapter {


    /**
     * property files ayarlama yapılacak yer
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


    /**
     * statik javascript gibi yapıların tutulacağı yer
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/**");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
    }

}
