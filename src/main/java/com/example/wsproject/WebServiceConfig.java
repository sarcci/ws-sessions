package com.example.wsproject;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean(name = "Kol")
    public DefaultWsdl11Definition kolsWsdl(XsdSchema kolSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("KolPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl.setSchema(kolSchema);
        return wsdl;
    }

    @Bean(name = "Ispit")
    public DefaultWsdl11Definition ispitsWsdl(XsdSchema ispitSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("IspitPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl.setSchema(ispitSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema kolSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/Kol.xsd"));
    }

    @Bean
    public XsdSchema ispitSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/Ispit.xsd"));
    }
}
