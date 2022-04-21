import java.awt.*;
import javax.swing.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.jogamp.opengl.util.FPSAnimator;

public class Kube extends GLCanvas implements GLEventListener {
    private static String TITLE = "OpenGL: 03 - Rotating Cube";
    private static final int CANVAS_WIDTH = 840;
    private static final int CANVAS_HEIGHT = 680;

    private int rotAngle;
    private GLU glu;

    static final double hjornePunkter[][] = {
            // bakre firkant
            { -1.0f, 1.0f, -1, 0f }, // topp venstre 0
            { 1.0f, 1.0f, -1.0f }, // topp høyre 1
            { -1.0f, -1.0f, -1.0f }, // bunn venstre 2
            { 1.0f, -1.0f, -1.0f }, // bunn høyre 3
            // fremre fikrant
            { -1.0f, 1.0f, 1, 0f }, // topp venstre 4
            { 1.0f, 1.0f, 1.0f }, // topp høyre 5
            { -1.0f, -1.0f, 1.0f }, // bunn venstre 6
            { 1.0f, -1.0f, 1.0f }, // bunn høyre 7
    };

    static final double colors[][] = { { 1.0f, 0.0f, 0.0f }, // rød
            { 0.0f, 0.7f, 0.0f }, // grønn
            { 0.0f, 0.0f, 1.0f }, // blå
            { 1.0f, 1.0f, 0.0f }, // gul
            { 1.0f, 1.0f, 1.0f }, // hvit
            { 1.0f, 0.5f, 0.0f }, // orange
    };

    public void drawSide(GL2 gl, int a, int b, int c, int d, int farge) {
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3dv(colors[farge], 0); // Farge
        gl.glVertex3dv(hjornePunkter[a], 0);
        gl.glVertex3dv(hjornePunkter[b], 0);
        gl.glVertex3dv(hjornePunkter[c], 0);
        gl.glVertex3dv(hjornePunkter[d], 0);
        gl.glEnd();
    }

    public void drawKube(GL2 gl) {
        drawSide(gl, 2, 3, 7, 6, 4);// bunn
        drawSide(gl, 0, 1, 3, 2, 0);// bak
        drawSide(gl, 1, 3, 7, 5, 2);// høyre
        drawSide(gl, 4, 5, 7, 6, 5);// front
        drawSide(gl, 0, 2, 6, 4, 1);// venstre
        drawSide(gl, 0, 1, 5, 4, 3);// topp
    }

    private void drawAllAxis(GL2 gl) {
        gl.glColor3d(1, 0, 0);

        double[] tabell = { 3, 0, 0 };
        drawAxis(gl, tabell);

        gl.glColor3d(0, 1, 0);
        // y-akse

        double[] tabell2 = { 0, 3, 0 };
        drawAxis(gl, tabell2);

        gl.glColor3d(0, 0, 1);
        // z-akse

        double[] tabell3 = { 0, 0, 3 };
        drawAxis(gl, tabell3);
    }

    private void drawAxis(GL2 gl, double[] tabell) {
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3d(0, 0, 0);
        gl.glVertex3dv(tabell, 0);
        gl.glEnd();
    }

    public Kube() {
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

        if (height == 0) {
            height = 1;
        }
        float aspect = (float) width / height;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        if (spin) {
            rotAngle += 1;
        }

        gl.glTranslatef(0.0f, 0.0f, -10.0f);
        // drawAllAxis(gl);

        double fac = 2;
        gl.glViewport(0, 0, (int) (CANVAS_WIDTH / fac), CANVAS_HEIGHT / 2);
        gl.glRotated(rotAngle, 5, 1, 1);// rotate around x,y,z axis
        drawKube(gl);

        gl.glViewport((int) (CANVAS_HEIGHT / fac), 0, (int) (CANVAS_WIDTH / fac), (int) (CANVAS_HEIGHT / fac));
        gl.glRotated(rotAngle, 4, 2, 1);// rotate around x,y,z axis
        drawKube(gl);

        gl.glViewport(0, (int) (CANVAS_WIDTH / fac), (int) (CANVAS_WIDTH / fac), (int) (CANVAS_HEIGHT / fac));
        gl.glRotated(rotAngle, 3, 3, 1);// rotate around x,y,z axis
        drawKube(gl);

        gl.glViewport(CANVAS_HEIGHT / 2, CANVAS_WIDTH / 2, CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        gl.glRotated(rotAngle, 2, 4, 1);// rotate around x,y,z axis
        drawKube(gl);

    }

    public void dispose(GLAutoDrawable drawable) {
    }

    private boolean spin = false;

    private class RotateKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 's') {
                spin = !spin;
            }
            Kube.this.repaint();// repaint our canvas
        }
    }

    /**
     * The entry main() method to setup the top-level JFrame with our OpenGL canvas
     * inside
     */
    public static void main(String[] args) {
        GLCanvas canvas = new Kube();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
        frame.getContentPane().add(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// stop program
        frame.setTitle(TITLE);
        frame.pack();
        frame.setVisible(true);

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
}