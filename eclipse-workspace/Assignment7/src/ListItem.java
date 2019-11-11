import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class ListItem implements Comparable<ListItem> {
	private int valA;
	private int valB;

	public ListItem(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}

	public int getValA() {
		return valA;
	}
	public int getValB() {
		return valB;
	}
	
	public Icon createIcon(int diameter) {
		return new ItemIcon(this, diameter);
	}

	@Override
	public int compareTo(ListItem o) {
		return o.valA  - this.valA;
	}

}