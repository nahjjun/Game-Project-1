package 방학게임프로젝트_1;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class HealthBar extends JLabel{
	private int maxHealth;
    private int currentHealth;

    public HealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.setSize(80, maxHealth); // 원하는 크기 설정
        this.setLocation(10,10);
    }

    public int getHealth() {return currentHealth;}
    public void setHealth(int health) {
        this.currentHealth = health;
        repaint(); // 체력 변경 시 다시 그리기
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티앨리어싱 적용
        
        // 배경 그리기
        g2d.setColor(Color.GRAY);
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        // 현재 체력 그리기
        g2d.setColor(Color.RED);
        int height = (int) ((double) currentHealth / maxHealth * getHeight());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), height, 20, 20));

        // 테두리 그리기
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // 테두리 굵기 설정
        g2d.draw(new RoundRectangle2D.Double(2, 2, getWidth()-3.5, getHeight()-4, 20, 20));
    }
}
