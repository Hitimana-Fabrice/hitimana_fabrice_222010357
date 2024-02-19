package mainmenu;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import all_forms.*;

public class MenuForm extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu AppointmentMenu;
    private JMenu DietlogMenu;
    private JMenu ExcercisMenu;
    private JMenu PatientMenu;
    private JMenu UserMenu;
    private JMenu HealthyrecordMenu;
    private JMenu MedicationMenu;
    private JMenu logoutMenu;

    private JMenuItem AppointmentItem;
    private JMenuItem DietlogItem;
    private JMenuItem ExcercisItem;
    private JMenuItem PatientItem;
    private JMenuItem UserItem;
    private JMenuItem HealthyrecordItem;
    private JMenuItem MedicationItem;
    private JMenuItem logoutItem;

    private String loggedInUser;

    public MenuForm(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create menu items
        AppointmentMenu = new JMenu("APPOITMENT");
        AppointmentItem = new JMenuItem("Appointment Form");
        AppointmentItem.addActionListener(this);

        DietlogMenu = new JMenu("DIETLOG");
        DietlogItem = new JMenuItem("Dietlog Form");
        DietlogItem.addActionListener(this);

        ExcercisMenu = new JMenu("EXCERCIS");
        ExcercisItem = new JMenuItem("EXCERCIS Form");
        ExcercisItem.addActionListener(this);

        PatientMenu = new JMenu("PATIENT");
        PatientItem = new JMenuItem("Patient Form");
        PatientItem.addActionListener(this);

        UserMenu = new JMenu("User");
        UserItem = new JMenuItem("User Form");
        UserItem.addActionListener(this);
        
        HealthyrecordMenu = new JMenu("HEALTHYRECORD");
        HealthyrecordItem = new JMenuItem("Healthyrecord Form");
        HealthyrecordItem.addActionListener(this);

        MedicationMenu = new JMenu("MEDICATION");
        MedicationItem = new JMenuItem("Medication Form");
        MedicationItem.addActionListener(this);


        logoutMenu = new JMenu("LOGOUT");
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to respective menus
        AppointmentMenu.add(AppointmentItem);
        DietlogMenu.add(DietlogItem);
        ExcercisMenu.add(ExcercisItem);
        PatientMenu.add(PatientItem);
        UserMenu.add(UserItem);
        MedicationMenu.add(MedicationItem);
        HealthyrecordMenu.add(HealthyrecordItem);
        logoutMenu.add(logoutItem);

        // Add menus to menu bar
        menuBar.add(AppointmentMenu);
        menuBar.add(DietlogMenu);
        menuBar.add(ExcercisMenu);
        menuBar.add(PatientMenu);
        menuBar.add(UserMenu);
        menuBar.add(MedicationItem);
        menuBar.add(HealthyrecordItem);
        menuBar.add(logoutMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME"+loggedInUser+"TO THE smart_health_management_system");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AppointmentItem) {
            new AppointmentForms();
        } else if (e.getSource() == DietlogItem) {
            new DietlogForms();
        } else if (e.getSource() == ExcercisItem) {
            new ExcercisForms();
        } else if (e.getSource() == PatientItem) {
            new FormPatient();
        } else if (e.getSource() == UserItem) {
            new UserForm();
        } else if (e.getSource() == MedicationItem) {
            new MedicationlogForm();
        } else if (e.getSource() == HealthyrecordItem) {
            new HealthyrecordForms();
       
        }else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new MenuForm("TO THE  smart_health_management_system"));
    	
    }
}
