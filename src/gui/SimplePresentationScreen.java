package gui;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField LU;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField email;
	private JTextField gitHubURL;
	private JLabel date;
	private JLabel studentPhoto;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(650, 265));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal datas
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 198);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 10, 30, 25);
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 40, 50, 25);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabInformation.add(lblApellido);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 100, 50, 25);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabInformation.add(lblEmail);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 70, 80, 25);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabInformation.add(lblNombre);
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setBounds(10, 130, 80, 25);
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabInformation.add(lblGithubUrl);
		
		LU = new JTextField();
		LU.setBounds(95, 15, 320, 20);
		tabInformation.add(LU);
		LU.setColumns(10);
		LU.setText(((Integer) studentData.getId()).toString());
		
		lastName = new JTextField();
		lastName.setBounds(95, 45, 320, 20);
		lastName.setColumns(10);
		tabInformation.add(lastName);
		lastName.setText(studentData.getLastName());
		
		firstName = new JTextField();
		firstName.setBounds(95, 75, 320, 20);
		firstName.setColumns(10);
		tabInformation.add(firstName);
		firstName.setText(studentData.getFirstName());
		
		email = new JTextField();
		email.setBounds(95, 105, 320, 20);
		email.setColumns(10);
		tabInformation.add(email);
		email.setText(studentData.getMail());
		
		gitHubURL = new JTextField();
		gitHubURL.setBounds(95, 135, 320, 20);
		gitHubURL.setColumns(10);
		tabInformation.add(gitHubURL);
		contentPane.add(tabbedPane);
		gitHubURL.setText(studentData.getGithubURL());
		
		date = new JLabel("");
		date.setFont(new Font("Tahoma", Font.BOLD, 10));
		date.setBounds(15, 200, 430, 30);
		contentPane.add(date);
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		date.setText("Esta ventana fue generada el día: " + day.format (currentDate) + " a las "+ time.format(currentDate));
		
		studentPhoto = new JLabel("");
		studentPhoto.setBounds(450, 30, 180, 180);
		ImageIcon image = new ImageIcon (this.getClass().getResource(studentData.getPathPhoto()));
		ImageIcon resizeImage = new ImageIcon (image.getImage().getScaledInstance (studentPhoto.getWidth(), studentPhoto.getHeight(), Image.SCALE_DEFAULT));
        studentPhoto.setIcon(resizeImage);
        contentPane.add(studentPhoto);
		
	}
}
