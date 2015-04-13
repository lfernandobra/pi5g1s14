package edu.gaed.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.gaed.vo.Municipio;

@FacesConverter(forClass = Municipio.class)
public class MunicipioConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Municipio) uiComponent.getAttributes().get(value);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Municipio) {
            Municipio entity= (Municipio) value;
            if (entity != null && entity instanceof Municipio && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
