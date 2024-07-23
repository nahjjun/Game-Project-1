package 방학게임프로젝트_1;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Obstacle1 extends JLabel {
	private static int size = (int)Math.random()*20+30; // 30~50까지 크기의 장애물들이 생성됨
	private static ImageIcon icon = new ImageIcon(new ImageIcon("img/장애물1.png").getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
	private int direction=0; // 0:북, 1:북동, 2:동, 3:남동, 4:남, 5:남서, 6:서, 7:북서 
	public Obstacle1(int _x, int _y) {
		super(icon);
		this.setSize(size, size);
		this.setLocation(_x,_y);
		this.setOpaque(true);
	}
	
	public void setDirection(int _d) {
		direction = _d;
	}
	public int getDirection() {
		return direction;
	}
	
	
	
}
