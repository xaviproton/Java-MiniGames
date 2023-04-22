package com.juegos.myball.myball;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author XAVIM
 */
public class MyBall extends JPanel implements ActionListener{
     private static final long serialVersionUID = 1L;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    
     public MyBall() {
        // Crea un temporizador que llama al método actionPerformed cada 10 milisegundos
        Timer timer = new Timer(10, this);
        timer.start();
    }
     
     
     
     // Este método se llama cada vez que se necesita volver a dibujar el panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel
        g.setColor(Color.RED); // Establece el color de dibujo a rojo
        g.fillOval(x, y, 30, 30); // Dibuja un óvalo relleno en las coordenadas (x,y) con ancho y alto de 30 píxeles
    }
    
    // Este método se llama cada vez que el temporizador alcanza su intervalo de tiempo
    public void actionPerformed(ActionEvent e) {
        // Si el óvalo llega al borde izquierdo o derecho del panel, cambia la dirección horizontal (dx)
        if (x < 0 || x > getWidth() - 30) {
            dx = -dx;
        }
        // Si el óvalo llega al borde superior o inferior del panel, cambia la dirección vertical (dy)
        if (y < 0 || y > getHeight() - 30) {
            dy = -dy;
        }
        // Actualiza las coordenadas del óvalo con las direcciones horizontal y vertical actuales
        x += dx;
        y += dy;
        // Vuelve a dibujar el panel
        repaint();
    }
    
    

    public static void main(String[] args) {
        // Crea una nueva ventana
        JFrame ventana = new JFrame("MyBall");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la acción de cierre de la ventana
        ventana.setSize(300, 300); // Configura el tamaño de la ventana
        // Crea un nuevo panel de juego
        MyBall myball = new MyBall();
        // Agrega el panel de juego a la ventana
        ventana.add(myball);
        // Hace visible la ventana
        ventana.setVisible(true);
    }
    
   
}
