/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.bean;

import com.test.productcontrol.PersonaRegister;
import com.test.productcontrol.model.Persona;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
        this.limpiar();
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
    
    private boolean isPostBack (){
        boolean reply;
        reply = FacesContext.getCurrentInstance().isPostback();
        return reply;
    }
    
    public void operar () throws Exception{
        switch(accion){
            case "Registrar":
                this.registrar();
                this.limpiar();
                break;
            case "Modificar":
                this.modificar();
                this.limpiar();
                break;
        }
    }
    
    public void limpiar(){
        this.persona.setId(0);
        this.persona.setNombres("");
        this.persona.setApellidos("");
        this.persona.setSexo("");
        this.persona.setNumCelular(0);
    }
    
    private void registrar()throws Exception{
        PersonaRegister registro;
        
        try{
            if (persona.getNombres() == null || persona.getApellidos() == null || persona.getSexo() == null || persona.getNumCelular() <= 0 || persona.getNumDocumento() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar todos los datos necesarios."));
                return;
            }
            
            registro = new PersonaRegister();
            registro.register(persona);
            this.listar("V");
        }catch (Exception e){
            throw e;
        }
    }
    
    private void modificar()throws Exception{
        PersonaRegister registro;
        
        try{
            registro = new PersonaRegister();
            registro.modificar(persona);
            this.listar("V");
        }catch (Exception e){
            throw e;
        }
    }
    
    public void listar(String valor)throws Exception{
        PersonaRegister registro;
        
        try{
            if(valor.contains("F")){
                if(isPostBack() == false){
                    registro = new PersonaRegister();
                    lstPersonas = registro.listar();
                }   
            } else {
                registro = new PersonaRegister();
                lstPersonas = registro.listar();
            }
            
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
                this.accion = "Modificar";
            }
        }catch (Exception e){
            throw e;
        }
    }
    
    public void eliminar(Persona per)throws Exception{
        PersonaRegister registro;
        
        try{
            registro = new PersonaRegister();
            registro.eliminar(per);
            this.listar("V");
        }catch (Exception e){
            throw e;
        }
    }
    
}
