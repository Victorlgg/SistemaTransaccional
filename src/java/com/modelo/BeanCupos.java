/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Victor
 */
public class BeanCupos {
    private String idEstudiante;
    private String idAsignatura;

    public BeanCupos(String idEstudiante, String idAsignatura) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
}
