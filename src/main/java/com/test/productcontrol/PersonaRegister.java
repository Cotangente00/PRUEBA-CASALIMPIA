/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol;

import com.test.productcontrol.model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PersonaRegister extends connection{
    public void register (Persona per) throws Exception{
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("INSERT INTO Persona (numDocumento, nombres, apellidos, sexo, numCelular) values (?,?,?,?,?)");
            st.setLong(1, per.getNumDocumento());
            st.setString(2, per.getNombres());
            st.setString(3, per.getApellidos());
            st.setString(4, per.getSexo());
            st.setLong(5, per.getNumCelular());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
    }
    
    public List<Persona> listar()throws Exception {
        List<Persona> lista;
        ResultSet rs;
        try{
            this.connect();
            PreparedStatement st = this.getCn().prepareCall("SELECT id, numDocumento, nombres, apellidos, sexo, numCelular FROM Persona");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setNumDocumento(rs.getLong("numDocumento"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setSexo(rs.getString("sexo"));
                per.setNumCelular(rs.getLong("numCelular"));
                lista.add(per);
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.close();
        }
        return lista;
    }
    
    public Persona readID(Persona per)throws Exception{
        Persona pers = null;
        ResultSet rs;
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("SELECT id, numDocumento, nombres, apellidos, sexo, numCelular FROM Persona WHERE id = ?");
            st.setInt(1, per.getId());
            rs = st.executeQuery();
            while (rs.next()){
                pers = new Persona();
                pers.setId(rs.getInt("id"));
                pers.setNumDocumento(rs.getLong("numDocumento"));
                pers.setNombres(rs.getString("nombres"));
                pers.setApellidos(rs.getString("apellidos"));
                pers.setSexo(rs.getString("sexo"));
                pers.setNumCelular(rs.getLong("numCelular"));
            }
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
        return pers;
    }
    
    public void modificar (Persona per) throws Exception{
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("UPDATE Persona SET numDocumento = ?, nombres = ?, apellidos = ?, sexo = ?, numCelular = ? WHERE id = ?");
            st.setLong(1, per.getNumDocumento());
            st.setString(2, per.getNombres());
            st.setString(3, per.getApellidos());
            st.setString(4, per.getSexo());
            st.setLong(5, per.getNumCelular());
            st.setInt(6, per.getId());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
    }
    
    public void eliminar (Persona per) throws Exception{
        try{
            this.connect();
            PreparedStatement st =  this.getCn().prepareStatement("DELETE FROM Persona WHERE id = ?");
            st.setInt(1, per.getId());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.close();
        }
    }
    
}
