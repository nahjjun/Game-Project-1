package 방학게임프로젝트_1;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Obstacle_1 extends JLabel {
	private static int size = 30;
	private static ImageIcon icon = new ImageIcon(new ImageIcon("img/장애물1.png").getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
	private int direction=0; // 0:북, 1:북동, 2:동, 3:남동, 4:남, 5:남서, 6:서, 7:북서
	
	private int plusObstacles; // 이 변수는 계속해서 증가하다가, 일정값을 넘으면 장애물을 추가하는데 쓰일 것이다.
	private static int maxPlusObstacles; // 장애물이 일정 시간마다 추가될 것인데, 해당 시간을 조절하는데 쓰이는 변수
	
	public Obstacle_1(int _x, int _y) {
		super(icon);
		this.setSize(size, size);
		this.setLocation(_x,_y);
		this.setOpaque(true);
		plusObstacles=0;
		maxPlusObstacles=1000;
	}
	
	public void setDirection(int _d) {direction = _d;}
	public int getDirection() {return direction;}
	public int takeSize() {return size;}
	
	public void setPlusObstacles(int _p) {plusObstacles=_p;}
	public int getPlusObstacles() {return plusObstacles;}
	
	public static void setMaxPlusObstacles(int _p) {maxPlusObstacles=_p;}
	public static int getMaxPlusObstacles() {return maxPlusObstacles;}
}
