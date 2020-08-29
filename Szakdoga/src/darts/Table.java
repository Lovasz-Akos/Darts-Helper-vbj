package darts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.Statement;

public class Table extends JFrame {
	
	

	private JPanel contentPane;
	private JTable table;

	public Table() {
		
		setTitle("Statisztika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNew = new JButton("\u00DAj J\u00E1t\u00E9kos");
		btnNew.setBackground(new Color(0, 204, 102));
		btnNew.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//new player
				JFrame frame = new JFrame("Input");
				String name = JOptionPane.showInputDialog(frame, "Add meg a játékos nevét");
				while (name.length() == 0) {
					JOptionPane.showMessageDialog(frame, "Nem adtál meg semmit!");
					name = JOptionPane.showInputDialog(frame, "Add meg a játékos nevét");
				}
				Connection con=new ConnectorDB().getCon();
				try {
					PreparedStatement ps = con.prepareStatement("INSERT INTO `jatekosok` VALUES (?,?,?)");
					
					ps.setString(1,null);
					ps.setString(2,name);
					ps.setString(3,"0");
					ps.execute();
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(btnNew, "SQL Hiba");
					e1.printStackTrace();
				}
				
			}
		});
		btnNew.setBounds(185, 11, 111, 27);
		contentPane.add(btnNew);
		
		JButton btnCancel = new JButton("Vissza");
		btnCancel.setBackground(new Color(0, 204, 102));
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//mégse
				dispose();
			}
		});
		btnCancel.setBounds(333, 11, 111, 27);
		contentPane.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(13, 47, 455, 10);
		contentPane.add(separator);
		
		JButton buttonRefresh = new JButton("Friss\u00EDt\u00E9s");
		buttonRefresh.setBackground(new Color(0, 204, 102));
		buttonRefresh.setFont(new Font("Calibri", Font.BOLD, 18));
		buttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=new ConnectorDB().getCon();
				try {
					Statement stm = (Statement) con.createStatement();
					ResultSet rs = stm.executeQuery("SELECT * FROM `jatekosok`");
					int sorszam = table.getModel().getRowCount();
					for (int i = sorszam-1; i >= 0; i--) {
						((DefaultTableModel)table.getModel()).removeRow(i);
					}
					while (rs.next()) {
						((DefaultTableModel)table.getModel()).addRow(new Object[] {
								rs.getString(2),
								rs.getString(3)
						});
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(buttonRefresh, "SQL Hiba");
					e1.printStackTrace();
				}
			}
		});
		
		buttonRefresh.setBounds(37, 11, 111, 27);
		contentPane.add(buttonRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Calibri", Font.PLAIN, 20));
		scrollPane.setMinimumSize(new Dimension(150, 23));
		scrollPane.setSize(new Dimension(14, 0));
		scrollPane.setPreferredSize(new Dimension(10, 2));
		scrollPane.setBounds(13, 68, 455, 263);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0, 204, 102));
		scrollPane.setViewportView(table);
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setShowVerticalLines(false);
		table.setBorder(UIManager.getBorder("Spinner.border"));
		table.setFillsViewportHeight(true);
		table.setAutoscrolls(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00E9v", "Gyõzelmek"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNew, buttonRefresh, btnCancel, table}));
		setVisible(true);
		repaint();
		validate();
	}
}
