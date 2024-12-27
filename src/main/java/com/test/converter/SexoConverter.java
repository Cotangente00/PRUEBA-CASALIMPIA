/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jcavilaa
 */
@FacesConverter("sexoConverter")
public class SexoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String sexo = "";
        
        if (value != null){
            sexo = (String) value;
            switch (sexo) {
                case "M":
                    sexo = "Masculino";
                    break;
                case "F":
                    sexo = "Femenino";
                    break;
            }
        }
        return sexo;
    }
    
}
