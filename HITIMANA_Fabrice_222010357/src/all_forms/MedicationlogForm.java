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
public class MedicationlogForm  implements ActionListener {
								    JFrame frame;
								    JLabel id_lb = new JLabel("Medical_id");
								    JLabel user_lb = new JLabel("User_id");
								    JLabel dat_lb = new JLabel("Date");
								    JLabel name_lb = new JLabel("MedicationName");
								    JLabel dase_lb = new JLabel("Dosage");
								    JLabel fre_lb = new JLabel("Frequency");
								    
							//text
								    JTextField id_txf = new JTextField();
								    JTextField use_txf = new JTextField();
								    JTextField dat_txf = new JTextField();
								    JTextField name_txf = new JTextField();
								    JTextField dase_txf = new JTextField();
								    JTextField fre_txf = new JTextField();
								  

								    JButton insert_btn = new JButton("Insert");
								    JButton view_btn = new JButton("View");
								    JButton update_btn = new JButton("Update");
								    JButton delete_btn = new JButton("Delete");

								    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
								    int w = (int) screenSize.getWidth();
								    int h = (int) screenSize.getHeight();

								    public MedicationlogForm() {
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
								        frame.setTitle("MEDICATIONLOG FORM");
								        frame.setBounds(10, 10, 400, 350);
								        frame.getContentPane().setLayout(null);
								        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
								        frame.setVisible(true);
								        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								        frame.setResizable(true);
								        setLocationAndSize();
								    }

								    private void setLocationAndSize() {
								        id_lb.setBounds(10, 10, 100, 30);
								        dat_lb.setBounds(10, 50, 100, 30);
								        name_lb.setBounds(10, 90, 100, 30);
								        dase_lb.setBounds(10, 130, 100, 30);
								        fre_lb.setBounds(10, 170, 100, 30);
								        user_lb.setBounds(10, 210, 100, 30);
								        
								      
								        
								       

								        id_txf.setBounds(160, 10, 130, 30);
								        dat_txf.setBounds(160, 50, 130, 30);
								        name_txf.setBounds(160, 90, 130, 30);
								        dase_txf.setBounds(160, 130, 130, 30);
								        fre_txf.setBounds(160, 170, 130, 30);
								        use_txf.setBounds(160, 210, 130, 30);
								       
								        
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
								        dat_lb.setFont(font);
								        name_lb.setFont(font);
								        dase_lb.setFont(font);
								        fre_lb.setFont(font);
								        user_lb.setFont(font);
								       
								      

								        id_txf.setFont(font);
								        dat_txf.setFont(font);
								        dase_txf.setFont(font);
								        name_txf.setFont(font);
								        fre_txf.setFont(font);
								        use_txf.setFont(font);
								       

								        Font fonti = new Font("Courier New", Font.BOLD, 12);

								        insert_btn.setFont(fonti);
								        view_btn.setFont(fonti);
								        update_btn.setFont(fonti);
								        delete_btn.setFont(fonti);
								    }

								    private void addComponentsToFrame() {
								        frame.add(id_lb);
								        frame.add(name_lb);
								        frame.add(user_lb);
								        frame.add(dase_lb);
								        frame.add(dat_lb);
								        frame.add(fre_lb);
								      
								       
								       

								        frame.add(id_txf);
								        frame.add(name_txf);
								        frame.add(fre_txf);
								        frame.add(use_txf);
								        frame.add(dase_txf);
								        frame.add(dat_txf);
								     

								        frame.add(insert_btn);
								        frame.add(view_btn);
								        frame.add(update_btn);
								        frame.add(delete_btn);

								        addActionListeners();
								    }

								    @Override
								    public void actionPerformed(ActionEvent e) {
								    	Medicallogs user=new Medicallogs();
								        if (e.getSource() == insert_btn) {
								        	 user.setUser_id(use_txf.getText());
								            user.setDate(dat_txf.getText());
								            user.setMedicationName(name_txf.getText());
								            user.setDosage(dase_txf.getText());
								            user.setFrequency(fre_txf.getText());
								          
				                            user.insertData();
								        } else if (e.getSource() == view_btn) {
								            int id = Integer.parseInt(id_txf.getText());
								            user.readWithMedicallog_id(id);
								            id_txf.setText(String.valueOf(user.getMedicallog_id()));
								            use_txf.setText(user.getUser_id());
								            dat_txf.setText(user.getDate());
								            name_txf.setText(user.getMedicationName());
								             dase_txf.setText(user.getDosage());
									            fre_txf.setText(user.getFrequency());
									            
									            } else if (e.getSource() == update_btn) {
								            int id = Integer.parseInt(id_txf.getText());
								       	 user.setUser_id(use_txf.getText());
								            user.setDate(dat_txf.getText());
								            user.setMedicationName(name_txf.getText());
								            user.setDosage(dase_txf.getText());
								            user.setFrequency(fre_txf.getText());
								           
								            user.update(id);
								        } else {
								            int id = Integer.parseInt(id_txf.getText());
								            user.delete(id);
								        }
								    }

								    public static void main(String[] args) {
								    	MedicationlogForm  logForm  = new MedicationlogForm();
								        System.out.println(logForm);
								    }
								}







