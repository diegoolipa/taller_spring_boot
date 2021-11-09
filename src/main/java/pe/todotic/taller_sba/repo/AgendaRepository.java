package pe.todotic.taller_sba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.todotic.taller_sba.model.Libro;

import java.util.List;
import java.util.Optional;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findTop8ByOrderByFechaCreacionDesc();


    Optional<Libro> findBySlug(String slug);
}
