package 방학게임프로젝트_1;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class MainCharacter extends JLabel{
	private static ImageIcon icon = new ImageIcon(new ImageIcon("img/캐릭터1.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
	public MainCharacter(int _x, int _y) {
		super(icon);
		this.setSize(50,50);
		this.setLocation(_x,_y);
		this.setOpaque(true);
	}
	
}
