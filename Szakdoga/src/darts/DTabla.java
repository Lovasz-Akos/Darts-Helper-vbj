package darts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

public class DTabla extends JFrame {

	protected static final Component frame = null;
	private JPanel contentPane;
	private JTextField txtScored;
	public JLabel player1 = new JLabel("J\u00E1t\u00E9kos 1");
	public JLabel player2 = new JLabel("J\u00E1t\u00E9kos 2");
	public JLabel recom = new JLabel("");
	public JLabel p1score = new JLabel("J\u00E1t\u00E9kos 1 pont");
	public JLabel p2score = new JLabel("J\u00E1t\u00E9kos 2 pont");
	public JLabel dart = new JLabel("Dart");
	public int dartcount = 3;
	public String p1 = "";
	public String p2 = "";	
	public String recommend = "";
	public boolean p1plz = true;
	public DTabla() {
		setTitle("Darts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 324);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setJMenuBar(menuBar);
		
		JMenuItem NewGame = new JMenuItem("Be\u00E1ll\u00EDt\u00E1sok");
		NewGame.setFont(new Font("Calibri", Font.PLAIN, 14));
		NewGame.setBackground(new Color(0, 204, 102));
		NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//newgame
				NewGame ng = new NewGame();
			}
		});
		
		
		
		JMenuItem mntmJtkIndtsa = new JMenuItem("J\u00E1t\u00E9k ind\u00EDt\u00E1sa");
		mntmJtkIndtsa.setFont(new Font("Calibri", Font.PLAIN, 14));
		mntmJtkIndtsa.setBackground(new Color(0, 204, 102));
		mntmJtkIndtsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int score1 = 0;
				int score2 = 0;
				int darts = 3;
				
				Connection con=new ConnectorDB().getCon();
				try {
					Statement stm = (Statement) con.createStatement();
					ResultSet start = stm.executeQuery("SELECT `helper`.`kezd` FROM `helper`");
					
					while (start.next()) {
						score1 = start.getInt(1);
						score2 = start.getInt(1);
					}
					p1score.setText(String.valueOf((score1)));
					p2score.setText(String.valueOf((score2)));
					dart.setText(String.valueOf(darts));
					player1.setForeground(Color.red);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(mntmJtkIndtsa, "SQL Hiba");
				}
				
				/*game starts with this. might be easier this way...*/
				

				// LEGACY STARTER
				
				
				/*
				for (int i = 1; i < 3; i++) {
					JFrame frame = new JFrame("Input");
					String name = JOptionPane.showInputDialog(frame, "Add meg a(z) " + i + ". játékos nevét");
					while (name.length() == 0) {
						JOptionPane.showMessageDialog(frame, "Nem adtál meg semmit!");
						name = JOptionPane.showInputDialog(frame, "Add meg a(z) " + i + ". játékos nevét");
						
					}
					//ja nem
					if (i == 1) {
						p1 = name;
					}
					if (i == 2) {
						p2 = name;
					}
					
					
				}
				
				*/
					
					
						Statement stm;
						
						try {
							stm = (Statement) con.createStatement();
							ResultSet rs = stm.executeQuery("SELECT `player1` FROM `helper`");	
							while(rs.next()) {
								p1 = rs.getString(1);
								player1.setText(p1);
							}
							ResultSet rs2 = stm.executeQuery("SELECT `player2` FROM `helper`");	
							while(rs2.next()) {
								p2 = rs2.getString(1);
								player2.setText(p2);	
							}
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(mntmJtkIndtsa, "SQL Hiba");
							e1.printStackTrace();
						}
					
						

					
					//get from helper
					
					
					
					
			}
		});
		menuBar.add(mntmJtkIndtsa);
		NewGame.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(NewGame);
		
		JMenuItem PlayerOptions = new JMenuItem("Statisztika");
		PlayerOptions.setFont(new Font("Calibri", Font.PLAIN, 14));
		PlayerOptions.setBackground(new Color(0, 204, 102));
		PlayerOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//playeroptions
				Table st = new Table();
			}
		});
		PlayerOptions.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(PlayerOptions);
		
		JMenuItem Exit = new JMenuItem("Kil\u00E9p\u00E9s");
		Exit.setFont(new Font("Calibri", Font.PLAIN, 14));
		Exit.setBackground(new Color(0, 204, 102));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//exit
				JFrame frame = new JFrame("Input");
				Object[] options = {"Igen", "Nem"};
				int ki = JOptionPane.showOptionDialog(frame,
				"Biztosan ki akarsz lépni?",
				"Kilépés",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     
				options,  
				options[0]); 
				if (ki == 0) {
					//Lépj is ki te FASZ
					System.exit(0);
				} else;
			}
		});
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(Exit);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlLtHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtScored = new JTextField();
		txtScored.setFont(new Font("Calibri", Font.BOLD, 18));
		txtScored.setBounds(197, 36, 113, 29);
		contentPane.add(txtScored);
		txtScored.setColumns(10);
		
		
		JButton btnThrow = new JButton("Dob\u00E1s");
		btnThrow.setBackground(Color.LIGHT_GRAY);
		btnThrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//actual game
				/* get textbox state, test for number, give suggest, set names and score, set throws to 3 */
				
				int p1s = Integer.parseInt(p1score.getText());
				int p2s = Integer.parseInt(p2score.getText());
				int p1help = Integer.parseInt(p1score.getText());
				int p2help = Integer.parseInt(p2score.getText());
				int lastthrow = 0;
				try {
					int thrown = Integer.parseInt(txtScored.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(btnThrow, "Ilyen értéket nem lehet dobni!");
				}
				//implement triple ifs //or not xd
				//wow switchcase 4 lyf
				Connection kon =new ConnectorDB().getCon();
				Statement stm;
				String decider = "";

				recom.setText(recommend);
				try {
					stm = (Statement) kon.createStatement();
					ResultSet rs = stm.executeQuery("SELECT `helper`.`kilep` FROM `helper`");
					while (rs.next()) {
					decider = rs.getString(1);
					}
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
					e.printStackTrace();
				}
				
				
				//recommnnennnenend
				
				String player1N = player1.getText();
				String player2N = player2.getText();
				if ((Integer.parseInt(txtScored.getText())) > 60 || (Integer.parseInt(txtScored.getText()) < 0)) {
					JOptionPane.showMessageDialog(btnThrow, "Ilyen értéket nem lehet dobni!");
				} else {

				
				if (p1plz) {
					player1.setForeground(Color.red);
					player2.setForeground(Color.black);
					switch (dartcount) {
					case 3:
						
						p1s = p1s - Integer.parseInt(txtScored.getText());
						lastthrow = Integer.parseInt(txtScored.getText());
						
						if(decider.equals("Dupla")) {
							//select from dupla
							if((Integer.parseInt(txtScored.getText()) % 2 == 0) && (p1s == 0) && (decider.equals("Dupla"))) {
								try {
									Statement stm1 = (Statement) kon.createStatement();
									int wins = 0;			
									JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player1.getText() + " a gyõztes!!!");
									ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player1N+"'");
									while (rs3.next()) {
										wins = rs3.getInt(1);
									}
									wins++;
									PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player1N+"'");		
									ps1.setInt(1, wins);
									ps1.execute();
									dispose();
								}
								catch (Exception e) {
									JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								}
							}
							else if(decider.equals("Dupla") && (Integer.parseInt(txtScored.getText()) % 2 != 0) && (p1s == 0)) {
								JOptionPane.showMessageDialog(btnThrow, "Nem duplával szálltál ki.");
								p1s += lastthrow;
								p1score.setText(Integer.toString(p1s));
								
							}
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `double_out`.`Suggest` FROM `double_out` WHERE `double_out`.`Score` = '"+p1s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						if(decider.equals("Szimpla")) {
							//select from szimpla
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `simple_out`.`Suggest` FROM `simple_out` WHERE `simple_out`.`Score` = '"+p1s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						
						
						p1score.setText(Integer.toString(p1s)); 
						
						dartcount--;
						dart.setText(Integer.toString(dartcount));
						if (p1s < 0) {
							JOptionPane.showMessageDialog(btnThrow, "Túl nagyot dobtál");
							p1s = p1help;
							p1score.setText(Integer.toString(p1s)); 
						}
						p1help = p1s;
						break;
					case 2:
						
						p1s = p1s - Integer.parseInt(txtScored.getText());
						lastthrow = Integer.parseInt(txtScored.getText());
						if(decider.equals("Dupla")) {
							//select from dupla
							if((Integer.parseInt(txtScored.getText()) % 2 == 0) && (p1s == 0) && (decider.equals("Dupla"))) {
								try {
									Statement stm1 = (Statement) kon.createStatement();
									int wins = 0;			
								
									
									JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player1.getText() + " a gyõztes!!!");
									

									ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player1N+"'");
									while (rs3.next()) {
										wins = rs3.getInt(1);
									}
									wins++;
									PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player1N+"'");		
									ps1.setInt(1, wins);
									ps1.execute();
									dispose();
								}
								catch (Exception e) {
									JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								}
							}
							else if(decider.equals("Dupla") && (Integer.parseInt(txtScored.getText()) % 2 != 0) && (p1s == 0)) {
								JOptionPane.showMessageDialog(btnThrow, "Nem duplával szálltál ki.");
								p1s += lastthrow;
								p1score.setText(Integer.toString(p1s));
								
							}
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `double_out`.`Suggest` FROM `double_out` WHERE `double_out`.`Score` = '"+p1s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						if(decider.equals("Szimpla")) {
							//select from szimpla
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `simple_out`.`Suggest` FROM `simple_out` WHERE `simple_out`.`Score` = '"+p1s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						p1score.setText(Integer.toString(p1s)); 
						dartcount--;
						dart.setText(Integer.toString(dartcount));
						if (p1s < 0) {
							JOptionPane.showMessageDialog(btnThrow, "Túl nagyot dobtál");
							p1s = p1help;
							p1score.setText(Integer.toString(p1s)); 
						}
						p1help = p1s;
						break;
					case 1:
						
						p1s = p1s - Integer.parseInt(txtScored.getText());
						lastthrow = Integer.parseInt(txtScored.getText());
						if(decider.equals("Dupla")) {
							//select from dupla
							if((Integer.parseInt(txtScored.getText()) % 2 == 0) && (p1s == 0) && (decider.equals("Dupla"))) {
								try {
									Statement stm1 = (Statement) kon.createStatement();
									int wins = 0;			
								
									
									JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player1.getText() + " a gyõztes!!!");
									

									ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player1N+"'");
									while (rs3.next()) {
										wins = rs3.getInt(1);
									}
									wins++;
									PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player1N+"'");		
									ps1.setInt(1, wins);
									ps1.execute();
									dispose();
								}
								catch (Exception e) {
									JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								}
							}
							else if(decider.equals("Dupla") && (Integer.parseInt(txtScored.getText()) % 2 != 0) && (p1s == 0)) {
								JOptionPane.showMessageDialog(btnThrow, "Nem duplával szálltál ki.");
								p1s += lastthrow;
								p1score.setText(Integer.toString(p1s));
								
							}
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `double_out`.`Suggest` FROM `double_out` WHERE `double_out`.`Score` = '"+p1s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						if(decider.equals("Szimpla")) {
							//select from szimpla
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `simple_out`.`Suggest` FROM `simple_out` WHERE `simple_out`.`Score` = '"+p1s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						p1score.setText(Integer.toString(p1s)); 
						dartcount--;
						dart.setText(Integer.toString(dartcount));
						if (p1s < 0) {
							JOptionPane.showMessageDialog(btnThrow, "Túl nagyot dobtál");
							p1s = p1help;
							p1score.setText(Integer.toString(p1s)); 
						}
						p1help = p1s;
						JOptionPane.showMessageDialog(btnThrow, "Nincs több dobásod");
						p1plz = false;
						if( Integer.parseInt(p1score.getText()) == 0) {p1plz=true;}
						dartcount = 3;
						dart.setText(Integer.toString(dartcount));
						txtScored.setText(null);
						break;
					default:
						JOptionPane.showMessageDialog(btnThrow, "Nincs több dobásod");
						break;
					}
				}
				
				recommend = "";
				recom.setText(recommend);
				
				if (!p1plz) {
					player1.setForeground(Color.black);
					player2.setForeground(Color.red);
					switch (dartcount) {
					case 3:
						
						p2s = p2s - Integer.parseInt(txtScored.getText());
						lastthrow = Integer.parseInt(txtScored.getText());
						if(decider.equals("Dupla")) {
							//select from dupla
							if((Integer.parseInt(txtScored.getText()) % 2 == 0) && (p2s == 0) && (decider.equals("Dupla"))) {
								try {
									Statement stm1 = (Statement) kon.createStatement();
									int wins = 0;			
								
									
									JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player2.getText() + " a gyõztes!!!");
									

									ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player2N+"'");
									while (rs3.next()) {
										wins = rs3.getInt(1);
									}
									wins++;
									PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player2N+"'");		
									ps1.setInt(1, wins);
									ps1.execute();
									dispose();
								}
								catch (Exception e) {
									JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								}
							}
							else if(decider.equals("Dupla") && (Integer.parseInt(txtScored.getText()) % 2 != 0) && (p2s == 0)) {
								JOptionPane.showMessageDialog(btnThrow, "Nem duplával szálltál ki.");
								p2s += lastthrow;
								p2score.setText(Integer.toString(p1s));
								
							}
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `double_out`.`Suggest` FROM `double_out` WHERE `double_out`.`Score` = '"+p2s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						if(decider.equals("Szimpla")) {
							//select from szimpla
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `simple_out`.`Suggest` FROM `simple_out` WHERE `simple_out`.`Score` = '"+p2s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						
						p2score.setText(Integer.toString(p2s)); 
						dartcount--;
						dart.setText(Integer.toString(dartcount));
						if (p2s < 0) {
							JOptionPane.showMessageDialog(btnThrow, "Túl nagyot dobtál");
							p2s = p2help;
							p2score.setText(Integer.toString(p2s)); 
						}
						p2help = p2s;
						break;
					case 2:
						
						p2s = p2s - Integer.parseInt(txtScored.getText());
						lastthrow = Integer.parseInt(txtScored.getText());
						if(decider.equals("Dupla")) {
							//select from dupla
							if((Integer.parseInt(txtScored.getText()) % 2 == 0) && (p2s == 0) && (decider.equals("Dupla"))) {
								try {
									Statement stm1 = (Statement) kon.createStatement();
									int wins = 0;			
								
									
									JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player2.getText() + " a gyõztes!!!");
									

									ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player2N+"'");
									while (rs3.next()) {
										wins = rs3.getInt(1);
									}
									wins++;
									PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player2N+"'");		
									ps1.setInt(1, wins);
									ps1.execute();
									dispose();
								}
								catch (Exception e) {
									JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								}
							}
							else if(decider.equals("Dupla") && (Integer.parseInt(txtScored.getText()) % 2 != 0) && (p2s == 0)) {
								JOptionPane.showMessageDialog(btnThrow, "Nem duplával szálltál ki.");
								p2s += lastthrow;
								p2score.setText(Integer.toString(p1s));
								
							}
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `double_out`.`Suggest` FROM `double_out` WHERE `double_out`.`Score` = '"+p2s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						if(decider.equals("Szimpla")) {
							//select from szimpla
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `simple_out`.`Suggest` FROM `simple_out` WHERE `simple_out`.`Score` = '"+p2s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						
						p2score.setText(Integer.toString(p2s)); 
						dartcount--;
						dart.setText(Integer.toString(dartcount));
						if (p2s < 0) {
							JOptionPane.showMessageDialog(btnThrow, "Túl nagyot dobtál");
							p2s = p2help;
							p2score.setText(Integer.toString(p2s)); 
						}
						p2help = p2s;
						break;
					case 1:
						
						p2s = p2s - Integer.parseInt(txtScored.getText());
						lastthrow = Integer.parseInt(txtScored.getText());
						if(decider.equals("Dupla")) {
							//select from dupla
							if((Integer.parseInt(txtScored.getText()) % 2 == 0) && (p2s == 0) && (decider.equals("Dupla"))) {
								try {
									Statement stm1 = (Statement) kon.createStatement();
									int wins = 0;			
								
									
									JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player2.getText() + " a gyõztes!!!");
									

									ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player2N+"'");
									while (rs3.next()) {
										wins = rs3.getInt(1);
									}
									wins++;
									PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player2N+"'");		
									ps1.setInt(1, wins);
									ps1.execute();
									dispose();
								}
								catch (Exception e) {
									JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								}
							}
							else if(decider.equals("Dupla") && (Integer.parseInt(txtScored.getText()) % 2 != 0) && (p2s == 0)) {
								JOptionPane.showMessageDialog(btnThrow, "Nem duplával szálltál ki.");
								p2s += lastthrow;
								p2score.setText(Integer.toString(p1s));
								
							}
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `double_out`.`Suggest` FROM `double_out` WHERE `double_out`.`Score` = '"+p2s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
							
						}
						if(decider.equals("Szimpla")) {
							//select from szimpla
							try {
								stm = (Statement) kon.createStatement();
								ResultSet rs = stm.executeQuery("SELECT `simple_out`.`Suggest` FROM `simple_out` WHERE `simple_out`.`Score` = '"+p2s+"'");
								while (rs.next()) {
									recommend = rs.getString(1);
									if (recommend.equals("")){
										recommend = "";
									}
									recom.setText(recommend);
									}
							} catch (SQLException e) {
								JOptionPane.showMessageDialog(btnThrow, "SQL Hiba");
								e.printStackTrace();
							}
						}
						
						p2score.setText(Integer.toString(p2s)); 
						dartcount--;
						dart.setText(Integer.toString(dartcount));
						if (p2s < 0) {
							JOptionPane.showMessageDialog(btnThrow, "Túl nagyot dobtál");
							p2s = p2help;
							p2score.setText(Integer.toString(p2s)); 
						}
						p2help = p2s;
						JOptionPane.showMessageDialog(btnThrow, "Nincs több dobásod");
						player2.setForeground(Color.black);
						player1.setForeground(Color.red);
						p1plz = true;
						if( Integer.parseInt(p2score.getText()) == 0) {p1plz=false;}
						dartcount = 3;
						dart.setText(Integer.toString(dartcount));
						txtScored.setText(null);
						break;
					default:
						JOptionPane.showMessageDialog(btnThrow, "Nincs több dobásod");
						break;
					}
				}
				}


				int wins = 0;
				
				try {
					Statement stm1 = (Statement) kon.createStatement();
									
				
				if( Integer.parseInt(p1score.getText()) == 0 && decider.equals("Szimpla")) {
					JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player1.getText() + " a gyõztes!!!");
					stm1 = (Statement) kon.createStatement();

					ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player1N+"'");
					while (rs3.next()) {
						wins = rs3.getInt(1);
					}
					wins++;

					
					PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player1N+"'");		
					ps1.setInt(1, wins);
					ps1.execute();
					dispose();
				}

				if( Integer.parseInt(p2score.getText()) == 0 && decider.equals("Szimpla")) {
					JOptionPane.showMessageDialog(btnThrow, "Gratulálok "+ player2.getText() + " a gyõztes!!!");
					
					stm1 = (Statement) kon.createStatement();
					ResultSet rs3 = stm1.executeQuery("SELECT `jatekosok`.`Gyozelmek` FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE '"+player2N+"'");
					while (rs3.next()) {
						wins = rs3.getInt(1);
					}
					wins++;
					
					PreparedStatement ps1 = kon.prepareStatement("UPDATE `jatekosok` SET `Gyozelmek`= ? WHERE Név LIKE '"+player2N+"'");		

					ps1.setInt(1, wins);
					ps1.execute();
					dispose();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//csinald meg a statisztika frissitest
				//update statement execution for database storage of stats of players
				
				//sql: SELECT * FROM `jatekosok` WHERE `jatekosok`.`Név` LIKE "ilyentutinincs";
				
			}
		});
		
		btnThrow.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnThrow.setBounds(320, 37, 86, 29);
		contentPane.add(btnThrow);
		
		
		p1score.setFont(new Font("Calibri", Font.PLAIN, 20));
		p1score.setBounds(82, 60, 68, 56);
		contentPane.add(p1score);
		
		
		p2score.setFont(new Font("Calibri", Font.PLAIN, 20));
		p2score.setBounds(82, 168, 68, 56);
		contentPane.add(p2score);
		
		
		dart.setFont(new Font("Calibri", Font.PLAIN, 20));
		dart.setBounds(371, 196, 56, 56);
		contentPane.add(dart);
		recom.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		recom.setFont(new Font("Calibri", Font.PLAIN, 20));
		recom.setBounds(216, 76, 174, 56);
		contentPane.add(recom);
		
		
		player1.setFont(new Font("Calibri", Font.BOLD, 20));
		player1.setBounds(27, 36, 123, 43);
		contentPane.add(player1);
		
		
		player2.setFont(new Font("Calibri", Font.BOLD, 20));
		player2.setBounds(27, 150, 123, 43);
		contentPane.add(player2);
		
		JLabel lblHtralvDobsok = new JLabel("H\u00E1tral\u00E9v\u0151 dob\u00E1sok:");
		lblHtralvDobsok.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblHtralvDobsok.setBounds(197, 196, 174, 56);
		contentPane.add(lblHtralvDobsok);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(172, 11, 2, 241);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(172, 11, 255, 2);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(425, 11, 2, 241);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(172, 250, 255, 2);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(2, 11, 2, 241);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(160, 11, 2, 241);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(2, 11, 160, 2);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(2, 250, 160, 2);
		contentPane.add(panel_7);
		
		JLabel lblPonszm = new JLabel("Ponsz\u00E1m:");
		lblPonszm.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPonszm.setBounds(8, 78, 77, 20);
		contentPane.add(lblPonszm);
		
		JLabel label = new JLabel("Ponsz\u00E1m:");
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(8, 186, 77, 20);
		contentPane.add(label);
		
		setVisible(true);
		repaint();
		validate();
	}
}
