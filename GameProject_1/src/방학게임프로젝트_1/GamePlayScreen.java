package 방학게임프로젝트_1;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import javax.swing.*;
public class GamePlayScreen {
	private Container contentPane;
	private TimerTask task;
	private MainCharacter mainCharacter;
	private ArrayList<Obstacle_1> obstacles_1; // 주기적으로 장애물들을 생성하고 해당 장애물들을 저장하기 위한 배열
	
	public GamePlayScreen(Container _contentPane) {
		contentPane = _contentPane;
	}
	
	public void gamePlayScreen() {
		mainCharacter = new MainCharacter(50,450);
		obstacles_1 = new ArrayList<>();
		obstacles_1.add(new Obstacle_1(100,100));
		
		contentPane.setFocusable(true); // KeyListener는 컴포넌트가 포커스를 받을 때만 작동하기 때문에, 이 함수로 contentPane에 포커스를 준다
		contentPane.addKeyListener(new CharacterMoveListener(mainCharacter));
		resetPage(); // 일정 시간마다 게임 화면을 초기화해주는 TimerTask 객체를 정의 해주는 함수
		new Timer().scheduleAtFixedRate(task, 0, 3); // 0ms의 지연으로 0.003초마다 TimerTask의 run 함수를 실행해주는
	}	
	
	public void resetPage() {
		task = new TimerTask() {
			@Override
			public void run() {
				contentPane.removeAll();
				contentPane.setLayout(null);

				setCharater();
				for(int i=0; i<obstacles_1.size(); ++i)
					setObstacle(i);
					
				contentPane.add(mainCharacter);
				for(int i=0; i<obstacles_1.size(); ++i)
					contentPane.add(obstacles_1.get(i));
				
				contentPane.revalidate();
				contentPane.repaint();
			}
		};
	}
	
	// 프레임별로 게임 캐릭터 위치를 설정해주는 함수 
	public void setCharater() {
		int moveX = 0; // x축 방향으로 움직일 때 움직일 크기
		int moveY = 0; // y축 방향으로 움직일 때 움직일 크기
		switch(mainCharacter.getDirection()) {
		case 0: // 위쪽인 경우
			moveX = 0;
			moveY = -1;
			break;
		case 1: // 오른쪽인 경우
			moveX = 1;
			moveY = 0;
			break;
		case 2: // 아래쪽인 경우
			moveX = 0;
			moveY = 1;
			break;
		case 3: // 왼쪽인 경우
			moveX = -1;
			moveY = 0;
			break;
		default:
			moveX = 0;
			moveY = 0;
			break;
		}
		int currentX = mainCharacter.getX();
		int currentY = mainCharacter.getY();
		if(currentX+moveX>=0 && currentX+moveX+30<=1000
				&& currentY+moveY>=0 && currentY+moveY+30<=600) {// 캐릭터가 이동했을 때도 frame 안에 있는 경우
			mainCharacter.setLocation(mainCharacter.getX()+moveX, mainCharacter.getY()+moveY); 
		}
	}
	
	// 프레임별로 장애물 위치를 설정해주는 함수
	public void setObstacle(int _i) {
		int moveX = 0; // x축 방향으로 움직일 때 움직일 크기
		int moveY = 0; // y축 방향으로 움직일 때 움직일 크기
		switch(obstacles_1.get(_i).getDirection()) {
		case 0: // 북쪽인 경우
			moveX = 0;
			moveY = -1;
			break;
		case 1: // 북동쪽인 경우
			moveX = 1;
			moveY = -1;
			break;
		case 2: // 동쪽인 경우
			moveX = 1;
			moveY = 0;
			break;
		case 3: // 남동쪽인 경우
			moveX = 1;
			moveY = 1;
			break;
		case 4: // 남쪽인 경우
			moveX = 0;
			moveY = 1;
			break;
		case 5: // 남서쪽인 경우
			moveX = -1;
			moveY = 1;
			break;
		case 6: // 서쪽인 경우
			moveX = -1;
			moveY = 0;
			break;
		case 7: // 북서쪽인 경우
			moveX = -1;
			moveY = -1;
			break;
		default:
			moveX = 0;
			moveY = 0;
			break;
		}
		int currentX = obstacles_1.get(_i).getX();
		int currentY = obstacles_1.get(_i).getY();
		if(currentX+moveX>=0 && currentX+moveX+30<=1000
				&& currentY+moveY>=0 && currentY+moveY+30<=600) {
			obstacles_1.get(_i).setLocation(obstacles_1.get(_i).getX()+moveX, obstacles_1.get(_i).getY()+moveY);	
		}
		else {
			int newDirection;
			do{
				newDirection = (int)(Math.random()*10); // 랜덤으로 새로운 방향을 생성. 0~7까지, 겹치는 방향은 금지
			}while(newDirection == obstacles_1.get(_i).getDirection() || newDirection<0 || newDirection>7);
			obstacles_1.get(_i).setDirection(newDirection);
		}
	}
	
}
