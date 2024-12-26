/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol.model;

/**
 *
 * @author user
 */
public class Persona {
    private int id;
    private int numDocumento;
    private String nombres;
    private String apellidos;
    private String sexo;
    private int numCelular;

    public int getId() {
        return id;
    }
    
    public int getNumDocumento() {
        return numDocumento;
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public String getSexo() {
        return sexo;
    }
    
    public int getNumCelular() {
        return numCelular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNumCelular(int numCelular) {
        this.numCelular = numCelular;
    }
    
}
