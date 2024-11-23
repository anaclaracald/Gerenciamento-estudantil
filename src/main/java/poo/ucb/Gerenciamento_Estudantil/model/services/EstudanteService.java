package poo.ucb.Gerenciamento_Estudantil.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.entities.Estudante;
import poo.ucb.Gerenciamento_Estudantil.model.repositories.EstudanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante cadastrarEstudante(Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> listarEstudantes(){
        return estudanteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Optional<Estudante> buscarPorMatricula(Long matricula){
        return estudanteRepository.findById(matricula);
    }

    public Optional<Estudante> buscarPorNome(String nome){
        return estudanteRepository.findByNome(nome);
    }

    public Estudante editarEstudante(Long id, Estudante estudanteAtualizado){
        return estudanteRepository.findById(id).map(estudante -> {
            estudante.setNome(estudanteAtualizado.getNome());
            estudante.setIdade(estudanteAtualizado.getIdade());
            return estudanteRepository.save(estudante);
        }).orElseThrow(() -> new RuntimeException("Estudante não encontrado"));
    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);
    }
}

