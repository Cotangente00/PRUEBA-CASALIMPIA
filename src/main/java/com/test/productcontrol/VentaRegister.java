/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol;

import com.test.productcontrol.model.DetalleVenta;
import com.test.productcontrol.model.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class VentaRegister extends connection{
    public void register (Venta venta, List<DetalleVenta> lista) throws Exception{
        try{
            this.connect();
            this.getCn().setAutoCommit(false);
            try (PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Venta (fecha, idPersona, nombresPersona, apellidosPersona, numDocumentoPersona, numCelularPersona, monto) values (?,?,?,?,?,?,?)")) {
                st.setDate(1, venta.getFecha());
                st.setInt(2, venta.getPersona().getId());
                st.setString(3, venta.getPersona().getNombres());
                st.setString(4, venta.getPersona().getApellidos());
                st.setLong(5, venta.getPersona().getNumDocumento());
                st.setLong(6, venta.getPersona().getNumCelular());
                st.setDouble(7, venta.getMonto());
                st.executeUpdate();
            }
            
            
            PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() FROM Venta limit 1");
            ResultSet rs;
            int idVenta = 0;
            rs = st2.executeQuery();
            while(rs.next()){
                idVenta = rs.getInt(1);
            }
            rs.close();
            
            
            for (DetalleVenta det: lista){
                try (PreparedStatement st3 = this.getCn().prepareStatement("INSERT INTO DetalleVenta (idVenta, idProducto, nombreProducto, cantidad, precioProducto) values (?,?,?,?,?)")) {
                    st3.setInt(1, idVenta);
                    st3.setInt(2, det.getIdProducto().getId());
                    st3.setString(3, det.getIdProducto().getNombre());
                    st3.setInt(4, det.getCantidad());
                    st3.setDouble(5, det.getIdProducto().getPrecio());
                    st3.executeUpdate();
                }
            }
            this.getCn().commit();
        }catch (Exception e){
            this.getCn().rollback();
            throw e;
        }finally{
            this.close();
        }
    }
    
    public List<Venta> listar()throws Exception {
        List<Venta> lista;
        ResultSet rs;
        try{
            this.connect();
            PreparedStatement st = this.getCn().prepareCall("SELECT id, fecha, numDocumentoPersona, nombresPersona, apellidosPersona, numCelularPersona, monto FROM Venta");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setNumDocumentoPersona(rs.getLong("numDocumentoPersona"));
                venta.setNombresPersona(rs.getString("nombresPersona"));
                venta.setApellidosPersona(rs.getString("ApellidosPersona"));
                venta.setNumCelularPersona(rs.getLong("numCelularPersona"));
                venta.setMonto(rs.getDouble("monto"));
                lista.add(venta);
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.close();
        }
        return lista;
    }
    
}
