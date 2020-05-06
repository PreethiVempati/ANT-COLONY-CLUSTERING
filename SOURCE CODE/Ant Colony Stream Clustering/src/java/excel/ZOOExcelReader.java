/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel;

import dbcon.Dbconnection;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@MultipartConfig(maxFileSize=16144223)
public class ZOOExcelReader extends HttpServlet {

   public final String filepath="\\E:";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         MultipartRequest m=new MultipartRequest(request,filepath);
        int k=0;
             int i1=0;
        try{
            File file=m.getFile("excel");
             Connection con=Dbconnection.getConnection();
            Statement st=con.createStatement();
            int y=st.executeUpdate("delete from zoo");
            if(y>0){
                System.out.println("dataset deleted");
            }else{
                 System.out.println("dataset not deleted");
            }
             InputStream ins=new FileInputStream(file);
           XSSFWorkbook myWorkBook = new XSSFWorkbook(ins);
           XSSFSheet mySheet = myWorkBook.getSheetAt(0);
           System.out.println(mySheet.getLastRowNum());
           Row row;
            for(int i=1;i<=mySheet.getLastRowNum();i++){
              row=(Row)mySheet.getRow(i);
              
           String animalname=null;
           String hair=null;
            String feathers=null;  
            String eggs=null;
            String milk=null;
              String airborne=null;
           String aquatic=null;
            String predator=null;  
            String toothen=null;
            String backbone=null;
            String breathes=null;  
            String venomous=null;
            String fins=null;
            String legs=null;
              String tail=null;
            String domestic=null;
            String catsize=null;
            String type=null;
            
              if(row.getCell(0)==null){
                  animalname="null";
              }else{
                   animalname=row.getCell(0).toString();
              }
              if(row.getCell(1)==null){
                  hair="null";
              }else{
                   hair=row.getCell(1).toString();
              }
              if(row.getCell(2)==null){
                  feathers="null";
              }else{
                   feathers=row.getCell(2).toString();
              }
              if(row.getCell(3)==null){
                  eggs="null";
              }else{
                   eggs=row.getCell(3).toString();
              }
              if(row.getCell(4)==null){
                  milk="null";
              }else{
                   milk=row.getCell(4).toString();
              }
              
              
              if(row.getCell(5)==null){
                  airborne="null";
              }else{
                   airborne=row.getCell(5).toString();
              }
              
              if(row.getCell(6)==null){
                  aquatic="null";
              }else{
                   aquatic=row.getCell(6).toString();
              }
              if(row.getCell(7)==null){
                  predator="null";
              }else{
                   predator=row.getCell(7).toString();
              }
              if(row.getCell(8)==null){
                  toothen="null";
              }else{
                   toothen=row.getCell(8).toString();
              }
              
              if(row.getCell(9)==null){
                  backbone="null";
              }else{
                   backbone=row.getCell(9).toString();
              }
              if(row.getCell(10)==null){
                  breathes="null";
              }else{
                   breathes=row.getCell(10).toString();
              }
              if(row.getCell(11)==null){
                  venomous="null";
              }else{
                   venomous=row.getCell(11).toString();
              }
              if(row.getCell(12)==null){
                  fins="null";
              }else{
                   fins=row.getCell(12).toString();
              }
               if(row.getCell(13)==null){
                  legs="null";
              }else{
                   legs=row.getCell(13).toString();
              }
               
               if(row.getCell(14)==null){
                  tail="null";
              }else{
                   tail=row.getCell(14).toString();
              }
               if(row.getCell(15)==null){
                  domestic="null";
              }else{
                   domestic=row.getCell(15).toString();
              }
               if(row.getCell(16)==null){
                  catsize="null";
              }else{
                   catsize=row.getCell(16).toString();
              }
               if(row.getCell(17)==null){
                  type="null";
              }else{
                   type=row.getCell(17).toString();
              }
              
              
               PreparedStatement pst=con.prepareStatement("insert into zoo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              
               pst.setString(1,animalname); 
               pst.setString(2,hair);
               pst.setString(3,feathers);
               pst.setString(4,eggs);
               pst.setString(5,milk);
               pst.setString(6,airborne); 
               pst.setString(7,aquatic);
               pst.setString(8,predator);
               pst.setString(9,toothen);
               pst.setString(10,backbone);
               pst.setString(11,breathes); 
               pst.setString(12,venomous);
               pst.setString(13,fins);
               pst.setString(14,legs);
                 pst.setString(15,tail);
               pst.setString(16,domestic); 
               pst.setString(17,catsize);
               pst.setString(18,type);
              
              
             k=pst.executeUpdate(); 
            }
             if(k>0){
         response.sendRedirect("Upload.jsp?msg=success");
             }else{
              
               response.sendRedirect("UploadThirdDataset.jsp?msg=failed");
             }       
        }catch(Exception e){
          out.println(e);  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
