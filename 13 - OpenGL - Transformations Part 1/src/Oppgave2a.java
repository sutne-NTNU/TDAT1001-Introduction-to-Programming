import java.awt.*;
import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Oppgave2a extends GLCanvas implements GLEventListener {
    private static String TITLE = "OpenGL: 02 - Task 2a";
    private static final int CANVAS_WIDTH = 640; 
    private static final int CANVAS_HEIGHT = 480; 
    private GLU glu;  
    private int rotAngle;

    static final double hjornePunkter[][] = {
            {-1.0f, -1.0f, -1.0f},
            { 1.0f, -1.0f, -1.0f},
            { 1.0f,  1.0f, -1.0f},
            {-1.0f,  1.0f, -1,0f},

            {-1.0f,  1.0f, 1,0f},
            { 1.0f,  1.0f, 1.0f},
            { 1.0f, -1.0f, 1.0f},
            {-1.0f, -1.0f, 1.0f},
     };

    static final double colors[][] = {
            {0.645f,  0.771f,  0.014f},
            {0.674f,  0.115f,  0.436f},
            {0.234f,  0.483f,  0.844f},
            {0.356f,  0.569f,  0.201f},
            {0.786f,  0.569f,  0.201f},
            {0.455f,  0.602f,  0.223f},
            {0.646f,  0.747f,  0.185f},
            {0.234f,  0.770f,  0.761f},
    };
  
   
   public Oppgave2a() {
      this.addGLEventListener(this);
      this.addKeyListener(new RotateKeyListener()); 
   }
   
   public void init(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();     
      glu = new GLU();                     
      gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
      gl.glEnable(GL2.GL_DEPTH_TEST);          
      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); 
   }

   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      GL2 gl = drawable.getGL().getGL2();  

      if (height == 0) height = 1;    
      float aspect = (float)width / height;

      gl.glViewport(0, 0, width, height);
      gl.glMatrixMode(GL2.GL_PROJECTION);  
      gl.glLoadIdentity();             
      glu.gluPerspective(45.0, aspect, 0.1, 100.0);
      gl.glMatrixMode(GL2.GL_MODELVIEW);
      gl.glLoadIdentity(); // reset
   }

   public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); 
      
     
      
        //----------- "kube" ---------------
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -10.0f); 
        gl.glRotated(rotAngle, 1, 1, 1);
        
        gl.glBegin(GL2.GL_LINE_LOOP); 
        for(int i = 0; i < hjornePunkter.length; i++){
           gl.glVertex3dv(hjornePunkter[i],0);
           gl.glColor3dv(colors[i], 0); 
        }
        gl.glEnd();
   }

   public void dispose(GLAutoDrawable drawable) { }
   
   private class RotateKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e) {   
            rotAngle += 10;
            Oppgave2a.this.repaint();
        }
   }
   
   public static void main(String[] args) {
       GLCanvas canvas = new Oppgave2a();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
       
       final JFrame frame = new JFrame(); 
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true); 
       
   }
}