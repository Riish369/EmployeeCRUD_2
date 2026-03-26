package dao;
import db.DBConnection;
import model.Employee;

import java.sql.*;
import java.util.*;

import java.sql.Connection;

public class EmployeeDAO {

    public void createTable(){
        String query = "CREATE TABLE IF NOT EXISTS employee (empid SERIAL PRIMARY KEY, name VARCHAR(100), address VARCHAR(100), phone VARCHAR(100), email VARCHAR(100))";
        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement()){
            st.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e);}
        }

    public void insertEmployee(Employee emp){
        String query = "INSERT INTO employee (name, address) VALUES (?, ?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getAddress());
            ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

        /* DOUBT DOUBT DOUBT */
    public List<Employee> getAll(){
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employee";

        try(Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query)){

            while(rs.next()){
                list.add(new Employee(
                        rs.getInt("empid"),
                        rs.getString("name"),
                        rs.getString("address")
                        ));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    public void updateEmployee(String newName, String oldName){
        String query = "UPDATE employee SET name = ? WHERE name = ?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, newName);
            ps.setString(2, oldName);
            ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteEmployee(String name){
        String query = "DELETE FROM employee WHERE name = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
