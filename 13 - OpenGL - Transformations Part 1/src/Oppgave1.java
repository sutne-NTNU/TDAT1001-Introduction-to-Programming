import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class Oppgave1 extends GLCanvas implements GLEventListener {
    private static final int CANVAS_WIDTH = 680;
    private static final int CANVAS_HEIGHT = 480;
    private static String TITLE = "OpenGL: 02 - Task 1";
    private GLU glu;

    public Oppgave1() {
        this.addGLEventListener(this);
    }

    public static void main(String[] args) {
        GLCanvas canvas = new Oppgave1();
        canvas.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
        frame.getContentPane().add(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(TITLE);
        frame.pack();
        frame.setVisible(true);
    }

    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
        gl.glShadeModel(GL2.GL_SMOOTH);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();

        if (height == 0)
            height = 1;
        float aspect = (float) width / height;

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0, aspect, 0.1, 100.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        // Lager tabell med alle de gitte punktene, tre første er koordinater, tre siste
        // er farge
        double[][] points = { { 0.0f, 2.0f, 0.0f, 1.0f, 0.0f, 0.0f }, { 1.5f, 1.5f, 0.0f, 1.0f, 0.0f, 0.0f },
                { 2.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f }, { 1.5f, -1.5f, 0.0f, 1.0f, 1.0f, 0.0f },
                { 0.0f, -2.0f, 0.0f, 0.0f, 1.0f, 0.0f }, { -1.5f, -1.5f, 0.0f, 0.0f, 1.0f, 1.0f },
                { -2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f }, { -1.5f, 1.05f, 0.0f, 1.0f, 1.0f, .0f } };

        // -----"Tegner" alle punktene?-----
        // translater til venstre, opp og inn i området som tegnes (z-retning)
        gl.glTranslatef(-15.0f, 5.0f, -30.0f);
        gl.glBegin(GL2.GL_POINT);
        gl.glColor3f(1.0f, 1.0f, 1.0f); // Svart
        for (int i = 0; i < points.length; i++) {
            gl.glVertex3dv(points[i], 0);
        }
        gl.glEnd();

        // ----- Tegner linjer mllom to og to punkter -----
        // Translater ned
        gl.glTranslatef(0.0f, -5.0f, 0.0f); // translate left and into the screen
        gl.glBegin(GL2.GL_LINES);
        for (int i = 0; i < points.length; i++) {
            gl.glVertex3dv(points[i], 0);
            gl.glColor3dv(points[i], 3);
        }
        gl.glEnd();

        // ----- Tegner strek fra første til siste punkt -----
        // Translater ned
        gl.glTranslatef(0.0f, -5.0f, 0.0f); // translate left and into the screen
        gl.glBegin(GL2.GL_LINE_STRIP);
        for (int i = 0; i < points.length; i++) {
            gl.glVertex3dv(points[i], 0);
            gl.glColor3dv(points[i], 3); // Farge
        }
        gl.glEnd();

        // ----- Hel strek tilbake til start -----

        gl.glTranslatef(10.0f, 10.0f, 0.0f); // translate left and into the screen
        gl.glBegin(GL2.GL_LINE_LOOP);
        for (int i = 0; i < points.length; i++) {
            gl.glVertex3dv(points[i], 0);
            gl.glColor3dv(points[i], 3); // Farge
        }
        gl.glEnd();

        // ----- Trekanter med 3 og 3 punkter (vil bli 2 trekanter) -----
        // Translater ned
        gl.glTranslatef(0.0f, -5.0f, 0.0f);
        gl.glBegin(GL2.GL_TRIANGLES);
        for (int i = 0; i < points.length; i++) {
            gl.glVertex3dv(points[i], 0);
            gl.glColor3dv(points[i], 3); // Farge
        }
        gl.glEnd();

        // ----- Trekanter med de 3 siste gitte punktene -----
        // Translater ned
        gl.glTranslatef(0.0f, -5.0f, 0.0f);
        gl.glBegin(GL2.GL_TRIANGLE_STRIP);
        for (int i = 0; i < points.length; i++) {
            gl.glColor3dv(points[i], 3); // Farge
            gl.glVertex3dv(points[i], 0);
        }
        gl.glEnd();

        // ----- Vifte med trekanter (lager en trekant fra sentru ut til 2 og to
        // punkter) -----

        gl.glTranslatef(10.0f, 10.0f, 0.0f);
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        for (int i = 0; i < points.length; i++) {
            gl.glColor3dv(points[i], 3); // Farge
            gl.glVertex3dv(points[i], 0);
        }
        gl.glEnd();

        // ----- Firkanter med 4 og 4 punkter -----
        // Translater ned
        gl.glTranslatef(0.0f, -5.0f, 0.0f);
        gl.glBegin(GL2.GL_QUADS);
        for (int i = 0; i < points.length; i++) {
            gl.glColor3dv(points[i], 3); // Svart
            gl.glVertex3dv(points[i], 0);
        }
        gl.glEnd();

        // ----- Firkantstripe? -----
        // Translater ned
        gl.glTranslatef(0.0f, -5.0f, 0.0f);
        gl.glBegin(GL2.GL_QUAD_STRIP);
        for (int i = 0; i < points.length; i++) {
            gl.glColor3dv(points[i], 3); // Svart
            gl.glVertex3dv(points[i], 0);
        }
        gl.glEnd();

        // ----- Polygon -----
        // Translater opp og til høyre
        gl.glTranslatef(10.0f, 10.0f, 0.0f);
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < points.length; i++) {
            gl.glColor3dv(points[i], 3); // Svart
            gl.glVertex3dv(points[i], 0);
        }
        gl.glEnd();
    }

    public void dispose(GLAutoDrawable drawable) {
    }
}