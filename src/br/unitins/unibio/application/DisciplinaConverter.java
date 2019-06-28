package br.unitins.unibio.application;

import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.unitins.unibio.model.Disciplina;


@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter{

	 @Override
     public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
         if (value != null && !value.isEmpty()) {
             return (Disciplina) uiComponent.getAttributes().get(value);
         }
         return null;
     }

     @Override
     public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
         if (value instanceof Disciplina) {
             Disciplina entity = (Disciplina) value;
             if (entity instanceof Disciplina && entity.getId() != null) {
                 uiComponent.getAttributes().put(entity.getId().toString(), entity);
                 return entity.getId().toString();
             }
         }
         return "";
     }
 }
