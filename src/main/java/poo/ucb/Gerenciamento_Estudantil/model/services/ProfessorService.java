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

    public void cadastrarProfessor(Professor professor){
        professorRepository.save(professor);
    }

    public List<Professor> listarProfessores(){
        return professorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Optional<Professor> buscarPorNome(String nome){
        return professorRepository.findByNome(nome);
    }

    public Optional<Professor> buscarPorId(Long id){
        return professorRepository.findById(id);
    }

    public Professor editarProfessor(Long id, Professor professorAtualizado){
        return professorRepository.findById(id).map(professor -> {
            professor.setNome(professorAtualizado.getNome());
            professor.setEspecialidade(professorAtualizado.getEspecialidade());
            return professorRepository.save(professor);
        }).orElseThrow(() -> new RuntimeException("Professorr não encontrado"));
    }

    public void excluirProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
