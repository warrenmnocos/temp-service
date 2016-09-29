/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.web.client.RestTemplate;
import ph.com.fsoft.temp.service.blue.service.PersonService;

/**
 * Configuration for REST client.
 *
 * @author warren.nocos
 */
@Configuration
public class ServiceClientConfiguration {

    /**
     * We will add an special REST template for service-to-service
     * communications leveraging service-discovery pattern.
     *
     * @return the restTemplate.
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean() throws MalformedURLException {
        JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean;
        jaxWsPortProxyFactoryBean = new JaxWsPortProxyFactoryBean();
        jaxWsPortProxyFactoryBean.setWsdlDocumentUrl(
                new URL("http://localhost:8082/blue/api/soap/person?wsdl"));
        jaxWsPortProxyFactoryBean.setServiceName("PersonServiceSoapEndpointService");
        jaxWsPortProxyFactoryBean.setPortName("PersonServiceSoapEndpointPort");
        jaxWsPortProxyFactoryBean.setNamespaceUri("http://soap.endpoint.blue.service.temp.fsoft.com.ph/");
        jaxWsPortProxyFactoryBean.setServiceInterface(PersonService.class);
        return jaxWsPortProxyFactoryBean;
    }

    @Bean
    public PersonService personService(JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean) {
        return (PersonService) jaxWsPortProxyFactoryBean.getObject();
    }

}
