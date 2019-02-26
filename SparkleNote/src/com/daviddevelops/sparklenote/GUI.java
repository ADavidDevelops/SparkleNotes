package com.daviddevelops.sparklenote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame {

	public GUI(String name, int width, int height) {
		setIconImage(new ImageIcon("icon.jpg").getImage());
		setTitle(name);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextArea text = new JTextArea();
		JScrollPane scroll = new JScrollPane(text);
		text.setLineWrap(true);
		add(scroll);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu mainMenu = new JMenu("Files");
		JMenuItem openFile = new JMenuItem("Open File");
		JMenuItem closeFile = new JMenuItem("Save & Close File");
		
		JFileChooser fileChooser = new JFileChooser();
		
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int fileValue = fileChooser.showOpenDialog(GUI.this);
				 if (fileValue == JFileChooser.APPROVE_OPTION) {
					 File txtFile = fileChooser.getSelectedFile();
					 try {
						BufferedReader reader = new BufferedReader(new FileReader(txtFile));
						text.setText("");
						String line = reader.readLine();
						while(line != null) {
							text.append(line + System.lineSeparator());
							line = reader.readLine();
						}
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					 
				 } else {
					 
				 }
			}
		});
		
		closeFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int fileValue = fileChooser.showOpenDialog(GUI.this);
				 if (fileValue == JFileChooser.APPROVE_OPTION) {
					 try {
						File ourfile = fileChooser.getSelectedFile();
						ourfile.getName().endsWith("test.locked");
						PrintWriter printer = new PrintWriter(ourfile);
						printer.println(text.getText().replaceAll("\\n", System.lineSeparator()));
						printer.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				 } else {
					 
				 }
			}
		});
		
		mainMenu.setMnemonic(KeyEvent.VK_9);
		
		menuBar.add(mainMenu);
		
		mainMenu.add(openFile);
		mainMenu.add(closeFile);
		
		setJMenuBar(menuBar);
		
		setVisible(true);
	}
	
}
