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
public class IRISExcelReader extends HttpServlet {

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
            int y=st.executeUpdate("delete from iris");
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
           String sepallengthincm=null;
           String sepalwidthincm=null;
            String petallengthincm=null;  
            String petalwidthincm=null;
            String CLASS=null;
            
              if(row.getCell(0)==null){
                  sepallengthincm="null";
              }else{
                   sepallengthincm=row.getCell(0).toString();
              }
              if(row.getCell(1)==null){
                  sepalwidthincm="null";
              }else{
                   sepalwidthincm=row.getCell(1).toString();
              }
              if(row.getCell(2)==null){
                  petallengthincm="null";
              }else{
                   petallengthincm=row.getCell(2).toString();
              }
              if(row.getCell(3)==null){
                  petalwidthincm="null";
              }else{
                   petalwidthincm=row.getCell(3).toString();
              }
              if(row.getCell(4)==null){
                  CLASS="null";
              }else{
                   CLASS=row.getCell(4).toString();
              }
              
              
               PreparedStatement pst=con.prepareStatement("insert into iris values(?,?,?,?,?)");
              
               pst.setString(1,sepallengthincm); 
               pst.setString(2,sepalwidthincm);
               pst.setString(3,petallengthincm);
               pst.setString(4,petalwidthincm);
               pst.setString(5,CLASS);
              
             k=pst.executeUpdate(); 
            }
             if(k>0){
         response.sendRedirect("UploadSecondDataset.jsp?msg=success");
             }else{
              
               response.sendRedirect("Upload.jsp?msg=failed");
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
