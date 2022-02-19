package com.app.service;

import com.app.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostService {
    private String url = "jdbc:mysql://localhost:3306/test";
    private String root = "root";
    private String password = "xogh7149@@";

    public List<Post> getList() throws SQLException {
        Connection con = DriverManager.getConnection(url,root,password);
        String sql = "select * from post";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Post> res = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("Id");
            String msg = rs.getString("Message");
            String name = rs.getString("Name");
            String dateTime = rs.getString("datetime");
            boolean pub = rs.getBoolean("Pub");
            int hit = rs.getInt("hit");

            res.add(new Post(id,msg,name,pub,dateTime,hit));
        }
        st.close();
        rs.close();
        con.close();
        return res;
    }

    public int insert(Post post) throws SQLException {
        Connection con = DriverManager.getConnection(url,root,password);
        String sql = "insert into post (message,name,pub,hit,dateTime) values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, post.getMessage());
        ps.setString(2, post.getName());
        ps.setBoolean(3, post.isPub());
        ps.setInt(4, post.getHit());

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        ps.setString(5, currentTime);
        int n = ps.executeUpdate();
        ps.close();
        con.close();

        return n;
    }
    public int update(Post post) throws SQLException {
        Connection con = DriverManager.getConnection(url,root,password);
        String sql = "update post set message=?,name=?,pub=? where id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, post.getMessage());
        ps.setString(2, post.getName());
        ps.setBoolean(3, post.isPub());
        ps.setInt(4, post.getId());
        int n = ps.executeUpdate();
        ps.close();
        con.close();
        return n;
    }
    public int delete(int id) throws SQLException {
        Connection con = DriverManager.getConnection(url,root,password);
        String sql = "delete from post where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        int n = ps.executeUpdate();
        ps.close();
        con.close();
        return n;
    }
    public int getCount() throws SQLException {
        Connection con = DriverManager.getConnection(url,root,password);
        String sql = "select count(*) as 'count' from post";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int n = rs.getInt("count");
        con.close();
        st.close();
        rs.close();
        return n;
    }

}
