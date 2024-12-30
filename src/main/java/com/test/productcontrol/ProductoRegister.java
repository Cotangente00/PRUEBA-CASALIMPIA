/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol;

import com.test.productcontrol.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProductoRegister extends connection{
    public void register (Producto pro) throws Exception{
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("INSERT INTO Producto (nombre, precio, estado) values (?,?,1)");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
    }
    
    public List<Producto> listar()throws Exception {
        List<Producto> lista;
        ResultSet rs;
        try{
            this.connect();
            PreparedStatement st = this.getCn().prepareCall("SELECT id, nombre, precio FROM Producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                lista.add(pro);
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.close();
        }
        return lista;
    }
    
    public Producto readID(Producto pro)throws Exception{
        Producto pros = null;
        ResultSet rs;
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("SELECT id, nombre, precio FROM Producto WHERE id = ?");
            st.setInt(1, pro.getId());
            rs = st.executeQuery();
            while (rs.next()){
                pros = new Producto();
                pros.setId(rs.getInt("id"));
                pros.setNombre(rs.getString("nombre"));
                pros.setPrecio(rs.getDouble("precio"));
            }
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
        return pros;
    }
    
    public void modificar (Producto pro) throws Exception{
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("UPDATE Producto SET nombre = ?, precio = ? WHERE id = ?");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.setInt(3, pro.getId());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
    }
    
    public void eliminar (Producto pro) throws Exception{
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("DELETE FROM Producto WHERE id = ?");
            st.setInt(1, pro.getId());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
    }
    
    
    //listar productos únicamente cuando el estado es igual a 1
    public List<Producto> listarActivos() throws Exception {
        List<Producto> lista;
        ResultSet rs;
        try {
            this.connect();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM Producto WHERE estado = 1");
            rs = st.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setEstado(rs.getInt("estado"));
                lista.add(prod);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return lista;
    }
    
    //listar productos únicamente cuando el estado es igual a 2
    public List<Producto> listarInactivos() throws Exception {
        List<Producto> lista;
        ResultSet rs;
        try {
            this.connect();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM Producto WHERE estado = 2");
            rs = st.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setEstado(rs.getInt("estado"));
                lista.add(prod);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return lista;
    }
    
    //consulta para desactivar productos cambiando su estado a 2
    public void desactivar(Producto pro) throws Exception {
        try {
            this.connect();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Producto SET estado = 2 WHERE id = ?");
            st.setInt(1, pro.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    
}
