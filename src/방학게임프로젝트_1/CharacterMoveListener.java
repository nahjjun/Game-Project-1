package 방학게임프로젝트_1;
import java.awt.event.*;
import javax.swing.event.*;

// 키를 입력받으면 캐릭터가 움직이는 무브 리스너 클래스
public class CharacterMoveListener extends KeyAdapter{
	private MainCharacter mainCharacter;
	public CharacterMoveListener(MainCharacter _mainCharacter) {
		mainCharacter = _mainCharacter;
	}
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_UP:
			mainCharacter.setDirection(0);
			break;
		case KeyEvent.VK_RIGHT:
			mainCharacter.setDirection(1);
			break;
		case KeyEvent.VK_DOWN:
			mainCharacter.setDirection(2);
			break;
		case KeyEvent.VK_LEFT:
			mainCharacter.setDirection(3);
			break;
		}
		System.out.println("key pressed");
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("key released");
	}
}
