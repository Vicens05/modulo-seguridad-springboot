package isil.pe.springdatajpa.controller;

import isil.pe.springdatajpa.entity.Customer;
import isil.pe.springdatajpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //sabe que es un apiRest
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping({"/hello", "/", "/home"})
    public String helloController(){
        return "Hola Mundo";
    }

    @PostMapping("/add") //Post te registra un recurso en el servidor
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping("/getall")
    public List<Customer> getall(){
        return customerService.getall();
    }

    @GetMapping("/getbyname")
    public List<Customer> findByName(@RequestParam String name){
        return customerService.findByName(name);
    }

    @GetMapping("getbyemail")
    public Customer findByEmail(@RequestParam String email){
        return customerService.findByEmail(email);
    }

    @PostMapping("/updatecustomer")
    public void updateCustomer(@RequestParam String email, @RequestBody Customer customer){
        customerService.updateCustomer(customer, email);
    }
}
