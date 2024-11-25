package poo.ucb.Gerenciamento_Estudantil.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Curso;
import poo.ucb.Gerenciamento_Estudantil.model.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso cadastrarCurso(Curso curso){
        return this.cursoRepository.save(curso);
    }

    public List<Curso> listarCursos(){
        return this.cursoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Optional<Curso> buscarPorNome(String nome){
        return this.cursoRepository.findByNome(nome);
    }

    public Optional<Curso> buscarPorId(Long id){
        return this.cursoRepository.findById(id);
    }

    public Curso editarCurso(Long id, Curso cursoAtualizado){
        return cursoRepository.findById(id).map( curso -> {
            curso.setNomeCurso(cursoAtualizado.getNomeCurso());
            curso.setProfessor(cursoAtualizado.getProfessor());
            curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());
            return this.cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    public void deletarCurso(Long id){
        this.cursoRepository.deleteById(id);
    }

}
