package lk.sp.pos.controller;

import javafx.scene.control.Alert;
import lk.sp.pos.dao.CustomerDAO;
import lk.sp.pos.db.DBConnection;
import lk.sp.pos.dto.CustomerDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/cust")
public class CustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // System.out.println("nsdjfhjhswjf");resp.getWriter().write("Customer Servlet  doGet");

        //req.getParameter("id");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("Customer Servlet  doGet");
//        CustomerDAO dao = new CustomerDAO();

        String cid = req.getParameter("id");
        String cName = req.getParameter("name");
        String addr = req.getParameter("address");
        String tp = req.getParameter("tp");
        System.out.println("Cid"+cid+"   TP  "+tp);

        try {
            if(cid!=null && cName!=null && addr!=null && tp!=null) {
                System.out.println("if");

                PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
                pstm.setObject(1, cid);
                pstm.setObject(2, cName);
                pstm.setObject(3, addr);
                pstm.setObject(4, tp);
                System.out.println(pstm.executeUpdate() > 0);
            }else{
                System.out.println("else");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


      /*  try {
            if( dao.saveCustomer(new CustomerDTO(cid, cName, addr, tp))){
//                resp.getWriter().write("Customer Servlet  doGet");

                new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved...!").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Customer Not Save...!").show();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
