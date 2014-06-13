/*
 * JBoss, Home of Professional Open Source
 * Copyright , Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package component;

import javax.annotation.Generated;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.StateHelper;
import net.ihe.gazelle.tags.component.AbstractSpacer;

/**
 * 
 **/
@Generated({"RichFaces CDK", "4.3.0.Final"})
public class UIGazelleSpacer extends AbstractSpacer
        {

    public static final String COMPONENT_TYPE="GazelleSpacer";

    public static final String COMPONENT_FAMILY="GazelleSpacer";

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    public UIGazelleSpacer() {
        super();
        setRendererType("net.ihe.gazelle.tags.spacer");
    }




    protected enum Properties {
        height,
        width
        
    }

 
    public String getHeight() {
        String value = (String) getStateHelper().eval(Properties.height, "1");
        return value;
    }
    
    public void setHeight(String height) {
        getStateHelper().put(Properties.height, height);
    }

 
    public String getWidth() {
        String value = (String) getStateHelper().eval(Properties.width, "1");
        return value;
    }
    
    public void setWidth(String width) {
        getStateHelper().put(Properties.width, width);
    }

    

}