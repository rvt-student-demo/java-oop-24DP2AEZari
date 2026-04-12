package maja;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class GrafikasPanelis extends JPanel {
    public GrafikasPanelis() {

    }
    public GrafikasPanelis(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }
    public GrafikasPanelis(LayoutManager layout, boolean isDoubleBuffered) {
    }

    public void paintComponent(Graphics window) {
        super.paintComponent(window);
        window.setColor(Color.PINK);
        window.fillRect(200, 150, 350, 300);
        window.setColor(Color.BLUE);
        window.fillRect(300, 315, 75, 135);
        window.setColor(Color.BLACK);
        window.drawLine(550, 150, 200, 125);
    }
}