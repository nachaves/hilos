package botonmovil;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BotonMovil extends JFrame {

    private JButton button;
    private Thread movementThread;

    public BotonMovil() {
        // Configuración del JFrame
        setTitle("Botón Móvil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null); // Usamos un diseño nulo para poder establecer manualmente la posición del botón

        // Crear el botón
        button = new JButton("Móvil");
        add(button);

        // Establecer el tamaño y la posición inicial del botón
        button.setBounds(0, 0, 100, 30);

        // Iniciar el hilo de movimiento
        movementThread = new Thread(this::moveButton);
        movementThread.start();
    }

    private void moveButton() {
        Random random = new Random();

        while (true) {
            // Cambiar la posición del botón
            int x = random.nextInt(getWidth() - button.getWidth());
            int y = random.nextInt(getHeight() - button.getHeight());

            SwingUtilities.invokeLater(() -> {
                button.setLocation(x, y);
            });

            // Cambiar el color del botón
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            SwingUtilities.invokeLater(() -> {
                button.setBackground(randomColor);
            });

            // Dormir el hilo durante un breve período de tiempo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BotonMovil botonMovil = new BotonMovil();
            botonMovil.setVisible(true);
        });
    }
}




