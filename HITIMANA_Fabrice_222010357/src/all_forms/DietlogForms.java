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
import all_objects.Dietlogs;

public class DietlogForms implements ActionListener {
    JFrame frame;
    JLabel id_lb = new JLabel("LogID");
    JLabel name_lb = new JLabel("User_id");
    JLabel seek_lb = new JLabel("Date");
    JLabel email_lb = new JLabel("MealType");
    JLabel age_lb = new JLabel("FoodItem");
    JLabel cont_lb = new JLabel("Quantity");
    JLabel col_lb = new JLabel("CaloriesConsumed");

    //text fields
    JTextField logId_txf = new JTextField();
    JTextField userId_txf = new JTextField();
    JTextField date_txf = new JTextField();
    JTextField mealType_txf = new JTextField();
    JTextField foodItem_txf = new JTextField();
    JTextField quantity_txf = new JTextField();
    JTextField caloriesConsumed_txf = new JTextField();

    JButton insert_btn = new JButton("Insert");
    JButton view_btn = new JButton("View");
    JButton update_btn = new JButton("Update");
    JButton delete_btn = new JButton("Delete");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screenSize.getWidth();
    int h = (int) screenSize.getHeight();

    public DietlogForms() {
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
        frame.setTitle("DIETLOGS FORM");
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
        col_lb.setBounds(10, 250, 150, 30);

        logId_txf.setBounds(160, 10, 130, 30);
        userId_txf.setBounds(160, 50, 130, 30);
        date_txf.setBounds(160, 90, 130, 30);
        mealType_txf.setBounds(160, 130, 130, 30);
        foodItem_txf.setBounds(160, 170, 130, 30);
        quantity_txf.setBounds(160, 210, 130, 30);
        caloriesConsumed_txf.setBounds(160, 250, 130, 30);

        insert_btn.setBounds(10, 290, 85, 30);
        view_btn.setBounds(100, 290, 85, 30);
        update_btn.setBounds(190, 290, 85, 30);
        delete_btn.setBounds(280, 290, 85, 30);

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

        logId_txf.setFont(font);
        userId_txf.setFont(font);
        date_txf.setFont(font);
        mealType_txf.setFont(font);
        foodItem_txf.setFont(font);
        quantity_txf.setFont(font);
        caloriesConsumed_txf.setFont(font);

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

        frame.add(logId_txf);
        frame.add(userId_txf);
        frame.add(date_txf);
        frame.add(mealType_txf);
        frame.add(foodItem_txf);
        frame.add(quantity_txf);
        frame.add(caloriesConsumed_txf);

        frame.add(insert_btn);
        frame.add(view_btn);
        frame.add(update_btn);
        frame.add(delete_btn);

        addActionListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dietlogs dietlog = new Dietlogs();
        if (e.getSource() == insert_btn) {
            dietlog.setUser_id(userId_txf.getText());
            dietlog.setDate(date_txf.getText());
            dietlog.setMealType(mealType_txf.getText());
            dietlog.setFoodItem(foodItem_txf.getText());
            dietlog.setQuantity(quantity_txf.getText());
            dietlog.setCaloriesConsumed(caloriesConsumed_txf.getText());
            dietlog.insertData();
        } else if (e.getSource() == view_btn) {
            int id = Integer.parseInt(logId_txf.getText());
            dietlog.readWithLogID(id);
            logId_txf.setText(String.valueOf(dietlog.getLogID()));
            userId_txf.setText(dietlog.getUser_id());
            date_txf.setText(dietlog.getDate());
            mealType_txf.setText(dietlog.getMealType());
            foodItem_txf.setText(dietlog.getFoodItem());
            quantity_txf.setText(dietlog.getQuantity());
            caloriesConsumed_txf.setText(dietlog.getCaloriesConsumed());
        } else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(logId_txf.getText());
            dietlog.setUser_id(userId_txf.getText());
            dietlog.setDate(date_txf.getText());
            dietlog.setMealType(mealType_txf.getText());
            dietlog.setFoodItem(foodItem_txf.getText());
            dietlog.setQuantity(quantity_txf.getText());
            dietlog.setCaloriesConsumed(caloriesConsumed_txf.getText());
            dietlog.update(id);
        } else {
            int id = Integer.parseInt(logId_txf.getText());
            dietlog.delete(id);
        }
    }

    public static void main(String[] args) {
        DietlogForms dietlogForm = new DietlogForms();
        System.out.println(dietlogForm);
    }}
