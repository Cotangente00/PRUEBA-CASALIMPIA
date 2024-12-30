/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol;

import com.test.productcontrol.model.DetalleVenta;
import com.test.productcontrol.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DetalleVentaRegister extends connection {
    public List<DetalleVenta> listarPorVenta(int idVenta) throws Exception {
        List<DetalleVenta> lista;
        ResultSet rs;
        try {
            this.connect();
            PreparedStatement st = this.getCn().prepareStatement(
                "SELECT id, idProducto, nombreProducto, cantidad, precioProducto, montoProducto, fechaHora, fullName, numDoc " +
                "FROM DetalleVenta WHERE idVenta = ?"
            );
            st.setInt(1, idVenta);
            rs = st.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setId(rs.getInt("id"));
                detalle.setIdProducto(new Producto());
                detalle.getIdProducto().setId(rs.getInt("idProducto")); 
                detalle.setNombreProducto(rs.getString("nombreProducto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioProducto(rs.getDouble("precioProducto"));
                detalle.setMontoProducto(rs.getDouble("montoProducto"));
                detalle.setFechaHora(rs.getTimestamp("fechaHora"));
                detalle.setFullName(rs.getString("fullName"));
                detalle.setNumDoc(rs.getLong("numDoc"));
                lista.add(detalle);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return lista;
    }
}