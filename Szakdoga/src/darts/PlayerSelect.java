package darts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PlayerSelect extends JFrame {

	private JPanel contentPane;
	public JLabel lblPlayer = new JLabel("J\u00C1T\u00C9KOSV\u00C1LASZT\u00C1S");
	public int x = 1;
	public boolean finished = false;

	public PlayerSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 163);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox PlayerList = new JComboBox();
		
		PlayerList.setFont(new Font("Calibri", Font.PLAIN, 16));
		PlayerList.setBounds(12, 46, 199, 27);
		contentPane.add(PlayerList);
		
		JButton btnOk = new JButton("OK");
		
		Connection kon =new ConnectorDB().getCon();
		PreparedStatement ps;
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
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OK CLICKED
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
							finished = true;
							dispose();
						}
				
				
			}
		});
		btnOk.setBackground(Color.WHITE);
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnOk.setBounds(67, 90, 89, 23);
		contentPane.add(btnOk);
		
		
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(10, 11, 201, 23);
		contentPane.add(lblPlayer);
		setVisible(true);
		repaint();
		validate();
	}

}
