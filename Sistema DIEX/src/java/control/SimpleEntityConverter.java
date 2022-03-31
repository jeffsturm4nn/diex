package control;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * 
 * @author Alexandre Jorge
 *
 */

@ManagedBean
public class SimpleEntityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if(value != null){
			return this.getAttributesFrom(component).get(value);
		}
		
		return null;
	}
	
	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if(value != null && !"".equals(value)){
			BaseEntity entity = (BaseEntity) value;
			
			//adiciona item como atributo do componente
			this.addAtributte(component, entity);
			
			Integer codigo = entity.getId();
			if(codigo != null){
				return String.valueOf(codigo);
			}
		}
		
		return (String) value;
	}

	protected void addAtributte(UIComponent component, BaseEntity entity) {
		String key = entity.getId().toString(); //recuperando o codigo
		this.getAttributesFrom(component).put(key, entity);
	}

	private Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

	

}
