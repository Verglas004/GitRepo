package BasicUtility;
import java.util.EventObject;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelEvent extends EventObject {
	private JPanel _newPanel;
	private String _s;

	public PanelEvent(Object sourcePanel, JPanel newPanel, String s) {
		super(sourcePanel);
		_newPanel = newPanel;
		_s = s;
	}

	@Override
	public String toString() {
		return _s;
	}

	public JPanel panel() {
		return _newPanel;
	}
}