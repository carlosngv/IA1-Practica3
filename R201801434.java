package IA1jun23;
import robocode.*;
import java.awt.Color;


/**
 * R201801434 - a robot by (Carlos Ng)
 */
public class R201801434 extends Robot
{
	public void run() {

		setBodyColor(Color.black);
		setGunColor(Color.gray);
		setRadarColor(Color.black);
		setBulletColor(Color.red);
		setScanColor(Color.green);

		while(true) {

            /*  Movimiento Constante

                Escaneo constante de la zona.

                Habrá un desplazamiento hacia adelante de 100 pixeles
                y uno para atrás de 80 pixeles.

                Movimiento a razón de 30 px/s.
            */

			ahead(100);
			turnGunRight(360);
			back(70);
			turnGunRight(360);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
        // Siempre disparará con un power = 1.
		fire(1);
	}

	public void onHitByBullet(HitByBulletEvent e) {
        // Obtendrá el ángulo de donde viene el proyectil.
		double bearing = e.getBearing();
        double energiaActual = getEnergy();
        if(energiaActual < 80) {
            escapar(bearing);
        } else {
            turnLeft(-bearing);
        }
	}

	public void onHitWall(HitWallEvent e) {
        // Bearing es el ángulo relativo con respecto a un objeto (la pared).
        double bearing = e.getBearing();
        escapar(bearing);
	}

    public void escapar(double bearing) {
        // TODO: No es tan conveniente, manejar posibles giros.
        turnRight(-bearing);
		ahead(100);
    }
}
