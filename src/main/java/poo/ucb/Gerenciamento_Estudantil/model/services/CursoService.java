package poo.ucb.Gerenciamento_Estudantil.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poo.ucb.Gerenciamento_Estudantil.model.repositories.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


}
