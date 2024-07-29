package 방학게임프로젝트_1;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import javax.swing.*;
public class GamePlayScreen {
	// -------------data 객체들-------------
	private TimerTask task;
	private Timer timer;
	private Container contentPane; 
	
	
	// -------------인터페이스-------------
	private Menu menu;
	private HealthBar healthBar;
	
	
	// -------------캐릭터들-------------
	private MainCharacter mainCharacter;
	private ArrayList<Obstacle_1> obstacles_1; // 주기적으로 장애물들을 생성하고 해당 장애물들을 저장하기 위한 배열
	
	// --------------------------------
	public GamePlayScreen(Container _contentPane) {
		timer = new Timer();
		contentPane = _contentPane;
		menu = new Menu();
		healthBar = new HealthBar(300); // 체력 설정
		mainCharacter = new MainCharacter(500,300);
		obstacles_1 = new ArrayList<>();
		obstacles_1.add(new Obstacle_1(0,0));
	}
	
	public void gamePlayScreen() {
		contentPane.setFocusable(true); // KeyListener는 컴포넌트가 포커스를 받을 때만 작동하기 때문에, 이 함수로 contentPane에 포커스를 준다
		contentPane.addKeyListener(new CharacterMoveListener(mainCharacter));
		resetPage(); // 일정 시간마다 게임 화면을 초기화해주는 TimerTask 객체를 정의 해주는 함수
		timer.scheduleAtFixedRate(task, 0, 3); // 0ms의 지연으로 0.003초마다 TimerTask의 run 함수를 실행해주는
	}	
	

    public void resetPage() {
        task = new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        contentPane.removeAll();
                        contentPane.setLayout(null);
                        contentPane.setBackground(Color.BLACK);

                        setCharater();
                        for (int i = 0; i < obstacles_1.size(); ++i) {
                        	setObstacle(i);
                            // 만약 두개가 충돌했다면 목숨이 깎이고, 목숨이 전부 없어지면 게임 종료 화면으로 이동
                            if (isSmashed(i)) {
                            	healthBar.setHealth(healthBar.getHealth() - 1);
                                if (healthBar.getHealth() == 0) {
                                    EndPage endPage = new EndPage();
                                    endPage.endPage();
                                    task.cancel();
                                    timer.cancel();
                                }
                            }
                        }

                        // ------------장애물을 추가할지 결정-------------
                        int plusObstacles = obstacles_1.get(0).getPlusObstacles();
                        if(plusObstacles >= Obstacle_1.getMaxPlusObstacles()) { // 계속해서 증가하는 변수가 일정 시간을 넘게 되면
                        	obstacles_1.get(0).setPlusObstacles(0);
                        	obstacles_1.add(new Obstacle_1(0, 0));
                        }
                        else {// 계속해서 증가하는 변수가 일정 시간을 넘지 않았다면
                        	obstacles_1.get(0).setPlusObstacles(plusObstacles+1);
                        }
                        
                        // ------------컴포넌트들 추가------------
                        contentPane.add(mainCharacter);
                        for (int i = 0; i < obstacles_1.size(); ++i)
                            contentPane.add(obstacles_1.get(i));
                        contentPane.add(menu);
                        menu.add(healthBar);
                        //------------------------------------
                        
                        contentPane.revalidate();
                        contentPane.repaint();
                    }
                });
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
				&& currentY+moveY>=0 && currentY+moveY+30<=600) { // 
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
	
	// 캐릭터와 장애물이 부딪혔는지 확인하는 함수
	public boolean isSmashed(int j) {
		int xTmp = mainCharacter.getX();
		int yTmp = mainCharacter.getY();
		
		int[] xMainCharacter = {xTmp, xTmp+30, xTmp+30, xTmp};
		int[] yMainCharacter = {yTmp, yTmp, yTmp+30, yTmp+30};
		
		// 4개의 꼭짓점이 한군데라도 장애물의 범위 내에 있는 경우, true를 반환한다
		for(int i=0; i<4; ++i) {
			if(xMainCharacter[i]>=obstacles_1.get(j).getX() && xMainCharacter[i]<=obstacles_1.get(j).getX()+obstacles_1.get(j).takeSize()
					&& yMainCharacter[i]>=obstacles_1.get(j).getY() && yMainCharacter[i]<=obstacles_1.get(j).getY()+obstacles_1.get(j).takeSize())
				return true;
		} 
		return false;
	}
	
}

