package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {

            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            for(Customer customer : repository.findAll()) {
                System.out.println(customer.toString());
            }

            repository.findById(1L)
                    .ifPresent(customer -> {
                        System.out.println("Customer found with findById(1L):");
                        System.out.println(customer.toString());
                    });

            repository.findByLastName("Bauer").forEach( bauer -> {
                System.out.println(bauer.toString());
            });
        };
    }


}
