package all_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Patient {

    private int Patients_id;
    private String Patient_F_Name;
    private String Patient_l_Name;
    private String Patient_BOB_Date;

    public Patient() {}

    public Patient(int Patients_id, String Patient_F_Name, String Patient_l_Name, String Patient_BOB_Date) {
        this.Patients_id = Patients_id;
        this.Patient_F_Name = Patient_F_Name;
        this.Patient_l_Name = Patient_l_Name;
        this.Patient_BOB_Date = Patient_BOB_Date;
    }

    public Patient(String Patient_F_Name, String Patient_l_Name, String Patient_BOB_Date) {
        this.Patient_F_Name = Patient_F_Name;
        this.Patient_l_Name = Patient_l_Name;
        this.Patient_BOB_Date = Patient_BOB_Date;
    }

    public int getPatients_id() {
        return Patients_id;
    }

    public void setPatients_id(int patients_id) {
        Patients_id = patients_id;
    }

    public String getPatient_F_Name() {
        return Patient_F_Name;
    }

    public void setPatient_F_Name(String patient_F_Name) {
        Patient_F_Name = patient_F_Name;
    }

    public String getPatient_l_Name() {
        return Patient_l_Name;
    }

    public void setPatient_l_Name(String patient_l_Name) {
        Patient_l_Name = patient_l_Name;
    }

    public String getPatient_BOB_Date() {
        return Patient_BOB_Date;
    }

    public void setPatient_BOB_Date(String patient_BOB_Date) {
        Patient_BOB_Date = patient_BOB_Date;
    }

    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/smart_health_management_system";
        String user = "222010357";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void insertData() {
        String sql = "INSERT INTO patients (Patient_F_Name, Patient_l_Name, Patient_BOB_Date) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, this.Patient_F_Name);
            statement.setString(2, this.Patient_l_Name);
            statement.setString(3, this.Patient_BOB_Date);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Patient inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert Patient!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    public void readWithPatients_id(int inputPatients_id) {
        String sql = "SELECT * FROM patients WHERE Patients_id = ?";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, inputPatients_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.Patient_F_Name = resultSet.getString("Patient_F_Name");
                this.Patient_l_Name = resultSet.getString("Patient_l_Name");
                this.Patient_BOB_Date = resultSet.getString("Patient_BOB_Date");
            } else {
                JOptionPane.showMessageDialog(null, "No Patient found with ID: " + inputPatients_id, "Read Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(int inputPatients_id) {
        String sql = "UPDATE patients SET Patient_F_Name = ?, Patient_l_Name = ?, Patient_BOB_Date = ? WHERE Patients_id = ?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, this.Patient_F_Name);
            preparedStatement.setString(2, this.Patient_l_Name);
            preparedStatement.setString(3, this.Patient_BOB_Date);
            preparedStatement.setInt(4, inputPatients_id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Patient found with ID: " + inputPatients_id, "Update Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void delete(int inputPatients_id) {
        String sql = "DELETE FROM patients WHERE Patients_id = ?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, inputPatients_id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Patient found with ID: " + inputPatients_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

