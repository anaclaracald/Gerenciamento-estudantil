package poo.ucb.Gerenciamento_Estudantil.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
