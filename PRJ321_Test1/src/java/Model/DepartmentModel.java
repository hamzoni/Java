
package Model;

import Entities.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentModel extends Model<Department> {

    public DepartmentModel(String table) {
        super(table);
    }

    @Override
    public boolean create(Department ent) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO " + this.table + "(name) + VALUES (?)");
            stmt.setString(1, ent.getName());
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Department ent) {
        return false;
    }

    @Override
    public <T> boolean delete(T id) {
        return false;
    }

    @Override
    public ArrayList<Department> list() {
        ArrayList<Department> departments = new ArrayList<Department>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM " + this.table;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
            return departments;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }

    @Override
    public <E> Department search(E id) {
        return null;
    }

}
