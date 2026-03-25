package maja;
import javax.swing.JFrame;

public class JavaGrafika {
    public static void main(String[] args) {
        JFrame frame = new JFrame("mana maja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 768);
        GrafikasPanelis grafika = new GrafikasPanelis();
        frame.add(grafika);
        frame.setVisible(true);

    }
}