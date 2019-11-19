import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class PropertySubject {
	private String data; 
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	//add property change listener to property change support object
	public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
	
	public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }
	//Getter and Setter
	public String getData(String data) {
		return this.data;
	}
	public void setData(String newValue) {
		String oldValue = this.data;
		this.data = newValue;
		pcs.firePropertyChange("data", oldValue, newValue);
	}
}