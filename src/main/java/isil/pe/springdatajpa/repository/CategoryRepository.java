package isil.pe.springdatajpa.repository;

import isil.pe.springdatajpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { //Recibe la entidad y el tipo de dato que es el ID

}
