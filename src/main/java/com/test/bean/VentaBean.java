/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.bean;

import com.test.productcontrol.DetalleVentaRegister;
import com.test.productcontrol.VentaRegister;
import com.test.productcontrol.model.DetalleVenta;
import com.test.productcontrol.model.Producto;
import com.test.productcontrol.model.Venta;
import java.util.ArrayList;
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
public class VentaBean {
    private Venta venta = new Venta();
    private Producto producto = new Producto();
    private int cantidad;
    private List<DetalleVenta> lista = new ArrayList();
    private List<Venta> lstVentas;
    private Venta ventaSeleccionada;
    private List<DetalleVenta> lstDetalles;
    
    public Venta getVentaSeleccionada() {
        return ventaSeleccionada;
    }

    public void setVentaSeleccionada(Venta ventaSeleccionada) {
        this.ventaSeleccionada = ventaSeleccionada;
    }

    public List<DetalleVenta> getLstDetalles() {
        return lstDetalles;
    }

    public void setLstDetalles(List<DetalleVenta> lstDetalles) {
        this.lstDetalles = lstDetalles;
    }
    
    

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }

    public List<Venta> getLstVentas() {
        return lstVentas;
    }

    public void setLstVentas(List<Venta> lstVentas) {
        this.lstVentas = lstVentas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    private boolean isPostBack (){
        boolean reply;
        reply = FacesContext.getCurrentInstance().isPostback();
        return reply;
    }
    
    public void agregar(){
        
        if (venta.getPersona() == null || producto == null || cantidad <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe seleccionar una persona, un producto y una cantidad válida."));
            return;
        }
        DetalleVenta det = new DetalleVenta();
        det.setCantidad(cantidad);
        det.setIdProducto(producto);
        this.lista.add(det);
        
        cantidad = 0;
        producto = null;
    }
    
    public void registrar() throws Exception{
        VentaRegister registro;
        double monto = 0;
        try{
            
            if (venta.getPersona() == null || lista.isEmpty() ){
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe ingresar todos los datos necesarios."));
                return;
            }
            
            for(DetalleVenta det: lista){
                monto += det.getIdProducto().getPrecio() * det.getCantidad();
            }
            
            registro = new VentaRegister();
            venta.setMonto(monto);
            registro.register(venta, lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exito. Venta registrada correctamente."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error! La venta no ha sido registrada."));
            throw e;
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    public void listar(String valor)throws Exception{
        VentaRegister registro;
        
        try{
            if(valor.contains("F")){
                if(isPostBack() == false){
                    registro = new VentaRegister();
                    lstVentas = registro.listar();
                }   
            } else {
                registro = new VentaRegister();
                lstVentas = registro.listar();
            }
            
        }catch (Exception e){
            throw e;
        }
    }
    
    public void eliminar(DetalleVenta detalle) {
        try {
            lista.remove(detalle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto eliminado correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al eliminar el producto."));
        }
    }
    
    // Método para cargar detalles de una venta en específico
    public void cargarDetalles(Venta venta) {
        DetalleVentaRegister detalleRegister = new DetalleVentaRegister();
        try {
            this.ventaSeleccionada = venta;
            this.lstDetalles = detalleRegister.listarPorVenta(venta.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}