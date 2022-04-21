import java.awt.*;
import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.jogamp.opengl.util.gl2.GLUT;

public class Oppgave4 extends GLCanvas implements GLEventListener {
	private static String TITLE = "OpenGL: 02 - Task 4";
	private static final int CANVAS_WIDTH = 640;  // width of the drawable
	private static final int CANVAS_HEIGHT = 480; // height of the drawable

	private GLUT glut = new GLUT();
	private int rotAngle = 180;
        
   private GLU glu;  // for the GL Utility
   
   public Oppgave4() {
      this.addGLEventListener(this);
      this.addKeyListener(new RotateKeyListener()); //listener for keyboard
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
      GL2 gl = drawable.getGL().getGL2();  
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); 
      gl.glLoadIdentity(); 
      glu.gluLookAt(5, 0, 5, 0, 0, 0, 0, 1, 0);
      //----------- kube ---------------
        gl.glTranslatef(0.0f, 0.0f, -10.0f); //translater
        gl.glRotated(rotAngle, 1, 1, 1);
        glut.glutWireCube(2);
        gl.glEnd();
        
        glu.gluLookAt(5, 0, 0, 0, 0, 0, 0, 1, 0);
      //----------- kube ---------------
        gl.glTranslatef(0.0f, 0.0f, -10.0f); //translater
        gl.glRotated(rotAngle, 1, 1, 1);
        glut.glutWireCube(2);
        gl.glEnd();
        
        
        glu.gluLookAt(5, 0, -5, 0, 0, 0, 0, 1, 0);
      //----------- kube ---------------
        gl.glTranslatef(0.0f, 0.0f, -10.0f); //translater
        gl.glRotated(rotAngle, 1, 1, 1);
        glut.glutWireCube(2);
        gl.glEnd();
        
        
        glu.gluLookAt(-5, 0, 5, 0, 0, 0, 0, 1, 0);
      //----------- kube ---------------
        gl.glTranslatef(0.0f, 0.0f, -10.0f); //translater
        gl.glRotated(rotAngle, 1, 1, 1);
        glut.glutWireCube(2);
        gl.glEnd();
       
   }

   public void dispose(GLAutoDrawable drawable) { }
   
   private class RotateKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e) {   
            rotAngle += 1;
            Oppgave4.this.repaint();
        }
   }
   
   public static void main(String[] args) {
       GLCanvas canvas = new Oppgave4();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
       
       final JFrame frame = new JFrame(); 
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true); 
       
   }
}