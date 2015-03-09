import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class CirclePanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics g) {
        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}
