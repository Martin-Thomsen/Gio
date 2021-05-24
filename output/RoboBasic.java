package myRobot;
import robocode.*;

public class RoboBasic extends Robot {
	public void _run() {
		ahead(50);
		turnRight(90);
	}

	public void onHitByBullet(HitByBulletEvent event) {
		double _a = getGunHeading();
		double _b = event.getHeading();
		turnGunRight(_a - _b);
		fire(1);
	}

	public void onHitWall(HitWallEvent event) {
		turnRight(180);
		ahead(20);
	}

}