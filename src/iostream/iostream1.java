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

public class iostream1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton fileSize;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iostream1 frame = new iostream1();
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
	public iostream1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 197);
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
		
		fileSize = new JButton("get file's size");
		fileSize.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fileSize.setBounds(10, 113, 106, 37);
		contentPane.add(fileSize);
		
		textArea = new JTextArea();
		textArea.setBounds(99, 63, 327, 43);
		contentPane.add(textArea);
		
		fileSize.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("get file's size")) {
			textArea.setText("");
			String path = textField.getText();
			long fileSize = getFileSize(path);
			if (fileSize == -1)
			textArea.append("wrong File path or File doesn't exist");
			else
			textArea.append("file's Size : " + fileSize);
		}
	}
	
	public static long getFileSize(String filename) {
	      File file = new File(filename);
	      if (!file.exists() || !file.isFile()) 
	         return -1;
	      return file.length();
	   }
	
}
