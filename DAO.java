/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBcontext;
import entity.Account;
import entity.Book;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class DAO {
      Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs =null;
    public Account login(String user, String pass){
        String query = "select*from Account3 \n" +
"where [user] = ?\n" +
"and pass = ?";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            while (rs.next()){
               return new Account(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getInt(4), 
                        rs.getString(5),
               rs.getString(6));
            }
        } catch(Exception e){
            
        }
        return null;
    }
    public Account getaccountbyid(String id){
        String query ="select * from Account3\n" +
"                where UserID=?";
        try {
            conn = new DBcontext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Book> getlistBook(){
        String query = "select * from Book1";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Book> list= new ArrayList<>();
            while (rs.next()){
              list.add( new Book(rs.getString(1),
                      rs.getString(2),
                      rs.getString(3), 
                      rs.getString(4),
                      rs.getString(5),
                      rs.getString(6),
                      rs.getString(7),
                      rs.getString(8)));
            }
            return list;
        } catch(Exception e){
            
        }
        return null;
    }
    public List<Category> getlistCategory(){
        String query = "select * from Category";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Category> listc= new ArrayList<>();
            while (rs.next()){
              listc.add( new Category(rs.getInt(1),
                      rs.getString(2)));
            }
            return listc;
        } catch(Exception e){
            
        }
        return null;
    }
     public Book getLast() {
        String query = "select top 1 * from Book1\n" +
"order by BookID desc";
        try {
            conn = new DBcontext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Book(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
     public void updateProduct(String id){
         
     }
      public void AddAccount( String user , String pass , String admin ,String name ,String phone){
        String query ="insert into Account3\n" +
"values(?,?,?,?,?)";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, admin);
            ps.setString(4, name);
            ps.setString(5, phone);
           ps.executeUpdate();
          
        } catch(Exception e){
            
    }
     }
       public void Addbook(String id , String name , String img , String authorname ,String auid ,String caid, String sum, String link){
        String query ="insert into Book1\n" +
"values(?,?,?,?,?,?,?,?)";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, img);
            ps.setString(4, authorname);
            ps.setString(5, auid);
            ps.setString(6, caid);
            ps.setString(7, sum);
            ps.setString(8, link);
           ps.executeUpdate();
          
        } catch(Exception e){
            
    }
     }
      public List<Book> getlistBookbycatID(String cid){
        String query = "select* from Book1 \n" +
"where CategoryID= ?";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            List<Book> list= new ArrayList<>();
            while (rs.next()){
              list.add( new Book(rs.getString(1),
                      rs.getString(2),
                      rs.getString(3),
                      rs.getString(4),
                      rs.getString(5),
                      rs.getString(6),
                      rs.getString(7),
                      rs.getString(8)));
            }
            return list;
        } catch(Exception e){
            
        }
        return null;
    }
        public List<Book> getlistBookbyname(String name){
        String query = "select* from Book1 \n" +
"where Bookname like ?";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();
            List<Book> list= new ArrayList<>();
            while (rs.next()){
              list.add( new Book(rs.getString(1),
                      rs.getString(2),
                      rs.getString(3),
                      rs.getString(4),
                      rs.getString(5),
                      rs.getString(6),
                      rs.getString(7),
                      rs.getString(8)));
            }
            return list;
        } catch(Exception e){
            
        }
        return null;
    }
      public Book review(String bid) {
        String query = "select * from Book1\n" +
"where BookID =?";
        try {
            conn = new DBcontext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, bid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Book(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    } 
        public void updateAcc (String id , String user ,String pass, String name , String phone){
           String query ="update Account3\n" +
"set [User]=?,\n" +
"pass =?,\n" +
"name =?,\n" +
"phone=?\n" +
"where UserID=?";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.setString(3,name);
             ps.setString(4,phone);
            ps.setString(5,id);
           ps.executeUpdate();
          
        } catch(Exception e){
            
    }
     }
         public void deleteBook(String id){
        String query ="delete from Book1 where BookID =?";
        try{
            
            conn =new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
           ps.executeUpdate();
          
        } catch(Exception e){
            
    }
     }
    public static void main(String[] args) {
      DAO accountDAO = new DAO();
      List<Book> list = accountDAO.getlistBookbyname("a");
        for(Book a : list){
            System.out.println(a);
        }
        List<Category> listc = accountDAO.getlistCategory();
        for(Category a : listc){
            System.out.println(a);
        }
    }
}