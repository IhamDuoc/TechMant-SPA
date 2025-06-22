package com.example.tecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tecnico.model.Tecnico;
import com.example.tecnico.repository.TecnicoRepository;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    // Crear un nuevo técnico
    public Tecnico crearTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    // Obtener todos los técnicos
    public List<Tecnico> obtenerTodosLosTecnicos() {
        return tecnicoRepository.findAll();
    }
    
    // Buscar un técnico por ID
    public Tecnico obtenerTecnicoPorId(Long id) {
        return tecnicoRepository.findById(id).get();
    }

    // Actualizar un técnico
    public Tecnico actualizarTecnico(Long id, Tecnico tecnicoActualizado) {
        if (tecnicoRepository.existsById(id)) {
            tecnicoActualizado.setId(id);
            return tecnicoRepository.save(tecnicoActualizado);
        }
        return null;
    }

    // Eliminar un técnico
    public void eliminarTecnico(Long id) {
        if (tecnicoRepository.existsById(id)) {
            tecnicoRepository.deleteById(id);
        }
    }

}
