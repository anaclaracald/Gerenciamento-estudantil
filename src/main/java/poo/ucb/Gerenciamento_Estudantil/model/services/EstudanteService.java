package poo.ucb.Gerenciamento_Estudantil.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.repositories.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    // CRUD - criar, ler, atuallizar e deletar


}
