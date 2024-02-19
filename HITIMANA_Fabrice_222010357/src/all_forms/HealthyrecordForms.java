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
public class HealthyrecordForms  implements ActionListener {
							    JFrame frame;
							    JLabel id_lb = new JLabel("RecordID");
							    JLabel name_lb = new JLabel("User_id");
							    JLabel seek_lb = new JLabel("Date");
							    JLabel email_lb = new JLabel("Height");
							    JLabel age_lb = new JLabel("Weight");
							    JLabel cont_lb = new JLabel("BloodPressureSystolic");
							    JLabel col_lb = new JLabel("BloodPressureDiastolic");
							    JLabel rate_lb = new JLabel("HeartRate");
							    JLabel sug_lb = new JLabel("BloodSugarLevel");
							    JLabel chol_lb = new JLabel("CholesterolLevel");
						//text
							    JTextField id_txf = new JTextField();
							    JTextField name_txf = new JTextField();
							    JTextField pass_txf = new JTextField();
							    JTextField email_txf = new JTextField();
							    JTextField age_txf = new JTextField();
							    JTextField cont_txf = new JTextField();
							    JTextField col_txf = new JTextField();
							    JTextField rate_txf = new JTextField();
							    JTextField sug_txf = new JTextField();
							    JTextField chol_txf = new JTextField();

							    JButton insert_btn = new JButton("Insert");
							    JButton view_btn = new JButton("View");
							    JButton update_btn = new JButton("Update");
							    JButton delete_btn = new JButton("Delete");

							    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							    int w = (int) screenSize.getWidth();
							    int h = (int) screenSize.getHeight();

							    public HealthyrecordForms() {
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
							        frame.setTitle("HEALTHYRECORD FORM");
							        frame.setBounds(10, 10, 600, 500);
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
							        col_lb.setBounds(10, 250, 100, 30);
							        rate_lb.setBounds(10, 290, 100, 30);
							        sug_lb.setBounds(10, 330, 100, 30);
							        chol_lb.setBounds(10, 370, 100, 30);
							      
							        id_txf.setBounds(160, 10, 130, 30);
							        name_txf.setBounds(160, 50, 130, 30);
							        pass_txf.setBounds(160, 90, 130, 30);
							        email_txf.setBounds(160, 130, 130, 30);
							        age_txf.setBounds(160, 170, 130, 30);
							        cont_txf.setBounds(160, 210, 130, 30);
							        col_txf.setBounds(160, 250, 130, 30);
							        rate_txf.setBounds(160, 290, 130, 30);
							        sug_txf.setBounds(160, 330, 130, 30);
							        chol_txf.setBounds(160, 370, 130, 30);
							        
							        insert_btn.setBounds(10, 410, 85, 30);
							        view_btn.setBounds(100, 410, 85, 30);
							        update_btn.setBounds(190, 410, 85, 30);
							        delete_btn.setBounds(280, 410, 85, 30);

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
							        col_lb.setFont(font);
							        rate_lb.setFont(font);
							        sug_lb.setFont(font);
							        chol_lb.setFont(font);
							      

							        id_txf.setFont(font);
							        name_txf.setFont(font);
							        pass_txf.setFont(font);
							        email_txf.setFont(font);
							        age_txf.setFont(font);
							        cont_txf.setFont(font);
							        col_txf.setFont(font);
							        rate_txf.setFont(font);
							        sug_txf.setFont(font);
							        chol_txf.setFont(font);

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
							        frame.add(col_lb);
							        frame.add(rate_lb);
							        frame.add(sug_lb);
							        frame.add(chol_lb);
							        
							        frame.add(id_txf);
							        frame.add(name_txf);
							        frame.add(pass_txf);
							        frame.add(email_txf);
							        frame.add(age_txf);
							        frame.add(cont_txf);
							        frame.add(col_txf);
							        frame.add(rate_txf);
							        frame.add(sug_txf);
							        frame.add(chol_txf);
							       
							        frame.add(insert_btn);
							        frame.add(view_btn);
							        frame.add(update_btn);
							        frame.add(delete_btn);
							        addActionListeners();
							    }
							    @Override
							    public void actionPerformed(ActionEvent e) {
							        Healthyrecord user = new Healthyrecord(); // Create a single instance
							        
							        if (e.getSource() == insert_btn) {
							            user.setUser_id(name_txf.getText());
							            user.setDate(pass_txf.getText()); // Correct assignment for date
							            user.setHeight(email_txf.getText()); // Correct assignment for height
							            user.setWeight(age_txf.getText());
							            user.setBloodPressureSystolic(cont_txf.getText());
							            user.setBloodPressureDiastolic(col_txf.getText());
							            user.setHeartRate(rate_txf.getText());
							            user.setBloodSugarLevel(sug_txf.getText());
							            user.setCholesterolLevel(chol_txf.getText());
							            user.insertData(); // Correct method name
							        } else if (e.getSource() == view_btn) {
							            int id = Integer.parseInt(id_txf.getText());
							            user.readWithRecordID(id);
							            id_txf.setText(String.valueOf(user.getRecordID()));
							            name_txf.setText(user.getUser_id());
							            pass_txf.setText(user.getDate());
							            email_txf.setText(user.getHeight());
							            age_txf.setText(user.getWeight());
							            cont_txf.setText(user.getBloodPressureSystolic());
							            col_txf.setText(user.getBloodPressureDiastolic());
							            rate_txf.setText(user.getHeartRate());
							            sug_txf.setText(user.getBloodSugarLevel());
							            chol_txf.setText(user.getCholesterolLevel());
							        } else if (e.getSource() == update_btn) {
							            int id = Integer.parseInt(id_txf.getText());
							            user.setUser_id(name_txf.getText());
							            user.setDate(pass_txf.getText()); // Correct assignment for date
							            user.setHeight(email_txf.getText()); // Correct assignment for height
							            user.setWeight(age_txf.getText());
							            user.setBloodPressureSystolic(cont_txf.getText());
							            user.setBloodPressureDiastolic(col_txf.getText());
							            user.setHeartRate(rate_txf.getText());
							            user.setBloodSugarLevel(sug_txf.getText());
							            user.setCholesterolLevel(chol_txf.getText());
							            user.update(id);
							        } else if (e.getSource() == delete_btn) {
							            int id = Integer.parseInt(id_txf.getText());
							            user.delete(id);
							        }
							    }
							    public static void main(String[] args) {
							    	HealthyrecordForms  healthyrecordForm  = new  HealthyrecordForms();
							        System.out.println(healthyrecordForm);
							    }
							}
