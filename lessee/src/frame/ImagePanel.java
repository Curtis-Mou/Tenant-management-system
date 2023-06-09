package frame;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
	private ImageIcon icon;
	private Image img;

	public ImagePanel() {
		icon = new ImageIcon(lesseeSystemMainFrame.class.getResource("/1.png"));
		img = icon.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		// 计算图像的缩放比例
		double scale = Math.min((double) getWidth() / img.getWidth(this), (double) getHeight() / img.getHeight(this));

		// 计算缩放后的图像宽度和高度
		int scaledWidth = (int) (img.getWidth(this) * scale);
		int scaledHeight = (int) (img.getHeight(this) * scale);

		// 计算图像在窗体中央的位置
		int x = (getWidth() - scaledWidth) / 2;
		int y = (getHeight() - scaledHeight) / 2;

		// 绘制缩放后的图像
		g2d.drawImage(img, x, y, scaledWidth, scaledHeight, this);

		g2d.dispose();
	}
}
