
package Model;

import Entities.Category;
import Entities.Post;
import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostModel extends Model<Post> {

    public PostModel(String tableName) {
        super(tableName);
    }
    
    public ArrayList<Post> pagination(int page, int size) {
        ArrayList<Post> posts = new ArrayList<Post>();
        if (page <= 0) return null;
        try {
            String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id DESC) as r, * FROM " + tableName + ") A WHERE r BETWEEN ? AND ?";
            PreparedStatement pstm =  con.prepareStatement(query);
            pstm.setInt(1, (page - 1) * size + 1);
            pstm.setInt(2, page * size);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                
                User author = DAO.usr.search(rs.getInt("user_id"));
                Category category = DAO.ctg.search(rs.getInt("category_id"));
                
                post.setAuthor(author);
                post.setCategory(category);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setDescription(rs.getString("description"));
                
                posts.add(post);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }
    
    @Override
    public boolean create(Post t) {
        try {
            String query = "INSERT INTO " + tableName + " ([user_id], [category_id], [title] ,[content], [thumbnail], [description])"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, t.getAuthor().getId());
            pstm.setInt(2, t.getCategory().getId());
            pstm.setString(3, t.getTitle());
            pstm.setString(4, t.getContent());
            pstm.setString(5, t.getThumbnail());
            pstm.setString(6, t.getDescription());
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Post> list() {
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            String query = "SELECT * FROM " + tableName;
            PreparedStatement pstm = con.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                
                Category category = DAO.ctg.search(rs.getInt("category_id"));
                User author = DAO.usr.search(rs.getInt("user_id"));
                
                post.setAuthor(author);
                post.setCategory(category);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setDescription(rs.getString("description"));
               
                posts.add(post);
            }
            return posts;
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }
    
    public ArrayList<Post> listInCategory(int page, int size, int category_id) {
        ArrayList<Post> posts = new ArrayList<Post>();
        if (page <= 0) return null;
        try {
            String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id DESC) as r, * FROM " + tableName + 
                    " WHERE category_id = ?) A WHERE r BETWEEN ? AND ?";
            PreparedStatement pstm =  con.prepareStatement(query);
            pstm.setInt(1, category_id);
            pstm.setInt(2, (page - 1) * size + 1);
            pstm.setInt(3, page * size);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                
                User author = DAO.usr.search(rs.getInt("user_id"));
                Category category = DAO.ctg.search(rs.getInt("category_id"));
                
                post.setAuthor(author);
                post.setCategory(category);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setDescription(rs.getString("description"));
                
                posts.add(post);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }
    
    public int countPostsInCategory(int categoryID) {
        int c = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + tableName + " WHERE category_id = " + categoryID;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) c = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public ArrayList<Post> listInAuthor(int page, int size, int author_id) {
        ArrayList<Post> posts = new ArrayList<Post>();
        if (page <= 0) return null;
        try {
            String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id DESC) as r, * FROM " + tableName + 
                    " WHERE user_id = ?) A WHERE r BETWEEN ? AND ?";
            PreparedStatement pstm =  con.prepareStatement(query);
            pstm.setInt(1, author_id);
            pstm.setInt(2, (page - 1) * size + 1);
            pstm.setInt(3, page * size);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                
                User author = DAO.usr.search(rs.getInt("user_id"));
                Category category = DAO.ctg.search(rs.getInt("category_id"));
                
                post.setAuthor(author);
                post.setCategory(category);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setDescription(rs.getString("description"));
                
                posts.add(post);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }
    
    public int countPostsByAuthor(int authorID) {
        int c = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + tableName + " WHERE category_id = " + authorID;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) c = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public Post search(int i) {
        Post post = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, i);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                
                Category category = DAO.ctg.search(rs.getInt("category_id"));
                User author = DAO.usr.search(rs.getInt("user_id"));
                
                post.setAuthor(author);
                post.setCategory(category);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setDescription(rs.getString("description"));
                return post;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return post;
    }
    
    public Post searchByAuthor(int id, int authorID) {
        Post post = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id = ? AND user_id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.setInt(2, authorID);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                
                Category category = DAO.ctg.search(rs.getInt("category_id"));
                User author = DAO.usr.search(rs.getInt("user_id"));
                
                post.setAuthor(author);
                post.setCategory(category);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setDescription(rs.getString("description"));
                return post;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return post;
    }
    
    @Override
    public boolean update(Post t) {
        try {
            String query = "UPDATE " + tableName + " SET [user_id] = ?, [category_id] = ?, [title] = ?, [content] = ?, [thumbnail] = ?, [description] = ? WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, t.getAuthor().getId());
            pstm.setInt(2, t.getCategory().getId());
            pstm.setString(3, t.getTitle());
            pstm.setString(4, t.getContent());
            pstm.setString(5, t.getThumbnail());
            pstm.setString(6, t.getDescription());
            pstm.setInt(7, t.getId());
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateByAuthor(Post t, int authorID) {
        try {
            String query = "UPDATE " + tableName + " SET [category_id] = ?, [title] = ?, [content] = ?, [thumbnail] = ?, [description] = ? "
                    + "WHERE id = ? AND user_id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, t.getCategory().getId());
            pstm.setString(2, t.getTitle());
            pstm.setString(3, t.getContent());
            pstm.setString(4, t.getThumbnail());
            pstm.setString(5, t.getDescription());
            pstm.setInt(6, t.getId());
            pstm.setInt(7, authorID);
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int t) {
        try {
            String query = "DELETE FROM " + tableName + " WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, t);
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteByAuthor(int id, int authorId) {
        try {
            String query = "DELETE FROM " + tableName + " WHERE id = ? WHERE user_id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.setInt(2, authorId);
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
