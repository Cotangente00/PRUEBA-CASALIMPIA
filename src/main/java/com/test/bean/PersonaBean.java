/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.bean;

import com.test.productcontrol.PersonaRegister;
import com.test.productcontrol.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author user
 */

@ManagedBean
@ViewScoped
public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> lstPersonas;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar()throws Exception{
        PersonaRegister registro;
        
        try{
            registro = new PersonaRegister();
            registro.register(persona);
        }catch (Exception e){
            throw e;
        }
    }
    
    public void listar()throws Exception{
        PersonaRegister registro;
        
        try{
            registro = new PersonaRegister();
            lstPersonas = registro.listar();
        }catch (Exception e){
            throw e;
        }
    }
    
    public void readID(Persona per) throws Exception{
        PersonaRegister registro;
        Persona temp;
        try{
            registro = new PersonaRegister();
            temp = registro.readID(per);
            
            if (temp != null){
                this.persona = temp;
            }
        }catch (Exception e){
            throw e;
        }
    } 
    
    public void modificar()throws Exception{
        PersonaRegister registro;
        
        try{
            registro = new PersonaRegister();
            registro.modificar(persona);
            this.listar();
        }catch (Exception e){
            throw e;
        }
    }
    
    public void eliminar(Persona per)throws Exception{
        PersonaRegister registro;
        
        try{
            registro = new PersonaRegister();
            registro.eliminar(per);
            this.listar();
        }catch (Exception e){
            throw e;
        }
    }
    
}
