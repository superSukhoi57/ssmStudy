package com.littleheap;

import java.awt.EventQueue;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ʵ����������
					MainInterface frame = new MainInterface();
					//��ʾ������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
