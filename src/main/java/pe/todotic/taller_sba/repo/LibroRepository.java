package pe.todotic.taller_sba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.todotic.taller_sba.model.Libro;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
