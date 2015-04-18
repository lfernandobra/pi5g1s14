package edu.gaed.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.gaed.vo.Gestor;

@FacesConverter(forClass = Gestor.class)
public class GestorConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Gestor) uiComponent.getAttributes().get(value);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Gestor) {
            Gestor entity= (Gestor) value;
            if (entity != null && entity instanceof Gestor && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
