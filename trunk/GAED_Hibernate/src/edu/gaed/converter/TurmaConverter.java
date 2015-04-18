package edu.gaed.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.gaed.vo.Turma;

@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Turma) uiComponent.getAttributes().get(value);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Turma) {
            Turma entity= (Turma) value;
            if (entity != null && entity instanceof Turma && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
