package com.example.solicitudes.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.solicitudes.model.Solicitud;
import com.example.solicitudes.repository.SolicitudRepository;

@ExtendWith(MockitoExtension.class)  
public class SolicitudServiceTest {


    @Mock
    private SolicitudRepository repository;

    @InjectMocks
    private SolicitudService service;
    

 
 @Test
    void crearSolicitud_devuelveSolicitudGuardada() {
        Solicitud entrada = new Solicitud(null, "22/06/2025", "Comentario de prueba", "100.00");
        Solicitud guardada = new Solicitud(1L, "22/06/2025", "Comentario de prueba", "100.00");

        when(repository.save(entrada)).thenReturn(guardada);

        Solicitud resultado = service.crearSolicitud(entrada);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getComentario()).isEqualTo("Comentario de prueba");
        assertThat(resultado.getTotal()).isEqualTo("100.00");

        verify(repository).save(entrada);
    }

    @Test
    void obtenerTodasLasSolicitudes_retornaListaDesdeRepositorio() {
        List<Solicitud> mockList = Arrays.asList(
            new Solicitud(1L, "22/06/2025", "Comentario 1", "200.00"),
            new Solicitud(2L, "22/06/2025", "Comentario 2", "300.00")
        );

        when(repository.findAll()).thenReturn(mockList);

        List<Solicitud> resultado = service.obtenerTodasSolicitudes();

        assertThat(resultado).isEqualTo(mockList);
    }

    @Test
    void obtenerSolicitudPorId_devuelveSolicitudSiExiste() {
        Solicitud solicitud = new Solicitud(1L, "22/06/2025", "Comentario", "150.00");

        when(repository.findById(1L)).thenReturn(Optional.of(solicitud));

        Solicitud resultado = service.obtenerSolicitudPorId(1L);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getComentario()).isEqualTo("Comentario");

        verify(repository).findById(1L);
    }

    @Test
    void actualizarSolicitud_existente_devuelveActualizada() {
        Solicitud datosActualizados = new Solicitud(null, "22/06/2025", "Comentario Actualizado", "250.00");
        Solicitud esperado = new Solicitud(1L, "22/06/2025", "Comentario Actualizado", "250.00");

        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(any(Solicitud.class))).thenReturn(esperado);

        Solicitud resultado = service.actualizarSolicitud(1L, datosActualizados);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getComentario()).isEqualTo("Comentario Actualizado");

        verify(repository).save(datosActualizados);
    }

    @Test
    void eliminarSolicitud_existente_llamaDeleteById() {
        when(repository.existsById(1L)).thenReturn(true);

        service.eliminarSolicitud(1L);

        verify(repository).deleteById(1L);
    }
}