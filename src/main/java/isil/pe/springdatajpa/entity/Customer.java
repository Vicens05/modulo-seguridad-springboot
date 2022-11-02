package isil.pe.springdatajpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name="email_uique")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //dato tipo identity, genera un autoincrement
    private Long id;

    private String name;

    private String lastname;

    @Column(name="email")
    private String email;

    private Date createdDate;

    @PostPersist
    public void postPersist(){
        System.out.println("Después de registrar");
        this.createdDate = new Date();
    }

    @PrePersist
    public void prePersist(){
        System.out.println("Antes de registrar");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
