package 방학게임프로젝트_1;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class GamePlayScreen {
	private Container contentPane;
	private int x=50, y=450, defaultY=450;
	
	public GamePlayScreen(Container _contentPane) {
		contentPane = _contentPane;
	}
	
	// 한 프레임의 화면을 출력하는 함수
	public void gamePlayScreen() {
		contentPane.removeAll();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GRAY);
		
		MainCharacter mainCharacter = new MainCharacter(x,y);
		contentPane.add(mainCharacter);
		contentPane.addKeyListener(new CharacterMoveListener(this));
		
		
		contentPane.revalidate();
		contentPane.repaint();		
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public void setX(int _x) {x = _x;}
	public void setY(int _y) {y = _y;}
		
	
}
