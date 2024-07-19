package 방학게임프로젝트_1;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class GamePlayScreen {
	private Container contentPane;
	public GamePlayScreen(Container _contentPane) {
		contentPane = _contentPane;
	}
	public void gamePlayScreen() {
		contentPane.removeAll();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GRAY);
		
		ImageIcon icon = new ImageIcon("img/캐릭터1.png");
		Image scaledImage = icon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
				
		
		
		JLabel mainCharacter = new JLabel(icon);
		mainCharacter.setSize(100,100);
		mainCharacter.setLocation(100,500);
		mainCharacter.setOpaque(true);
		contentPane.add(mainCharacter);
		
		contentPane.revalidate();
		contentPane.repaint();
		
	}
	
	
}
