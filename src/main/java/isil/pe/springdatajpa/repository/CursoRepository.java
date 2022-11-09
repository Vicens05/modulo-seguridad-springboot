package isil.pe.springdatajpa.repository;

import isil.pe.springdatajpa.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
