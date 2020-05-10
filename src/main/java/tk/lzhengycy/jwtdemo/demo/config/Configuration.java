package tk.lzhengycy.jwtdemo.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import tk.lzhengycy.jwtdemo.demo.filter.JwtFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Configuration
 * @Author 6yi
 * @Date 2020/5/10 22:35
 * @Version 1.0
 * @Description:
 */

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        //添加需要拦截的url
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/use");
        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
        return registrationBean;
    }
}
