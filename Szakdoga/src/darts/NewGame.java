package darts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class NewGame extends JFrame {

	private JPanel contentPane;
	private JTextField inputCustom;
	public JComboBox PlayerList = new JComboBox();
	public JLabel lblPlayer = new JLabel("V\u00E1laszd ki az 1. j\u00E1t\u00E9kost.");
	public int x = 1;

	public int kezd;
	private JButton btnOK;
	
	public NewGame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				dispose();
			}
		});
		
		
		
		
		Connection kon =new ConnectorDB().getCon();
		Statement stm;
		
		try {
			stm = (Statement) kon.createStatement();
			ResultSet rs = stm.executeQuery("SELECT `Név` FROM `jatekosok`");	
			while(rs.next()) {
			PlayerList.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(PlayerList, "SQL Hiba");
			e1.printStackTrace();
		}

		lblPlayer.setText("Válaszd ki az 1. játékost.");
		
		setTitle("\u00DAj J\u00E1t\u00E9k");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 271, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 11, 214, 9);
		contentPane.add(separator);
		
		
		PlayerList.setBounds(20, 215, 214, 23);
		contentPane.add(PlayerList);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 100, 214, 9);
		contentPane.add(separator_1);
		
		JLabel lblPont = new JLabel("Pont");
		lblPont.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblPont.setBounds(106, 14, 42, 23);
		contentPane.add(lblPont);
		
		JLabel lblNewLabel = new JLabel("Kisz\u00E1ll\u00F3");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblNewLabel.setBounds(94, 111, 67, 23);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdHar = new JRadioButton("301");
		rdHar.setBackground(new Color(153, 204, 51));
		rdHar.setSelected(true);
		rdHar.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdHar.setBounds(21, 44, 57, 23);
		contentPane.add(rdHar);
		
		JRadioButton rdOt = new JRadioButton("501");
		rdOt.setBackground(new Color(153, 204, 51));
		rdOt.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdOt.setBounds(99, 44, 57, 23);
		contentPane.add(rdOt);
		
		JRadioButton rdHet = new JRadioButton("701");
		rdHet.setBackground(new Color(153, 204, 51));
		rdHet.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdHet.setBounds(177, 44, 57, 23);
		contentPane.add(rdHet);
		
		JRadioButton rdCust = new JRadioButton("Egy\u00E9ni:");
		rdCust.setBackground(new Color(153, 204, 51));
		rdCust.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdCust.setBounds(29, 70, 77, 23);
		contentPane.add(rdCust);
		
		inputCustom = new JTextField();
		inputCustom.setBounds(122, 72, 89, 20);
		contentPane.add(inputCustom);
		inputCustom.setColumns(10);
		
		JRadioButton rdSimple = new JRadioButton("Szimpla");
		rdSimple.setBackground(new Color(153, 204, 51));
		rdSimple.setSelected(true);
		rdSimple.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdSimple.setBounds(35, 141, 81, 23);
		contentPane.add(rdSimple);
		
		JRadioButton rdDouble = new JRadioButton("Dupla");
		rdDouble.setBackground(new Color(153, 204, 51));
		rdDouble.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdDouble.setBounds(151, 141, 67, 23);
		contentPane.add(rdDouble);
		
		ButtonGroup starter = new ButtonGroup();
		starter.add(rdHar);
		starter.add(rdOt);
		starter.add(rdHet);
		starter.add(rdCust);
		
		ButtonGroup out = new ButtonGroup();
		out.add(rdDouble);
		out.add(rdSimple);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 251, 214, 9);
		contentPane.add(separator_2);
		
		JButton btnClose = new JButton("M\u00E9gse");
		btnClose.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnClose.setBackground(Color.WHITE);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(139, 271, 89, 23);
		contentPane.add(btnClose);
		
		JButton btnOK;
		btnOK = new JButton("Ok");
		btnOK.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnOK.setBackground(Color.WHITE);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add át a kezdõértékeket
				//Kérd meg hogy ki akar játszani //moved to game start new menupoint
				//moved back to here but in combobox
				
				
				rdCust.setEnabled(false);
				rdDouble.setEnabled(false);
				rdHar.setEnabled(false);
				rdHet.setEnabled(false);
				rdOt.setEnabled(false);
				rdSimple.setEnabled(false);
				
				
				lblPlayer.setText("Válaszd ki a 2. játékost.");
				
				String pN = (String) PlayerList.getSelectedItem();
				System.out.println(pN);
				//UPDATE `helper` SET `player1`=pN
				PreparedStatement ps1;
				try {
					ps1 = kon.prepareStatement("UPDATE `helper` SET `player"+x+"`='"+pN+"'");
					ps1.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				
				x++;
				if(x == 3) {
					dispose();
				}
				
				Connection con=new ConnectorDB().getCon();
				PreparedStatement ps;
				
				String kilep ="";
				
				try {
					Statement stm = (Statement) con.createStatement();
					
					
					
					
					
					if (rdHar.isSelected()) {
						kezd = 301;
					}
					if (rdOt.isSelected()) {
						kezd = 501;
					}
					if (rdHet.isSelected()) {
						kezd = 701;
					}
					if (rdCust.isSelected()) {
						kezd = Integer.parseInt(inputCustom.getText());
					}
					if (rdDouble.isSelected()) {
						kilep = "Dupla";
					}
					if (rdSimple.isSelected()) {
						kilep = "Szimpla";
					}
					
					ps = con.prepareStatement("UPDATE helper SET helper.kezd = (?), helper.kilep = ? WHERE helper.id = 1");
					
					ps.setInt(1, kezd);
					ps.setString(2, kilep);
					
					ps.execute();
					
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnOK.setBounds(25, 271, 89, 23);
		contentPane.add(btnOK);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(20, 171, 214, 9);
		contentPane.add(separator_3);
		
		
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(27, 181, 201, 23);
		contentPane.add(lblPlayer);
		
		

		
		setVisible(true);
		repaint();
		validate();
	}
}
