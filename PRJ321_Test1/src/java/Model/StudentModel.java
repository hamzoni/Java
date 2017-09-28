
package Model;

import Entities.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentModel extends Model<Student> {

    public StudentModel(String table) {
        super(table);
    }

    @Override
    public boolean create(Student ent) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Student (name, department_id, gender, dob) VALUES (?, ?, ?, ?)");
            stmt.setString(1, ent.getName());
            stmt.setInt(2, ent.getDepartment_id());
            stmt.setInt(3, ent.getGender());
            stmt.setString(4, ent.getDob());

            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public <E> Student search(E id) {
        Student std = null;
        try {
            Integer sid = (Integer) id;
            PreparedStatement stmt = con.prepareStatement("SELECT A.id, A.name, A.department_id, Department.name as \"department_name\", gender, dob "
                    + "FROM (SELECT * FROM Student WHERE id = ?) A "
                    + "LEFT JOIN Department "
                    + "ON A.department_id = Department.id");
            stmt.setInt(1, sid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                std = new Student();
                std.setId(rs.getInt("id"));
                std.setDepartment_id(rs.getInt("department_id"));
                std.setDepartment_name(rs.getString("department_name"));
                std.setName(rs.getString("name"));
                std.setGender(rs.getInt("gender"));
                std.setDob(rs.getString("dob"));
                return std;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return std;
    }
    
    @Override
    public boolean update(Student ent) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE Student SET name = ?, department_id = ?, gender = ?, dob = ?");
            stmt.setString(1, ent.getName());
            stmt.setInt(2, ent.getDepartment_id());
            stmt.setInt(3, ent.getGender());
            stmt.setString(4, ent.getDob());

            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public <T> boolean delete(T id) {
        try {
            Integer sid = (Integer) id;
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Student WHERE id = ?");
            stmt.setInt(1, sid);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT Student.id, Student.name, Student.department_id, Department.name as \"department_name\", gender, dob\n" +
                            "FROM Student " +
                            "LEFT JOIN Department " +
                            "ON Student.department_id = Department.id";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setDepartment_id(rs.getInt("department_id"));
                student.setDepartment_name(rs.getString("department_name"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getInt("gender"));
                student.setDob(rs.getString("dob"));
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
}
