package poo.ucb.Gerenciamento_Estudantil.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Curso;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNome(String nome);
}
