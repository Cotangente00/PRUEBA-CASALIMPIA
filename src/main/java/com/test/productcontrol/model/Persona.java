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
    private long numDocumento;
    private String nombres;
    private String apellidos;
    private String sexo;
    private long numCelular;

    public int getId() {
        return id;
    }
    
    public long getNumDocumento() {
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
    
    public long getNumCelular() {
        return numCelular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumDocumento(long numDocumento) {
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

    public void setNumCelular(long numCelular) {
        this.numCelular = numCelular;
    }
    
}
