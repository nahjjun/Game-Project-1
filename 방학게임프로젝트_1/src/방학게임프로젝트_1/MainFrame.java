package 방학게임프로젝트_1;
import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{
	public MainFrame() {
	}
	public void mainFrame() {
		setTitle("장애물 피하기 게임"); // 타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 누르면 프레임 종료 메소드
		Container contentPane = getContentPane();
		
		GamePlayScreen gamePlayScreen = new GamePlayScreen(contentPane);
		gamePlayScreen.gamePlayScreen();
		
		
		setPreferredSize(new Dimension(900,900));
		pack();
		setVisible(true);
	}
}
