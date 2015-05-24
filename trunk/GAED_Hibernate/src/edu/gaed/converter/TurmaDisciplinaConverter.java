package edu.gaed.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.gaed.vo.TurmaDisciplina;

@FacesConverter(value = "turmaDisciplinaConverter")
public class TurmaDisciplinaConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (TurmaDisciplina) uiComponent.getAttributes().get(value);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof TurmaDisciplina) {
        	TurmaDisciplina entity= (TurmaDisciplina) value;
            if (entity != null && entity instanceof TurmaDisciplina && entity.hashCode() != 0) {
                uiComponent.getAttributes().put( Integer.valueOf(entity.hashCode()).toString(), entity);
                return Integer.valueOf(entity.hashCode()).toString();
            }
        }
        return "";
    }
}
