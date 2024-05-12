package iostream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class iostream2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton fileSize;
	private JTextArea textArea;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iostream2 frame = new iostream2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public iostream2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(99, 10, 327, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PATH :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 82, 43);
		contentPane.add(lblNewLabel);
		
		fileSize = new JButton("DELETE");
		fileSize.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fileSize.setBounds(311, 63, 115, 43);
		contentPane.add(fileSize);
		
		textArea = new JTextArea();
		textArea.setBounds(99, 63, 202, 43);
		contentPane.add(textArea);
		
		lblStatus = new JLabel("STATUS :");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(10, 63, 82, 43);
		contentPane.add(lblStatus);
		
		fileSize.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("DELETE")) {
			textArea.setText("");
			if(deleteFile(textField.getText()) == true)
					textArea.append("deleted successfully");
			else
				textArea.append("deleted failed");
			
		}
	}
	
	public static boolean deleteFile(String filename) {
		  File file = new File(filename);
		  if(file.isFile() || file.isDirectory())
			  {
			  	file.delete();
			  	return true;
			  }
		return false;
	   }
}
