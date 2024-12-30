/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.bean;

import com.test.productcontrol.ProductoRegister;
import com.test.productcontrol.model.Producto;
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
public class ProductoBean {
    private Producto producto = new Producto();
    private List<Producto> lstProductos;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        this.producto.setId(0);
        this.producto.setNombre("");
        this.producto.setPrecio(0);
    }
    
    private void registrar()throws Exception{
        ProductoRegister registro;
        
        try{
            
            if (producto.getNombre() == null || producto.getPrecio() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar todos los datos necesarios."));
                return;
            }
            
            registro = new ProductoRegister();
            registro.register(producto);
            this.listar("V");
        }catch (Exception e){
            throw e;
        }
    }
    
    private void modificar()throws Exception{
        ProductoRegister registro;
        
        try{
            registro = new ProductoRegister();
            registro.modificar(producto);
            this.listar("V");
        }catch (Exception e){
            throw e;
        }
    }
    
    public void listar(String valor)throws Exception{
        ProductoRegister registro;
        
        try{
            if(valor.contains("F")){
                if(isPostBack() == false){
                    registro = new ProductoRegister();
                    lstProductos = registro.listar();
                }   
            } else {
                registro = new ProductoRegister();
                lstProductos = registro.listar();
            }
            
        }catch (Exception e){
            throw e;
        }
    }
    
    public void readID(Producto per) throws Exception{
        ProductoRegister registro;
        Producto temp;
        try{
            registro = new ProductoRegister();
            temp = registro.readID(per);
            
            if (temp != null){
                this.producto = temp;
                this.accion = "Modificar";
            }
        }catch (Exception e){
            throw e;
        }
    }
    
    public void eliminar(Producto per)throws Exception{
        ProductoRegister registro;
        
        try{
            registro = new ProductoRegister();
            registro.eliminar(per);
            this.listar("V");
        }catch (Exception e){
            throw e;
        }
    }
    
}
