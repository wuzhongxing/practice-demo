package com.practice.alg;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author zhongxing.wu
 * @since 2016年4月25日
 */
public class TestMap {
	final static private int CS = 32;

	// 地图描述
	final static public int[][] MAP = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// 无法移动区域
	final static public int[] HIT = { 1 };

	// 设定背景方格默认行数
	final static private int ROW = 15;

	// 设定背景方格默认列数
	final static private int COL = 15;

	private Image floorImage;

	private Image wallImage;

	public TestMap() {
		try {
			floorImage = ImageIO.read(TestMap.class.getClassLoader().getResourceAsStream("floor.jpg"));
			wallImage = ImageIO.read(TestMap.class.getClassLoader().getResourceAsStream("wall.jpg"));
//		floorImage = new Bitmap("./astart/floor.gif").getImage();
//		wallImage = new Bitmap("./astart/wall.gif").getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				switch (MAP[i][j]) {
				case 0:
					g.drawImage(floorImage, j * CS, i * CS, null);
					break;
				case 1:
					g.drawImage(wallImage, j * CS, i * CS, null);
					break;
				}
			}
		}
	}
}
