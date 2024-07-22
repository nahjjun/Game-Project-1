package 방학게임프로젝트_1;
import java.awt.event.*;
import javax.swing.event.*;

// 키를 입력받으면 캐릭터가 움직이는 무브 리스너 클래스
public class CharacterMoveListener extends KeyAdapter{
	private GamePlayScreen g;
	public CharacterMoveListener(GamePlayScreen _g) {
		g = _g;
	}
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int movePx = 5; // 1회당 움직일 간격
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			g.setX(g.getX()-movePx);
			break;
		case KeyEvent.VK_RIGHT:
			g.setX(g.getX()+movePx);
			break;
		case KeyEvent.VK_UP:
			g.setY(g.getY()-movePx);
			break;
		case KeyEvent.VK_DOWN:
			g.setY(g.getY()+movePx);
			break;
		}
		System.out.println("key pressed");
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("key released");
	}
}
