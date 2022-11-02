package isil.pe.springdatajpa.service;

import isil.pe.springdatajpa.entity.Customer;
import isil.pe.springdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired //Para añadir dependecnias se pone Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getall(){
        return customerRepository.findAll();
    }

    public List<Customer> findByName(String name){
        return customerRepository.findCustomerByName(name);
    }

    public Customer findByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    @Transactional
    public void updateCustomer(Customer customer, String email){

        Customer customerToUpdate = customerRepository.findCustomerByEmail(email); //obtenme un cliente de la BD
        if(customerToUpdate != null){
            customerToUpdate.setEmail(customer.getEmail() !=null?
                    customer.getEmail(): customerToUpdate.getEmail()); //If ternario --> Si se cumple el customer.getEmail y si no es nulo, deja el que ya estaba
            customerToUpdate.setName(customer.getName() !=null?
                    customer.getName() : customerToUpdate.getName());
            customerToUpdate.setLastname(customer.getLastname() !=null?
                    customer.getLastname() : customerToUpdate.getLastname());
            //customerRepository.save(customerToUpdate); ya no se usa, usando el @Transactional
        }
    }
}
