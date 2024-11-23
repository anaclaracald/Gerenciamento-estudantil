package poo.ucb.Gerenciamento_Estudantil.model.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Estudante;

import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
    Optional<Estudante> findByNome(String nome);
    Optional<Estudante> findByMatricula(String matricula);
}
