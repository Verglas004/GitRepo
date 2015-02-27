import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.pdf.parser.LineSegment;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.Matrix;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunk;


public class TestStrategy extends LocationTextExtractionStrategy
{
    @Override
    public void renderText(TextRenderInfo renderInfo) 
    { 
	LineSegment segment = renderInfo.getBaseline();
    	Rectangle2D.Float rect = segment.getBoundingRectange();
    	super.renderText(renderInfo);
    	//System.out.print(rect.getX() + " " + rect.getY() + " ");
    } 
}
