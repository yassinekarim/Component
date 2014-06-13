package net.ihe.gazelle.tags.renderkit.html;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import net.ihe.gazelle.tags.component.AbstractInsert;

import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.renderkit.RendererBase;

import com.uwyn.jhighlight.renderer.XhtmlRendererFactory;
import com.uwyn.jhighlight.tools.FileUtils;
@ResourceDependencies({ @ResourceDependency( library="stylesheet", name = "highlighter.css",target="head")})
@JsfRenderer(family = AbstractInsert.COMPONENT_FAMILY, type = InsertRenderer.RENDERER_TYPE)
public class InsertRenderer extends RendererBase {
	public static final String RENDERER_TYPE = "net.ihe.gazelle.tags.insert";

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		if (!(component.isRendered() && component instanceof AbstractInsert))
			return;
		AbstractInsert newButton = (AbstractInsert) component;

		
		String highlight =newButton.getHighlight();
		String content =newButton.getContent();
		String src =newButton.getSrc();
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", newButton);
		String hXml="";
		if (content!=null)
		{

			hXml = getHighLightedDocumentString(highlight,content );
			
		}
		else if(src!=null)
		{
			hXml = getHighLightedDocumentStringFromFile(src);
		}
		
		writer.write(hXml);
		
		//System.out.println(hXml);
		
		writer.endElement("div");
	}


	public String getHighLightedDocumentString(String highlight,String text) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			highlightString(highlight,  new ByteArrayInputStream(text.getBytes()), baos,
					"UTF-8", true, false);
		} catch (Exception e) {
			return "Enable to parse the document.";
		}
		return baos.toString();
	}

	public  String getHighLightedDocumentStringFromFile(String fileName) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			highlightFile(fileName, new FileInputStream(fileName), baos, "UTF-8", true, false);
		} catch (Exception e) {
			return "Enable to parse the document.";
		}
		return baos.toString();
	}
	private static void highlightFile(String name,InputStream is, OutputStream os,
			String encoding, boolean fragment, boolean verbose)
					throws IOException {

		XhtmlRendererFactory.getRenderer(FileUtils.getExtension(name))
		.highlight(name, is , os, encoding, fragment);

	}
	private void highlightString(String extension, InputStream is, OutputStream os,
			String encoding, boolean fragment, boolean verbose)
			throws IOException {

		XhtmlRendererFactory.getRenderer(extension)
				.highlight("smtg."+extension, is, os, encoding, fragment);

	}

}
