package all_forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import all_objects.Patient;


public class FormPatient implements ActionListener {
    private JFrame frame;
    private JLabel idLabel = new JLabel("Patients ID:");
    private JLabel firstNameLabel = new JLabel("First Name:");
    private JLabel lastNameLabel = new JLabel("Last Name:");
    private JLabel dobLabel = new JLabel("Date of Birth:");

    private JTextField idField = new JTextField();
    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    private JTextField dobField = new JTextField();

    private JButton insertButton = new JButton("Insert");
    private JButton viewButton = new JButton("View");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screenSize.getWidth();
    int h = (int) screenSize.getHeight();

    public FormPatient() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Patient Form");
        frame.setBounds(100, 100, 400, 300);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        setLocationAndSize();
        addComponentsToFrame();
        addActionListeners();
        setFontForAll() ;
    }

    private void setLocationAndSize() {
    	idLabel.setBounds(10, 10, 100, 30);
    	firstNameLabel.setBounds(10, 50, 100, 30);
    	lastNameLabel.setBounds(10, 90, 100, 30);
    	dobLabel.setBounds(10, 130, 100, 30);
	        
    	idField.setBounds(160, 10, 130, 30);
    	firstNameField.setBounds(160, 50, 130, 30);
    	lastNameField.setBounds(160, 90, 130, 30);
    	dobField .setBounds(160, 130, 130, 30);
	        
    	insertButton.setBounds(10, 170, 85, 30);
    	 viewButton.setBounds(100, 170, 85, 30);
    	 updateButton.setBounds(190, 170, 85, 30);
    	 deleteButton.setBounds(280, 170, 85, 30);
    }
    private void setFontForAll() {
        Font font = new Font("Georgia", Font.BOLD, 18); 
        idLabel.setFont(font);
        firstNameLabel.setFont(font);
        lastNameLabel.setFont(font);
        dobLabel.setFont(font);
        
        idField.setFont(font);
        firstNameField.setFont(font);
        lastNameField.setFont(font);
        dobField.setFont(font);
        //buton
        Font fonti = new Font("Courier New", Font.BOLD, 12);

        insertButton.setFont(fonti);
        viewButton.setFont(fonti);
        updateButton.setFont(fonti);
        deleteButton.setFont(fonti);
    }

    private void addComponentsToFrame() {
        frame.add(idLabel);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(dobLabel);
        //text
        frame.add(idField);
        frame.add(firstNameField);
        frame.add(lastNameField);
        frame.add(dobField);
        //button
        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        addActionListeners();
    }
    private void addActionListeners() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Patient patient = new Patient();
        try {
            int id = Integer.parseInt(idField.getText());
            patient.setPatients_id(id);
            patient.setPatient_F_Name(firstNameField.getText());
            patient.setPatient_l_Name(lastNameField.getText());
            patient.setPatient_BOB_Date(dobField.getText());

            if (e.getSource() == insertButton) {
                patient.insertData();
            } else if (e.getSource() == viewButton) {
                patient.readWithPatients_id(id);
                firstNameField.setText(patient.getPatient_F_Name());
                lastNameField.setText(patient.getPatient_l_Name());
                dobField.setText(patient.getPatient_BOB_Date());
            } else if (e.getSource() == updateButton) {
                patient.update(id);
            } else if (e.getSource() == deleteButton) {
                patient.delete(id);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new FormPatient();
    }
}

