package isil.pe.springdatajpa.repository;

import isil.pe.springdatajpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { //EXTENDS para añadir las funcionalidades de JPA

    List<Customer> findCustomerByName(String name) ;

    Customer findCustomerByEmail(String name);
}
