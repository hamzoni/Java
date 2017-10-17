
package Model;

import Entities.Request;
import Entities.Request;
import Middleware.Tool;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestModel extends Model<Request> {

    @Override
    public boolean create(Request t) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO requests ([username], [start_date], [end_date], [reason], [processed_by], [status]) VALUES (?, ?)");
            stmt.setString(1, t.getUsername());
            stmt.setDate(2, (Date) t.getStart());
            stmt.setDate(3, (Date) t.getStart());
            stmt.setString(4, t.getReason());
            stmt.setString(5, t.getProcessedBy());
            stmt.setInt(6, t.getStatus());
            
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RequestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Request> list() {
        ArrayList<Request> requests = new ArrayList<Request>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM requests";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Request request = new Request();
                request.setUsername(rs.getString("username"));
                request.setStart(rs.getDate("start_date"));
                request.setEnd(rs.getDate("end_date"));
                request.setProcessedBy(rs.getString("processed_by"));
                request.setStatus(rs.getInt("status"));
                request.setReason(rs.getString("reason"));
                
                requests.add(request);
            }
            return requests;
        } catch (SQLException ex) {
            Logger.getLogger(RequestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;
    }

    @Override
    public Request search(int id) {
        return null;
    }
    
    public boolean update(Request t, String username) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE requests SET username = ?, start_date = ?, end_date = ?, reason = ?, processed_by = ?, status = ? WHERE username = ?");
            stmt.setString(1, t.getUsername());
            stmt.setDate(2, (Date) t.getStart());
            stmt.setDate(3, (Date) t.getStart());
            stmt.setString(4, t.getReason());
            stmt.setString(5, t.getProcessedBy());
            stmt.setInt(6, t.getStatus());
            stmt.setString(7, username);
            
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(RequestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean update(Request t) {
        return false;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }

    @Override
    public boolean delete(String username) {
        try {
            String query = "DELETE FROM requests WHERE username = ? AND ";
            PreparedStatement stmt = con.prepareStatement((String) query);
            stmt.setString(1, username);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(RequestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(String username, Date start) {
        try {
            String query = "DELETE FROM requests WHERE username = ? AND start_date = ? ";
            PreparedStatement stmt = con.prepareStatement((String) query);
            stmt.setString(1, username);
            stmt.setDate(2, start);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(RequestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Request> search(String username) {
        return null;
    }

    @Override
    public Request search2(String username) {
        Request request = null;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM requests WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                request = new Request();
                request.setUsername(rs.getString("username"));
                request.setStart(rs.getDate("start_date"));
                request.setEnd(rs.getDate("end_date"));
                request.setProcessedBy(rs.getString("processed_by"));
                request.setStatus(rs.getInt("status"));
                request.setReason(rs.getString("reason"));
                return request;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }

}
