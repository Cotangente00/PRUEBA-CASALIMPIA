/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.bean;

import com.test.productcontrol.PersonaRegister;
import com.test.productcontrol.model.Persona;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author user
 */

@ManagedBean
@RequestScoped
public class PersonaBean {
    private Persona persona = new Persona();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar(){
        PersonaRegister register;
        
        try{
            
        }catch (Exception e){
            throw e;
        }
    }
}
