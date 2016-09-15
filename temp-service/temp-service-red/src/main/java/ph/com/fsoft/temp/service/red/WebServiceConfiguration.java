/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ph.com.fsoft.temp.service.red.endpoint.soap.PersonColorServiceSoapEndpoint;

/**
 * This is the configuration for registering SOAP enpoint. Yeah, I know what
 * you're thinking. Unfortunately, we need to register INDIVIDUALLY our SOAP
 * endpoint. So sad :(
 *
 * @author warren.nocos
 */
@Configuration
public class WebServiceConfiguration {

    protected final Bus bus;

    protected final PersonColorServiceSoapEndpoint personColorServiceSoapEndpoint;

    @Inject
    public WebServiceConfiguration(Bus bus,
            PersonColorServiceSoapEndpoint personColorServiceSoapEndpoint) {
        this.bus = bus;
        this.personColorServiceSoapEndpoint = personColorServiceSoapEndpoint;
    }

    /**
     * You can copy-paste this. This is constantly present, and this
     * configuration will probably not change.
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        CXFServlet cxfServlet = new CXFServlet();
        cxfServlet.setBus(bus);
        return new ServletRegistrationBean(cxfServlet, "/api/soap/*");
    }

    /**
     * This is where you explicitly register your SOAP web service. Every class
     * with {@link WebService} annotation must be registered here.
     *
     * @return
     */
    @Bean
    public Endpoint personColorEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, personColorServiceSoapEndpoint);
        endpoint.publish("person/color");
        return endpoint;
    }

}
