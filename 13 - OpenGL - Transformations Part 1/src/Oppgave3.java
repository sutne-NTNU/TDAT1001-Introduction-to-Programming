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

public class Oppgave3 extends GLCanvas implements GLEventListener {
	    // constants
	private static String TITLE = "OpenGL: 02 - Task 3";
	private static final int CANVAS_WIDTH = 640;  // width of the drawable
	private static final int CANVAS_HEIGHT = 480; // height of the drawable

	private GLUT glut = new GLUT();
	private int rotAngle;
  
   // Setup OpenGL Graphics Renderer 
   private GLU glu;  // for the GL Utility
   
   /** Constructor to setup the GUI for this Component */
   public Oppgave3() {
      this.addGLEventListener(this);
      this.addKeyListener(new RotateKeyListener()); //listener for keyboard
   }
   
   public void init(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
      glu = new GLU();                         // get GL Utilities
      gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
      gl.glEnable(GL2.GL_DEPTH_TEST);           // enables depth testing
      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
   }

   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

      if (height == 0) height = 1;   // prevent divide by zero     
      float aspect = (float)width / height;

      //Set the view port (display area) to cover the entire window
      gl.glViewport(0, 0, width, height);

      // Setup perspective projection, with aspect ratio matches viewport
      gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
      gl.glLoadIdentity();             // reset projection matrix
      glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

      // Enable the model-view transform
      gl.glMatrixMode(GL2.GL_MODELVIEW);
      gl.glLoadIdentity(); // reset
   }

   public void display(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
      
      //-----------kube 1 ----------------
        gl.glLoadIdentity();  // reset the model-view matrix
        gl.glTranslatef(3.0f, 0.0f, -10.0f); //translater
        gl.glRotatef(15.0f, 15.0f, 50.0f, 0.0f); //roter
        gl.glScalef(1.0f, 0.8f, 1.0f); // skaler
        gl.glRotated(rotAngle, 1, 1, 1);//rotate around x,y,z axis
        
        gl.glColor3f(0f, 1f, 0f);
        glut.glutWireCube(2);
        
        //--------- kube 2 -----------
        gl.glLoadIdentity();  // reset the model-view matrix
        gl.glScalef(1.0f, 0.8f, 1.0f); //scale
        gl.glRotatef(15.0f, 15.0f, 50.0f, 0.0f); //roter
        gl.glTranslatef(3.0f, 0.0f, -10.0f); //translater
        gl.glRotated(rotAngle, 1, 1, 1);//rotate around x,y,z axis
        
        gl.glColor3f(1f, 0f, 0f);
        glut.glutWireCube(2);
   }

   public void dispose(GLAutoDrawable drawable) { }
   
   private class RotateKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e) {   
            rotAngle += 10;//
            Oppgave3.this.repaint();//repaint our canvas
        }
   }
   
   public static void main(String[] args) {
       GLCanvas canvas = new Oppgave3();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
       
       final JFrame frame = new JFrame(); 
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true); 
       
   }
}