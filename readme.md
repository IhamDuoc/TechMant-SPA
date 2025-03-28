# TechMart SPA - Migración a Microservicios

## Descripción del Proyecto

Este proyecto tiene como objetivo la migración de la arquitectura monolítica actual de TechMart SPA a una arquitectura de microservicios. TechMart SPA, dedicada al mantenimiento y reparación de dispositivos electrónicos, busca mejorar la escalabilidad, mantenibilidad y agilidad de su sistema para responder de manera más eficiente a las necesidades de sus clientes.

## Objetivos

* Descomponer el sistema monolítico en microservicios independientes basados en dominios.
* Implementar una arquitectura escalable y resiliente.
* Mejorar la agilidad en el desarrollo y despliegue de nuevas funcionalidades.
* Garantizar la compatibilidad con el sistema actual durante la transición.
* Asegurar la privacidad y seguridad de los datos de los usuarios.

## Arquitectura

Se ha optado por una arquitectura de microservicios basada en dominios, complementada con microservicios de funcionalidad para capacidades transversales.

* **Microservicios por Dominio:**
    * Gestión de Clientes
    * Gestión de Dispositivos
    * Gestión de Órdenes de Servicio
    * Gestión de Inventario
    * Gestión de Técnicos
    * Gestión de Facturación y Reportes
* **Microservicios por Funcionalidad:**
    * Autenticación
    * Notificaciones
    * Reportes
    * Pagos

## Tecnologías Utilizadas

* **Lenguajes:** TypeScript, Java
* **Frameworks:** Spring Boot, Next.js (React)
* **Bases de datos:** MySQL, MongoDB
* **Plataforma en la nube:** AWS

## Consideraciones Éticas

Se prioriza la privacidad y seguridad de los datos de los usuarios, implementando medidas como:

* Encriptación de datos.
* Autenticación segura.
* Cumplimiento de normativas locales e internacionales (Ley de Protección de Datos en Chile, RGPD).

## Plan de Migración

Se utilizará el patrón Strangler Fig para realizar una migración gradual, garantizando la compatibilidad con el sistema monolítico durante la transición. Se implementará un API Gateway para gestionar las comunicaciones y se realizarán pruebas exhaustivas para minimizar riesgos.

## Identificación de Riesgos y Mitigación

Se han identificado riesgos como incompatibilidad de versiones, caídas del sistema y pérdida de datos. Se implementarán estrategias de mitigación como:

* API Gateway y contratos de API versionados.
* Despliegue gradual y monitorización en tiempo real.
* Copias de seguridad y validación de datos.
* Utilización de DDD para diseño de microservicios.

## Contacto

Para más información, contactar a: Abraham, Sebastian e Iham