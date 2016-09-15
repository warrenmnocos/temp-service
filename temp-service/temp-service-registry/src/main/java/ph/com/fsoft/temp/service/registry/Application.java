/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * This is the starter application of this microservice. Extending
 * {@link SpringBootServletInitializer} will make this app deployable in any
 * Servlet-based web servers like Tomcat. If intended to make this app
 * executable only, extending {@link SpringBootServletInitializer} can be
 * avoided.
 *
 * @author warren.nocos
 */
@SpringBootApplication
@EnableEurekaServer
public class Application extends SpringBootServletInitializer {

    /**
     * {@inheritDoc }
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    /**
     * @param arguments the command line arguments
     */
    public static void main(String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }

}
