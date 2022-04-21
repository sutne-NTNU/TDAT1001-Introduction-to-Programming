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

/**
 * Multicolor cube with triangles
 * @author Tomas Holt, based on code from Hock-Chuan Chua (May 2012)
 * @version October 2016
 */

/* Main class which extends GLCanvas. This means that this is a OpenGL canvas.
   We will use OpenGL commands to draw on this canvas.
   This implementation has no animation or user input.
*/
public class Oppgave2b extends GLCanvas implements GLEventListener {
	    // constants
	private static String TITLE = "OpenGL: 02 - Task 2b";
	private static final int CANVAS_WIDTH = 640;  // width of the drawable
	private static final int CANVAS_HEIGHT = 480; // height of the drawable

	private GLUT glut = new GLUT();
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
  
   // Setup OpenGL Graphics Renderer 
   private GLU glu;  // for the GL Utility
   
   /** Constructor to setup the GUI for this Component */
   public Oppgave2b() {
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
      gl.glLoadIdentity();  // reset the model-view matrix
     
      
      //----------- "kube" ---------------
        gl.glTranslatef(0.0f, 0.0f, -10.0f); //translater
        gl.glRotated(rotAngle, 1, 1, 1);//rotate around x,y,z axis
        glut.glutWireCube(2);
        gl.glEnd();
   }

   public void dispose(GLAutoDrawable drawable) { }
   
   private class RotateKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e) {   
            rotAngle += 10;//
            Oppgave2b.this.repaint();//repaint our canvas
        }
   }
   
   public static void main(String[] args) {
       GLCanvas canvas = new Oppgave2b();
       canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
       
       final JFrame frame = new JFrame(); 
       frame.getContentPane().add(canvas);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
       frame.setTitle(TITLE);
       frame.pack();
       frame.setVisible(true); 
       
   }
}