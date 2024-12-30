/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol.model;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Venta {
    private int id;
    private Date fecha;
    private Persona persona;
    private String nombresPersona;
    private String apellidosPersona;
    private long numDocumentoPersona;
    private long numCelularPersona;
    private double monto;
    private int idPersona;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        return this.id == other.id;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getNombresPersona() {
        return nombresPersona;
    }

    public void setNombresPersona(String nombresPersona) {
        this.nombresPersona = nombresPersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public long getNumDocumentoPersona() {
        return numDocumentoPersona;
    }

    public void setNumDocumentoPersona(long numDocumentoPersona) {
        this.numDocumentoPersona = numDocumentoPersona;
    }

    public long getNumCelularPersona() {
        return numCelularPersona;
    }

    public void setNumCelularPersona(long numCelularPersona) {
        this.numCelularPersona = numCelularPersona;
    }

    public double getMonto() {
        return monto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}