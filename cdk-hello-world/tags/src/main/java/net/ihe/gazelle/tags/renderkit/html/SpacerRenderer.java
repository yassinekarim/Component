package net.ihe.gazelle.tags.renderkit.html;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.richfaces.renderkit.HtmlConstants;

import net.ihe.gazelle.tags.component.AbstractSpacer;

import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.renderkit.RendererBase;

@ResourceDependencies({ @ResourceDependency(library = "img", name = "spacer.gif", target = "body") })
@JsfRenderer(family = AbstractSpacer.COMPONENT_FAMILY, type = SpacerRenderer.RENDERER_TYPE)
public class SpacerRenderer extends RendererBase {
	public static final String RENDERER_TYPE = "net.ihe.gazelle.tags.spacer";

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		if (!(component.isRendered() && component instanceof AbstractSpacer))
			return;
		AbstractSpacer spacer = (AbstractSpacer) component;

		String heigth = spacer.getHeight();
		String width = spacer.getWidth();
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement(HtmlConstants.IMG_ELEMENT, spacer);
		writer.writeAttribute(HtmlConstants.WIDTH_ATTRIBUTE, width, null);
		writer.writeAttribute(HtmlConstants.HEIGHT_ATTRIBUTE, heigth, null);
		writer.writeAttribute(HtmlConstants.SRC_ATTRIBUTE,
				getResourceRequestPath(context, "spacer.gif","img"), null);
		writer.writeAttribute(HtmlConstants.ALT_ATTRIBUTE,
				"", null);
		writer.endElement(HtmlConstants.IMG_ELEMENT);

	}

	protected String getResourceRequestPath(FacesContext context,
			String resourceName,String library) {

		javax.faces.application.Resource resource = context.getApplication()
				.getResourceHandler().createResource(resourceName, library);

		return resource.getRequestPath();

	}
}