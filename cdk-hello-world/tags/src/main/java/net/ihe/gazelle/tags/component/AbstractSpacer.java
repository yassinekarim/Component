package net.ihe.gazelle.tags.component;

import javax.faces.component.UIComponentBase;

import net.ihe.gazelle.tags.renderkit.html.SpacerRenderer;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(family = AbstractSpacer.COMPONENT_FAMILY, type = AbstractSpacer.COMPONENT_TYPE, tag = @Tag(name = AbstractSpacer.TAG_NAME), renderer = @JsfRenderer(type = SpacerRenderer.RENDERER_TYPE))
public abstract class AbstractSpacer extends UIComponentBase {
	public static final String COMPONENT_TYPE = "GazelleSpacer";
	public static final String COMPONENT_FAMILY = "GazelleSpacer";
	public static final String TAG_NAME = "spacer";

	
	
	@Attribute(defaultValue="1")
		    public abstract String getWidth();
	@Attribute(defaultValue="1")
    public abstract String getHeight();

}
