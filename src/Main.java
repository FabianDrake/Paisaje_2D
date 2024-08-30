import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Fondo
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Sol (círculo con un arco)
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(600, 50, 100, 100); // Sol

        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(5)); // Grosor de la línea
        g2d.drawArc(600, 50, 100, 100, 0, 360); // Contorno del sol

        // Montañas (triángulos)
        g2d.setColor(new Color(34, 139, 34)); // Verde oscuro
        int[] xPoints = {100, 200, 300};
        int[] yPoints = {400, 200, 400};
        g2d.fillPolygon(xPoints, yPoints, 3);

        int[] xPoints2 = {300, 400, 500};
        int[] yPoints2 = {400, 250, 400};
        g2d.fillPolygon(xPoints2, yPoints2, 3);

        // Casa (rectángulo y triángulo)
        g2d.setColor(Color.RED);
        g2d.fillRect(150, 300, 200, 150); // Cuerpo de la casa

        g2d.setColor(Color.DARK_GRAY);
        int[] roofX = {140, 260, 380};
        int[] roofY = {300, 200, 300};
        g2d.fillPolygon(roofX, roofY, 3); // Techo de la casa

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // Grosor de línea de la puerta y ventana
        g2d.drawRect(225, 370, 50, 80); // Puerta
        g2d.drawRect(175, 320, 40, 40); // Ventana izquierda
        g2d.drawRect(285, 320, 40, 40); // Ventana derecha

        // Árbol (rectángulo y óvalo)
        g2d.setColor(new Color(139, 69, 19)); // Marrón
        g2d.fillRect(450, 350, 20, 100); // Tronco del árbol

        g2d.setColor(new Color(34, 139, 34)); // Verde oscuro
        g2d.fillOval(430, 300, 60, 60); // Follaje del árbol

        // Camino (líneas con patrón)
        float[] dashPattern = {10, 10}; // Patrón de línea discontinua
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dashPattern, 0));
        g2d.setColor(Color.GRAY);
        g2d.drawLine(200, 450, 200, 600); // Primera línea del camino
        g2d.drawLine(300, 450, 300, 600); // Segunda línea del camino
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paisaje con Figuras Geométricas");
        Main panel = new Main();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
