package poo.ucb.Gerenciamento_Estudantil.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Professor;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Optional<Professor> findByNome(String nome);
}
