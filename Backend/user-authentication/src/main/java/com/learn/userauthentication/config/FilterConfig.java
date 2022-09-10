package com.learn.userauthentication.config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig
{
    @SuppressWarnings({"unchecked","rawtypes"})
    @Bean
    public FilterRegistrationBean getFilterRegistration()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JWtAuthTokenFilter());
        bean.addUrlPatterns("/user/onlyforVerified");
        return bean;
    }
}
