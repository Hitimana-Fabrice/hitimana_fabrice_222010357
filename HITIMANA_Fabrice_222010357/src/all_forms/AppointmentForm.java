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
import all_objects.*;
public class AppointmentForm  implements ActionListener {
					    JFrame frame;
					    JLabel id_lb = new JLabel("Appointments_id");
					    JLabel name_lb = new JLabel("User_id");
					    JLabel seek_lb = new JLabel("DoctorName");
					    JLabel email_lb = new JLabel("AppointmentDate");
					    JLabel age_lb = new JLabel("AppointmentTime");
					    JLabel cont_lb = new JLabel("Purpose");
					   
				//text
					    JTextField id_txf = new JTextField();
					    JTextField name_txf = new JTextField();
					    JTextField pass_txf = new JTextField();
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

					    public AppointmentForm() {
					        createForm();
					    }

					    private void addActionListeners() {
					        insert_btn.addActionListener(this);
					        view_btn.addActionListener(this);
					        update_btn.addActionListener(this);
					        delete_btn.addActionListener(this);
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
					        pass_txf.setBounds(160, 90, 130, 30);
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
					        pass_txf.setFont(font);
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
					        frame.add(pass_txf);
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
					        Appointments user=new Appointments();
					        if (e.getSource() == insert_btn) {
					        	 user.setUser_id(pass_txf.getText());
					            user.setDoctorName(email_txf.getText());
					            user.setAppointmentDate(email_txf.getText());
					            user.setAppointmentTime(age_txf.getText());
					            user.setPurpose(cont_txf.getText());
	                            user.insertData();
					        } else if (e.getSource() == view_btn) {
					            int id = Integer.parseInt(id_txf.getText());
					            user.readWithAppointments_id(id);
					            id_txf.setText(String.valueOf(user.getAppointments_id()));
					            name_txf.setText(user.getUser_id());
					            pass_txf.setText(user.getAppointmentDate());
					            email_txf.setText(user.getAppointmentDate());
					             age_txf.setText(user.getAppointmentTime());
						            cont_txf.setText(user.getPurpose());
						            } else if (e.getSource() == update_btn) {
					            int id = Integer.parseInt(id_txf.getText());
					       	 user.setUser_id(pass_txf.getText());
					            user.setDoctorName(email_txf.getText());
					            user.setAppointmentDate(email_txf.getText());
					            user.setAppointmentTime(age_txf.getText());
					            user.setPurpose(cont_txf.getText());
					            user.update(id);
					        } else {
					            int id = Integer.parseInt(id_txf.getText());
					            user.delete(id);
					        }
					    }

					    public static void main(String[] args) {
					    	AppointmentForm  appointmentForm  = new AppointmentForm ();
					        System.out.println(appointmentForm );
					    }
					}



