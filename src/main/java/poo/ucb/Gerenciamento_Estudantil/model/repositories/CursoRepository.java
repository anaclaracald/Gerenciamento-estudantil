package poo.ucb.Gerenciamento_Estudantil.model.repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
