package utp.misiontic2022.c2.p51.reto4.modelo.dao;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        // Su código
        var connection = JDBCUtilities.getConnection();
        
        var response = new ArrayList<Requerimiento_1>();

        try{
            var stmt = connection.prepareStatement("SELECT Nombre_Material, Precio_Unidad"  
                                                + " FROM MaterialConstruccion" 
                                                + " WHERE Importado = 'Si'"
                                                + " order by Precio_Unidad desc");
            var rset = stmt.executeQuery();

            while (rset.next()) {
                var requerimiento_1 = new Requerimiento_1();
                requerimiento_1.setNombre_Material(rset.getString("Nombre_Material"));
                requerimiento_1.setPrecio_Unidad(rset.getInt("Precio_Unidad"));

                response.add(requerimiento_1);
            }
            
        } finally {

            if (connection != null) {
                connection.close();
            }
        }    
            return response;
        
    }
    
}


