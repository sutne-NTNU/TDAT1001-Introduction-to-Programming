import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Steve extends GLCanvas implements GLEventListener {
    private static final int CANVAS_WIDTH = 1800;
    private static final int CANVAS_HEIGHT = 1600;
    private static String TITLE = "OpenGl 04 - Movement: Minecraft Steve";
    private GLU glu;
    private GLUT glut = new GLUT();
    private float bevegelseX = 0;
    private float bevegelseY = 0;
    private float bevegelseZ = 0;
    private float rotasjon = 0;
    private boolean fremover = true;
    private double footAngle = 0;
    private double rightArmAngle = 0;
    private double leftArmAngle = 0;

    private boolean thirdPerson = false;
    private boolean spin = false;
    private double dabX = 1;
    private double dabY = 0;
    private double dabZ = 0;
    private double gluPosX = 2;
    private double gluPosY = 0.5;
    private double gluPosZ = 5;
    private float synsVinkel = 0;

    private double stevePosX = bevegelseX;
    private double stevePosY = bevegelseY + 2;
    private double stevePosZ = bevegelseZ;

    public Steve() {
        this.addGLEventListener(this);
        this.addKeyListener(new KeyListener());
    }

    public static void main(String[] args) {

        GLCanvas canvas = new Steve();
        canvas.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        final JFrame frame = new JFrame();
        frame.getContentPane().add(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(TITLE);
        frame.pack();
        frame.setVisible(true);

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        glu = new GLU();
        gl.glClearColor(0.0f, 0.0f, 0.2f, 0.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }

    @Override
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

    public void drawGround(GL2 gl) {
        gl.glPushMatrix();

        gl.glColor3f(0f, 0.4f, 0.1f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(0, 0, 10);
        gl.glVertex3f(-2, 0, 10);
        gl.glVertex3f(-2, 0, -2);
        gl.glVertex3f(0, 0, -2);

        gl.glColor3f(0.4f, 0.2f, 0.0f);
        gl.glVertex3f(2, 0, 10);
        gl.glVertex3f(-0, 0, 10);
        gl.glVertex3f(-0, 0, -2);
        gl.glVertex3f(2, 0, -2);

        gl.glColor3f(0f, 0.4f, 0.7f);
        gl.glVertex3f(2, 0, 10);
        gl.glVertex3f(-2, 0, 10);
        gl.glVertex3f(-2, 0, 20);
        gl.glVertex3f(2, 0, 20);

        gl.glEnd();

        gl.glPopMatrix();
    }

    public void drawBody(GL2 gl) {
        gl.glPushMatrix();

        gl.glColor3f(0f, 0.7f, 0.7f);
        gl.glTranslatef(0, 0.9f, 0);
        gl.glScalef(0.4f, 0.6f, 0.2f);
        glut.glutSolidCube(1);

        gl.glPopMatrix();
    }

    public void drawHead(GL2 gl) {
        gl.glPushMatrix();

        // hode
        gl.glTranslatef(0, 1.4f, 0);
        gl.glColor3f(0.9f, 0.8f, 0.7f);
        gl.glScalef(0.4f, 0.4f, 0.4f);
        glut.glutSolidCube(1);

        // hår
        gl.glScalef(1.2f, 1.2f, 1.1f);
        gl.glTranslatef(0, 0.1f, -0.1f);
        gl.glColor3f(0.34f, 0.24f, 0.14f);
        glut.glutSolidCube(1);

        gl.glLoadIdentity();
        glut.glutSolidCylinder(0.1, 7, 10, 10);

        gl.glPopMatrix();
    }

    public void drawRightArm(GL2 gl) {
        gl.glPushMatrix();

        // velg punkt arm skal rotere fra
        gl.glTranslatef(-0.3f, 1.1f, 0);
        gl.glRotated(rightArmAngle, dabX, dabY, dabZ);

        // tegne skulder ut fra rotasjonspunkt
        gl.glColor3f(0f, 0.7f, 0.7f);
        gl.glScalef(0.2f, 0.2f, 0.2f);
        glut.glutSolidCube(1);

        // tegne arm ut fra rotasjonspunkt
        gl.glTranslatef(0.0f, -1.5f, 0);
        gl.glColor3f(0.9f, 0.8f, 0.7f);
        gl.glScalef(1f, 2f, 1f);
        glut.glutSolidCube(1);

        gl.glPopMatrix();
    }

    public void drawLeftArm(GL2 gl) {
        gl.glPushMatrix();

        // velg rotasjonspunkt
        gl.glTranslatef(0.3f, 1.1f, 0.0f);
        gl.glRotated(leftArmAngle, dabX, dabY, dabZ);

        // tegne skulder ut fra rotasjonspunkt
        gl.glColor3f(0.0f, 0.7f, 0.7f);
        gl.glScalef(0.2f, 0.2f, 0.2f);
        glut.glutSolidCube(1);

        // tegne arm ut fra rotasjonspunkt
        gl.glTranslatef(0.0f, -1.5f, 0);
        gl.glColor3f(0.9f, 0.8f, 0.7f);
        gl.glScalef(1f, 2f, 1f);
        glut.glutSolidCube(1);

        gl.glPopMatrix();
    }

    public void drawRightLeg(GL2 gl) {
        gl.glPushMatrix();

        // velg rotasjonspunkt
        gl.glTranslatef(0.1f, 0.5f, 0);
        gl.glRotated(-footAngle, 1, 0, 0);

        // flytt og tegn bein ut fra rotasjonspunkt
        gl.glTranslatef(0.0f, -0.2f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 0.7f);
        gl.glScalef(0.2f, 0.6f, 0.2f);
        glut.glutSolidCube(1);

        gl.glPopMatrix();
    }

    public void drawLeftLeg(GL2 gl) {
        gl.glPushMatrix();

        // velg rotasjonspunkt
        gl.glTranslatef(-0.1f, 0.5f, 0);
        gl.glRotated(footAngle, 1, 0, 0);

        // flytt og tegn bein ut fra rotasjonspunkt
        gl.glTranslatef(0.0f, -0.2f, 0);
        gl.glColor3f(0.0f, 0.0f, 0.7f);
        gl.glScalef(0.2f, 0.6f, 0.2f);
        glut.glutSolidCube(1);

        gl.glPopMatrix();
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
        gl.glBegin(GL.GL_LINES);
        gl.glVertex3d(0, 0, 0);
        gl.glVertex3dv(tabell, 0);
        gl.glEnd();
    }

    private void drawSteve(GL2 gl) {
        drawBody(gl);
        drawHead(gl);
        drawRightArm(gl);
        drawLeftArm(gl);
        drawRightLeg(gl);
        drawLeftLeg(gl);
    }

    private void updateVariables(GL2 gl) {
        stevePosX = bevegelseX;
        stevePosY = bevegelseY + 2;
        stevePosZ = bevegelseZ;
        if (thirdPerson) {
            gluPosZ = bevegelseZ - 5;
        }

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2(); // get the OpenGL 2 graphics context
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
        gl.glLoadIdentity(); // reset the model-view matrix

        updateVariables(gl);
        if (spin) {
            synsVinkel += 0.3f;
            glu.gluLookAt(0, 2.5, -5, 0, 0, 0, 0, 1, 0);
            gl.glRotatef(synsVinkel, 0, 1, 0);
            gl.glTranslatef(-bevegelseX, -bevegelseY, -bevegelseZ);
        } else {
            glu.gluLookAt(gluPosX, gluPosY, gluPosZ, stevePosX, stevePosY, stevePosZ, 0, 1, 0);
        }

        drawAllAxis(gl);
        drawGround(gl);
        gl.glTranslatef(bevegelseX, bevegelseY, bevegelseZ);
        gl.glRotatef(rotasjon, 0, 1, 0);
        drawSteve(gl);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    private class KeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'q') {
                spin = false;
                thirdPerson = !thirdPerson;
                if (thirdPerson) {
                    gluPosX = 0;
                    gluPosY = 2.5;
                    gluPosZ = bevegelseZ - 5;
                } else {
                    gluPosX = 10;
                    gluPosY = 5;
                    gluPosZ = 8;
                }
            }

            if (e.getKeyChar() == 'w') {
                if (footAngle > 60) {
                    fremover = false;
                }
                if (footAngle < -60) {
                    fremover = true;
                }
                if (fremover) {
                    footAngle += 20;
                    leftArmAngle += 8;
                    rightArmAngle -= 8;
                } else {
                    footAngle -= 20;
                    leftArmAngle -= 8;
                    rightArmAngle += 8;
                }
                bevegelseZ += Math.cos(rotasjon) * 0.2;
                bevegelseX += Math.sin(rotasjon) * 0.2;
            }

            if (e.getKeyChar() == 's') {
                if (footAngle < -60) {
                    fremover = false;
                }
                if (footAngle > 60) {
                    fremover = true;
                }
                if (fremover) {
                    footAngle -= 20;
                    leftArmAngle -= 8;
                    rightArmAngle += 8;
                } else {
                    footAngle += 20;
                    leftArmAngle += 8;
                    rightArmAngle -= 8;
                }
                bevegelseZ -= Math.cos(rotasjon) * 0.2;
                bevegelseX -= Math.sin(rotasjon) * 0.2;
            }

            if (e.getKeyChar() == 'a') {
                rotasjon += 10;
            }

            if (e.getKeyChar() == 'd') {
                rotasjon -= 10;
            }
            if (e.getKeyChar() == 'l') {
                synsVinkel = 0;
                spin = true;
            }
            if (e.getKeyChar() == ' ') {
                bevegelseY += 0.5;
            }
            if (e.getKeyChar() == 'x') {
                bevegelseY -= 0.5;
            }

            if (e.getKeyChar() == 'e') {
                if (dabX != -0.5) {
                    dabX = -0.5;
                    dabY = 0.3;
                    dabZ = 0.3;
                    leftArmAngle = 120;
                    rightArmAngle = 120;
                } else {
                    rightArmAngle = -footAngle / 2.5;
                    leftArmAngle = footAngle / 2.5;
                    dabX = 1;
                    dabY = 0;
                    dabZ = 0;
                }
            }
            if (e.getKeyChar() == 'r') {

                footAngle = 0;
                rightArmAngle = 0;
                leftArmAngle = 0;
                bevegelseX = 0;
                bevegelseY = 0;
                bevegelseZ = 0;
                rotasjon = 0;

                gluPosX = 0;
                gluPosY = 3;
                gluPosZ = bevegelseZ - 5;
            }
            Steve.this.repaint();
        }
    }
}