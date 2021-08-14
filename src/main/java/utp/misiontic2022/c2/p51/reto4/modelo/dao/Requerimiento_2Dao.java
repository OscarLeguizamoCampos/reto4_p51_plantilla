package utp.misiontic2022.c2.p51.reto4.modelo.dao;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        // Su código
        var connection = JDBCUtilities.getConnection();
        
        var response = new ArrayList<Requerimiento_2>();

      
        try{
            var stmt = connection.prepareStatement("SELECT DISTINCT Constructora, Ciudad"
                                                    + " FROM Proyecto"
                                                    + " WHERE Ciudad"
                                                    + " LIKE 'B%'"
                                                    + " ORDER BY Ciudad");
            var rset = stmt.executeQuery();

            while (rset.next()) {
                var requerimiento_2 = new Requerimiento_2();
                requerimiento_2.setConstructora(rset.getString("Constructora"));
                requerimiento_2.setCiudad(rset.getString("Ciudad"));
                response.add(requerimiento_2);
            }
 
        } finally {

            if (connection != null) {
                connection.close();
            }
        }
        return response;
    }
    
}