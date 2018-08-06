package com.leaf.spring.mvc.expose.web.advice;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class ExtendPropertiesEditor extends PropertiesEditor {

    @Override
    public void setSource(Object source) {
        super.setSource(source);
    }
}
