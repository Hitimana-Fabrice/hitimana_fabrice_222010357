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
import javax.swing.JTextField;
import all_objects.Appointments;

public class AppointmentForms implements ActionListener {
    JFrame frame;
    JLabel id_lb = new JLabel("Appointments_id");
    JLabel name_lb = new JLabel("User_id");
    JLabel seek_lb = new JLabel("DoctorName");
    JLabel email_lb = new JLabel("AppointmentDate");
    JLabel age_lb = new JLabel("AppointmentTime");
    JLabel cont_lb = new JLabel("Purpose");

    JTextField id_txf = new JTextField();
    JTextField name_txf = new JTextField();
    JTextField seek_txf = new JTextField(); // Changed from pass_txf to seek_txf
    JTextField email_txf = new JTextField();
    JTextField age_txf = new JTextField();
    JTextField cont_txf = new JTextField();

    JButton insert_btn = new JButton("Insert");
    JButton view_btn = new JButton("View");
    JButton update_btn = new JButton("Update");
    JButton delete_btn = new JButton("Delete");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screenSize.getWidth();
    int h = (int) screenSize.getHeight();

    public AppointmentForms() {
        createForm();
    }

    private void addActionListeners() {
        insert_btn.addActionListener(this);
        view_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this); // Added ActionListener for delete_btn
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("APPOINTMENT FORM");
        frame.setBounds(10, 10, 500, 400);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        setLocationAndSize();
    }

    private void setLocationAndSize() {
    	  id_lb.setBounds(10, 10, 100, 30);
	        name_lb.setBounds(10, 50, 100, 30);
	        seek_lb.setBounds(10, 90, 100, 30);
	        email_lb.setBounds(10, 130, 100, 30);
	        age_lb.setBounds(10, 170, 100, 30);
	        cont_lb.setBounds(10, 210, 100, 30);
	        
	      
	        
	       

	        id_txf.setBounds(160, 10, 130, 30);
	        name_txf.setBounds(160, 50, 130, 30);
	        seek_txf.setBounds(160, 90, 130, 30);
	        email_txf.setBounds(160, 130, 130, 30);
	        age_txf.setBounds(160, 170, 130, 30);
	        cont_txf.setBounds(160, 210, 130, 30);
	        
	        insert_btn.setBounds(10, 250, 85, 30);
	        view_btn.setBounds(100, 250, 85, 30);
	        update_btn.setBounds(190, 250, 85, 30);
	        delete_btn.setBounds(280, 250, 85, 30);
	        setFontForAll();
	        addComponentsToFrame();
    }

    private void setFontForAll() {
    	   Font font = new Font("Georgia", Font.BOLD, 18);

	        id_lb.setFont(font);
	        name_lb.setFont(font);
	        seek_lb.setFont(font);
	        email_lb.setFont(font);
	        age_lb.setFont(font);
	        cont_lb.setFont(font);
	        
	      

	        id_txf.setFont(font);
	        name_txf.setFont(font);
	        seek_txf.setFont(font);
	        email_txf.setFont(font);
	        age_txf.setFont(font);
	        cont_txf.setFont(font);
	       

	        Font fonti = new Font("Courier New", Font.BOLD, 12);

	        insert_btn.setFont(fonti);
	        view_btn.setFont(fonti);
	        update_btn.setFont(fonti);
	        delete_btn.setFont(fonti);
    }

    private void addComponentsToFrame() {
        frame.add(id_lb);
        frame.add(name_lb);
        frame.add(seek_lb);
        frame.add(email_lb);
        frame.add(age_lb);
        frame.add(cont_lb);
       
       

        frame.add(id_txf);
        frame.add(name_txf);
        frame.add(seek_txf);
        frame.add(email_txf);
        frame.add(age_txf);
        frame.add(cont_txf);
       

        frame.add(insert_btn);
        frame.add(view_btn);
        frame.add(update_btn);
        frame.add(delete_btn);

        addActionListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Appointments appo = new Appointments();
        if (e.getSource() == insert_btn) {
        	 appo.setUser_id(name_txf.getText());
        	 appo.setDoctorName(email_txf.getText());
        	 appo.setAppointmentDate(email_txf.getText());
        	 appo.setAppointmentTime(age_txf.getText());
        	 appo.setPurpose(cont_txf.getText());
        	 appo.insertData();
        } else if (e.getSource() == view_btn) {
        	 int id = Integer.parseInt(id_txf.getText());
	            appo.readWithAppointments_id(id);
	            id_txf.setText(String.valueOf(appo.getAppointments_id()));
	            name_txf.setText(appo.getUser_id());
	            seek_txf.setText(appo.getDoctorName());
	            email_txf.setText(appo.getAppointmentDate());
	             age_txf.setText(appo.getAppointmentTime());
		            cont_txf.setText(appo.getPurpose());
        } else if (e.getSource() == update_btn) {
        	 int id = Integer.parseInt(id_txf.getText());
	            appo.setUser_id(name_txf.getText());
	        	 appo.setDoctorName(seek_txf.getText());
	        	 appo.setAppointmentDate(email_txf.getText());
	        	 appo.setAppointmentTime(age_txf.getText());
	        	 appo.setPurpose(cont_txf.getText());
	        	 appo.update(id);
        } else if (e.getSource() == delete_btn) {
        	 int id = Integer.parseInt(id_txf.getText());
	            appo.delete(id);
        }
    }

    public static void main(String[] args) {
        AppointmentForms appointmentForm = new AppointmentForms();
        System.out.println(appointmentForm);
    }
}

