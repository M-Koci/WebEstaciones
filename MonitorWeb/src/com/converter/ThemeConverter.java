package com.converter;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


import com.managedBeans.LocalidadMB;
import com.model.Localidad;

@FacesConverter("themeConverter")
public class ThemeConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (context == null) {
			throw new NullPointerException("context");
		}
		if (component == null) {
			throw new NullPointerException("component");
		}
		FacesContext ctx = FacesContext.getCurrentInstance();
		ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{localidadMB}", LocalidadMB.class);
		LocalidadMB bean = (LocalidadMB) vex.getValue(ctx.getELContext());
		Localidad localidad_;
		try {
			localidad_ = bean.getLocalidadId(new Integer(value));
		} catch (NumberFormatException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Error en Codigo");
			throw new ConverterException(message);
		}
		if (localidad_ == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Error en Objeto");
			throw new ConverterException(message);
		}
		return localidad_;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (context == null) {
			throw new NullPointerException("context");
		}
		if (component == null) {
			throw new NullPointerException("component");
		}
		return String.valueOf(((Localidad) value).getIdLocalidad());
	}

}