package ro.antalya;


import ro.antalya.recipe.Product;
import java.sql.SQLException;
import static ro.antalya.SQL.H2JDBCUtils.getConnection;


public class Main {

   public static void main(String[] args) throws SQLException {
       getConnection();

     //TODO H2 data init, creare toate tabelele de care am nevoie + inserturile necesare ?
       
       Product order = new Product();

//
//
//
//       //TODO select all orders
////       Order.getAll();
//
//       //TODO delete order by id
////       Order.delete(1);
//
//       //TODO update order by id
////       Order.update(1, new ingredient???);
//       //1. select + update
//       //2. direct query update



  }
}


