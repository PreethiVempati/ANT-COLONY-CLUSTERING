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
public class WINEExcelReader extends HttpServlet {

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
            int y=st.executeUpdate("delete from wine");
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
              
           String classes=null;
           String Alcohol=null;
            String Malicacid=null;  
            String Ash=null;
            String Alcalinityofash=null;
              String Magnesium=null;
           String Totalphenols=null;
            String Flavanoids=null;  
            String Nonflavanoidphenols=null;
            String Proanthocyanins=null;
            String Colorintensity=null;  
            String Hue=null;
            String OD280OD315ofdilutedwines=null;
            String Proline=null;
            
              if(row.getCell(0)==null){
                  classes="null";
              }else{
                   classes=row.getCell(0).toString();
              }
              if(row.getCell(1)==null){
                  Alcohol="null";
              }else{
                   Alcohol=row.getCell(1).toString();
              }
              if(row.getCell(2)==null){
                  Malicacid="null";
              }else{
                   Malicacid=row.getCell(2).toString();
              }
              if(row.getCell(3)==null){
                  Ash="null";
              }else{
                   Ash=row.getCell(3).toString();
              }
              if(row.getCell(4)==null){
                  Alcalinityofash="null";
              }else{
                   Alcalinityofash=row.getCell(4).toString();
              }
              
              
              if(row.getCell(5)==null){
                  Magnesium="null";
              }else{
                   Magnesium=row.getCell(5).toString();
              }
              
              if(row.getCell(6)==null){
                  Totalphenols="null";
              }else{
                   Totalphenols=row.getCell(6).toString();
              }
              if(row.getCell(7)==null){
                  Flavanoids="null";
              }else{
                   Flavanoids=row.getCell(7).toString();
              }
              if(row.getCell(8)==null){
                  Nonflavanoidphenols="null";
              }else{
                   Nonflavanoidphenols=row.getCell(8).toString();
              }
              
              if(row.getCell(9)==null){
                  Proanthocyanins="null";
              }else{
                   Proanthocyanins=row.getCell(9).toString();
              }
              if(row.getCell(10)==null){
                  Colorintensity="null";
              }else{
                   Colorintensity=row.getCell(10).toString();
              }
              if(row.getCell(11)==null){
                  Hue="null";
              }else{
                   Hue=row.getCell(11).toString();
              }
              if(row.getCell(12)==null){
                  OD280OD315ofdilutedwines="null";
              }else{
                   OD280OD315ofdilutedwines=row.getCell(12).toString();
              }
               if(row.getCell(13)==null){
                  Proline="null";
              }else{
                   Proline=row.getCell(13).toString();
              }
              
              
               PreparedStatement pst=con.prepareStatement("insert into wine values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              
               pst.setString(1,classes); 
               pst.setString(2,Alcohol);
               pst.setString(3,Malicacid);
               pst.setString(4,Ash);
               pst.setString(5,Alcalinityofash);
               pst.setString(6,Magnesium); 
               pst.setString(7,Totalphenols);
               pst.setString(8,Flavanoids);
               pst.setString(9,Nonflavanoidphenols);
               pst.setString(10,Proanthocyanins);
               pst.setString(11,Colorintensity); 
               pst.setString(12,Hue);
               pst.setString(13,OD280OD315ofdilutedwines);
               pst.setString(14,Proline);
               
       
              
             k=pst.executeUpdate(); 
            }
             if(k>0){
         response.sendRedirect("UploadThirdDataset.jsp?msg=success");
             }else{
              
               response.sendRedirect("UploadSecondDataset.jsp?msg=failed");
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
