package net.ihe.gazelle.tags.component;

import javax.faces.component.UIComponentBase;

import net.ihe.gazelle.tags.renderkit.html.InsertRenderer;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(family = AbstractInsert.COMPONENT_FAMILY, type = AbstractInsert.COMPONENT_TYPE, tag = @Tag(name = AbstractInsert.TAG_NAME), renderer = @JsfRenderer(type = InsertRenderer.RENDERER_TYPE))
public abstract class AbstractInsert extends UIComponentBase {
	public static final String COMPONENT_TYPE = "Insert";
	public static final String COMPONENT_FAMILY = "Insert";
	public static final String TAG_NAME = "insert";
	
	public final static String Highlight_GROOVY = "groovy";
	public final static String Highlight_JAVA = "java";
	public final static String Highlight_BEANSHELL = "beanshell";
	public final static String Highlight_BSH = "bsh";
	public final static String Highlight_XML = "xml";
	public final static String Highlight_XHTML = "xhtml";
	public final static String Highlight_LZX = "lzx";
	public final static String Highlight_HTML = "html";
	public final static String Highlight_CPP = "cpp";
	public final static String Highlight_CXX = "cxx";
	public final static String Highlight_CPLUSPLUS = "c++";
	
	
	@Attribute(defaultValue = "xml" ,
		       suggestedValue = Highlight_GROOVY + "," + Highlight_JAVA + "," + Highlight_BEANSHELL+ "," + Highlight_BSH + "," + Highlight_XML+ "," + Highlight_XHTML + "," + Highlight_LZX+ "," + Highlight_HTML + "," + Highlight_CPP + "," + Highlight_CXX + "," + Highlight_CPLUSPLUS)
		    public abstract String getHighlight();
	@Attribute
		    public abstract String getContent();
	@Attribute
    public abstract String getSrc();

}
