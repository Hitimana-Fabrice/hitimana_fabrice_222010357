package all_forms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import all_objects.*;
public class UserForm  implements ActionListener {
				    JFrame frame;
				    JLabel id_lb = new JLabel("User_id");
				    JLabel name_lb = new JLabel("Username");
				    JLabel seek_lb = new JLabel("Password");
				    JLabel email_lb = new JLabel("Email");
				    JLabel na_lb = new JLabel("Name");
				    JLabel age_lb = new JLabel("Age");
				    JLabel gender_lb = new JLabel("Gender");
				    JLabel cont_lb = new JLabel("ContactNumber");
				    JLabel add_lb = new JLabel("Address");
				   
			//text
				    JTextField id_txf = new JTextField();
				    JTextField name_txf = new JTextField();
				    JTextField pass_txf = new JTextField();
				    JTextField email_txf = new JTextField();
				    JTextField na_txf = new JTextField();
				    JTextField age_txf = new JTextField();
				    JTextField gend_txf = new JTextField();
				    JTextField add_txf = new JTextField();
				    JTextField cont_txf = new JTextField();
				    
				    String[] gender = { "Male", "Female" };
				    JComboBox<String> genderBox = new JComboBox<>(gender);

				    JButton insert_btn = new JButton("Insert");
				    JButton view_btn = new JButton("View");
				    JButton update_btn = new JButton("Update");
				    JButton delete_btn = new JButton("Delete");

				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    int w = (int) screenSize.getWidth();
				    int h = (int) screenSize.getHeight();

				    public UserForm() {
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
				        frame.setTitle("USER FORM");
				        frame.setBounds(10, 10, 700, 400);
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
				        na_lb.setBounds(10, 170, 100, 30);
				        age_lb.setBounds(10, 210, 100, 30);
				        gender_lb.setBounds(10, 250, 100, 30);
				        cont_lb.setBounds(10, 290, 100, 30);
				        add_lb.setBounds(10, 330, 100, 30);
				       

				        id_txf.setBounds(160, 10, 130, 30);
				        name_txf.setBounds(160, 50, 130, 30);
				        pass_txf.setBounds(160, 90, 130, 30);
				        email_txf.setBounds(160, 130, 130, 30);
				        na_txf.setBounds(160, 170, 130, 30);
				        age_txf.setBounds(160, 210, 130, 30);
				        genderBox.setBounds(160, 250, 130, 30);
				        cont_txf.setBounds(160, 290, 130, 30);
				        add_txf.setBounds(160, 330, 130, 30);
				        

				        insert_btn.setBounds(10, 370, 85, 30);
				        view_btn.setBounds(100, 370, 85, 30);
				        update_btn.setBounds(190, 370, 85, 30);
				        delete_btn.setBounds(280, 370, 85, 30);

				        setFontForAll();
				        addComponentsToFrame();
				    }

				    private void setFontForAll() {
				        Font font = new Font("Georgia", Font.BOLD, 18);

				        id_lb.setFont(font);
				        name_lb.setFont(font);
				        seek_lb.setFont(font);
				        email_lb.setFont(font);
				        na_lb.setFont(font);
				        age_lb.setFont(font);
				        gender_lb.setFont(font);
				        cont_lb.setFont(font);
				        add_lb.setFont(font);
				      

				        id_txf.setFont(font);
				        name_txf.setFont(font);
				        pass_txf.setFont(font);
				        email_txf.setFont(font);
				        na_txf.setFont(font);
				        age_txf.setFont(font);
				        gend_txf.setFont(font);
				        add_txf.setFont(font);
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
				        frame.add(na_lb);
				        frame.add(age_lb);
				        frame.add(gender_lb);
				        frame.add(cont_lb);
				        frame.add(add_lb);
				       

				        frame.add(id_txf);
				        frame.add(name_txf);
				        frame.add(pass_txf);
				        frame.add(email_txf);
				        frame.add(na_txf);
				        frame.add(age_txf);
				        frame.add(genderBox);
				        frame.add(add_txf);
				        frame.add(cont_txf);
				       

				        frame.add(insert_btn);
				        frame.add(view_btn);
				        frame.add(update_btn);
				        frame.add(delete_btn);

				        addActionListeners();
				    }

				    @Override
				    public void actionPerformed(ActionEvent e) {
				        Users user=new Users();
				        if (e.getSource() == insert_btn) {
				        	
				            user.setUsername(pass_txf.getText());
				            user.setPassword(email_txf.getText());
				            user.setEmail(email_txf.getText());
				            user.setName(na_txf.getText());
				            user.setAge(age_txf.getText());
				            user.setGender((String) genderBox.getSelectedItem());
				            user.setContactNumber(cont_txf.getText());
				            user.setAddress(add_txf.getText());
				            
				            user.insertData();
				        } else if (e.getSource() == view_btn) {
				            int id = Integer.parseInt(id_txf.getText());
				            user.readWithUserId(id);
				            id_txf.setText(String.valueOf(user.getUserId()));
				            name_txf.setText(user.getUsername());
				            pass_txf.setText(user.getPassword());
				            email_txf.setText(user.getEmail());
				            na_txf.setText(user.getName());
				             age_txf.setText(user.getAge());
				             genderBox.setSelectedItem(user.getGender());
				             add_txf.setText(user.getAddress());
					            cont_txf.setText(user.getContactNumber());
					            } else if (e.getSource() == update_btn) {
				            int id = Integer.parseInt(id_txf.getText());
				            user.setUsername(pass_txf.getText());
				            user.setPassword(email_txf.getText());
				            user.setEmail(email_txf.getText());
				            user.setName(na_txf.getText());
				            user.setAge(age_txf.getText());
				            user.setGender((String) genderBox.getSelectedItem());
				            user.setContactNumber(cont_txf.getText());
				            user.setAddress(add_txf.getText());
				           
				            user.update(id);
				        } else {
				            int id = Integer.parseInt(id_txf.getText());
				            user.delete(id);
				        }
				    }

				    public static void main(String[] args) {
				    	UserForm userForms = new UserForm();
				        System.out.println(userForms);
				    }
				}



