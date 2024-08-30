import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    // Método para dibujar una línea usando el algoritmo DDA
    private void drawLineDDA(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
            x += xIncrement;
            y += yIncrement;
        }
    }

    // Método para dibujar una línea usando el algoritmo de Bresenham
    private void drawLineBresenham(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawLine(x1, y1, x1, y1);
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja un paisaje simple usando DDA y Bresenham

        // Cielo
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Sol
        g.setColor(Color.YELLOW);
        drawLineDDA(g, 150, 50, 120, 90); // Primera línea del sol
        drawLineDDA(g, 150, 50, 180, 90); // Segunda línea del sol
        g.fillOval(130, 30, 40, 40); // Círculo del sol

        // Montañas
        g.setColor(Color.DARK_GRAY);
        drawLineBresenham(g, 50, 300, 150, 150);
        drawLineBresenham(g, 150, 150, 250, 300);
        drawLineBresenham(g, 200, 300, 300, 200);
        drawLineBresenham(g, 300, 200, 400, 300);

        // Casa
        g.setColor(Color.RED);
        drawLineDDA(g, 200, 250, 300, 250); // Techo
        drawLineDDA(g, 200, 250, 250, 200); // Techo
        drawLineDDA(g, 300, 250, 250, 200); // Techo
        g.setColor(Color.BLUE);
        drawLineBresenham(g, 220, 300, 220, 250); // Pared izquierda
        drawLineBresenham(g, 220, 250, 280, 250); // Parte superior de la pared
        drawLineBresenham(g, 280, 250, 280, 300); // Pared derecha
        drawLineBresenham(g, 220, 300, 280, 300); // Parte inferior de la pared

        // Puerta
        g.setColor(Color.DARK_GRAY);
        drawLineBresenham(g, 245, 300, 245, 270);
        drawLineBresenham(g, 255, 300, 255, 270);
        drawLineBresenham(g, 245, 270, 255, 270);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paisaje con Trazados de Líneas");
        Main panel = new Main();
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
