package com.example.solicitudes.model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Asegúrate de definir un identificador
    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_solicitud; //DD/MM/YYYY

    @Column(nullable = true) 
    private String comentario; // Comentarios adicionales
    
    @Column(nullable = false)
    private String total; // Total de la solicitud
}