package poo.ucb.Gerenciamento_Estudantil.model.services;

import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Professor;
import poo.ucb.Gerenciamento_Estudantil.model.repositories.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor cadastrarProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> listarProfessores(){
        return this.professorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Optional<Professor> buscarPorNome(String nome){
        return this.professorRepository.findByNome(nome);
    }

    public Optional<Professor> buscarPorId(Long id){
        return this.professorRepository.findById(id);
    }

    public Professor editarProfessor(Long id, Professor professorAtualizado){
        return professorRepository.findById(id).map(professor -> {
            professor.setNome(professorAtualizado.getNome());
            professor.setEspecialidade(professorAtualizado.getEspecialidade());
            return this.professorRepository.save(professor);
        }).orElseThrow(() -> new RuntimeException("Professorr não encontrado"));
    }

    public void excluirProfessor(Long id) {
        this.professorRepository.deleteById(id);
    }
}
