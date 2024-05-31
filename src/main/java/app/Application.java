package app;

import domain.Book;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repository.BookRepository;
import repository.CustomerRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;
    @Autowired
	BookRepository bankRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerRepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerRepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerRepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerRepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerRepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		bankRepository.save(new Book("Java", "Oracle", "1234", 100.0));
		bankRepository.save(new Book("Spring", "Pivotal", "5678", 200.0));
		bankRepository.save(new Book("Hibernate", "RedHat", "9876", 300.0));
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bankRepository.findAll()) {
			System.out.println(book);
		}
		System.out.println("Update book with id 1");
	    bankRepository.updateById(1L,"Java", "Oracle", "1234", 200.0);
		bankRepository.deleteById(2L);
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book bk : bankRepository.findAll()) {
			System.out.println(bk);
		}




	}

}
