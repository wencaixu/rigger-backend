#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiggerTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiggerTaskApplication.class, args);
    }

}
