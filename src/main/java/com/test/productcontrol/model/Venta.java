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
    private double monto;

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Persona getPersona() {
        return persona;
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
}