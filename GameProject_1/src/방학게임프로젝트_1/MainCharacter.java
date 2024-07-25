package 방학게임프로젝트_1;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MainCharacter extends JLabel{
	private static ImageIcon icon = new ImageIcon(new ImageIcon("img/캐릭터1.png").getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
	private int direction=0;
	private boolean isSmashed=false;
	
	public MainCharacter(int _x, int _y) {
		super(icon);
		this.setSize(30,30);
		this.setLocation(_x,_y);
		this.setOpaque(true);
	}
	
	public void setDirection(int _d) {
		direction = _d;
	}
	public int getDirection() {
		return direction;
	}
	public void setIsSmashed(boolean _b) {
		isSmashed = _b;
	}
	public boolean isSmashed() {
		return this.isSmashed;
	}
}
