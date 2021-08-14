package utp.misiontic2022.c2.p51.reto4.vista;
import java.awt.BorderLayout;
 
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;

public class VentanaConsulta extends JFrame {

    private ControladorRequerimientos controlador1;
   
    private JTable tabla1;
    private JTable tabla2;
    private JTable tabla3;

    public VentanaConsulta(){

        controlador1 = new ControladorRequerimientos();
        
        initUI();
        setLocationRelativeTo(null);
    }

    private void initUI(){
        setTitle("INTERFAZ RETO 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel_1 = new JPanel();
        panel_1.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento 1", panel_1);

        var panel_2 = new JPanel();
        panel_2.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento 2", panel_2);

        var panel_3 = new JPanel();
        panel_3.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento 3", panel_3);

        var panel_1Entrada = new JPanel();
        panel_1Entrada.add(new JLabel("Reto 5 Label"));
        var btnConsulta1 = new JButton("Consultar");
        btnConsulta1.addActionListener(e -> cargarTablaConsulta1()); //Paso evento a la accion del boton
        panel_1Entrada.add(btnConsulta1);
        panel_1.add(panel_1Entrada, BorderLayout.PAGE_START);

        var panel_2Entrada = new JPanel();
        panel_2Entrada.add(new JLabel("Reto 5 Label"));
        var btnConsulta2 = new JButton("Consultar");
        btnConsulta2.addActionListener(e -> cargarTablaConsulta2()); //Paso evento a la accion del boton
        panel_2Entrada.add(btnConsulta2);
        panel_2.add(panel_2Entrada, BorderLayout.PAGE_START);

        var panel_3Entrada = new JPanel();
        panel_3Entrada.add(new JLabel("Reto 5 Label"));
        var btnConsulta3 = new JButton("Consultar");
        btnConsulta3.addActionListener(e -> cargarTablaConsulta3()); //Paso evento a la accion del boton
        panel_3Entrada.add(btnConsulta3); 
        panel_3.add(panel_3Entrada, BorderLayout.PAGE_START);

        //TABLA
        tabla1 = new JTable();
        tabla2 = new JTable();
        tabla3 = new JTable();
        panel_1.add(new JScrollPane(tabla1), BorderLayout.CENTER);
        panel_2.add(new JScrollPane(tabla2), BorderLayout.CENTER);
        panel_3.add(new JScrollPane(tabla3), BorderLayout.CENTER);

        }

    private void cargarTablaConsulta1(){

        try {
            var lista = controlador1.consultarRequerimiento1();
            var tableModel1 = new Requerimiento1TableModel();
                
    
            tableModel1.setData(lista);
            tabla1.setModel(tableModel1);
         
    
        } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            }

        }
        private void cargarTablaConsulta2(){

   
            try {
                var lista = controlador1.consultarRequerimiento2();
                var tableModel2 = new Requerimiento2TableModel();

                tableModel2.setData(lista);
                tabla2.setModel(tableModel2);
                   
        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
            }
        }   

        private void cargarTablaConsulta3(){
   
                try {
                        
                    var lista = controlador1.consultarRequerimiento3();
                    var tableModel3 = new Requerimiento3TableModel();
            
                        
                    tableModel3.setData(lista);
                    tabla3.setModel(tableModel3);
            
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
                    }
                }    
    private class Requerimiento1TableModel extends AbstractTableModel{
    
        private ArrayList<Requerimiento_1> data;
    
        public void setData(ArrayList<Requerimiento_1> data){
            this.data = data;
        }
        
        @Override
        public String getColumnName(int column){
            switch (column) {
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio Unidad";
                
            }
                
            return super.getColumnName(column);
    
            }    
            
        @Override
                public Class<?> getColumnClass(int columnIndex) {
                    switch(columnIndex){
                        case 0:
                            return String.class;
                        case 1:
                            return Integer.class;
    
                    }
                    return super.getColumnClass(columnIndex);
                }
            @Override
            public int getRowCount() {//Quiero el numero de filas
    
                return data.size();
            }
    
            @Override
            public int getColumnCount() {//Quiero el numero de columnas
                return 2;
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
    
                var registro = data.get(rowIndex);
                switch(columnIndex){
                    case 0:
                        return registro.getNombre_Material();
                    case 1:
                        return registro.getPrecio_Unidad();

    
                }
                return null;
            }
        }


    private class Requerimiento2TableModel extends AbstractTableModel{
    
            private ArrayList<Requerimiento_2> data;
    
            public void setData(ArrayList<Requerimiento_2> data){
                this.data = data;
            }
        
            @Override
            public String getColumnName(int column){
                switch (column) {
                    case 0:
                        return "Constructora";
                    case 1:
                        return "Ciudad";
                
                }
                
                return super.getColumnName(column);
    
            }    
            
            @Override
                public Class<?> getColumnClass(int columnIndex) {
                    switch(columnIndex){
                        case 0:
                            return String.class;
                        case 1:
                            return String.class;
    
                    }
                    return super.getColumnClass(columnIndex);
                }
            @Override
            public int getRowCount() {//Quiero el numero de filas
    
                return data.size();
            }
    
            @Override
            public int getColumnCount() {//Quiero el numero de columnas
                return 2;
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
    
                var registro = data.get(rowIndex);
                switch(columnIndex){
                    case 0:
                        return registro.getConstructora();
                    case 1:
                        return registro.getCiudad();

    
                }
                return null;
            }
        }        

    private class Requerimiento3TableModel extends AbstractTableModel{
    
            private ArrayList<Requerimiento_3> data;
    
            public void setData(ArrayList<Requerimiento_3> data){
                this.data = data;
            }
        
            @Override
            public String getColumnName(int column){
                switch (column) {
                    case 0:
                        return "Proveedor";
                    case 1:
                        return "Nombre Material";
                    case 2:
                        return "Importado";
                    case 3:
                        return "Precio x Unidad";
                    case 4:
                        return "Cantidad";
                }
                
                return super.getColumnName(column);
    
            }    
            
            @Override
                public Class<?> getColumnClass(int columnIndex) {
                    switch(columnIndex){
                        case 0:
                            return String.class;
                        case 1:
                            return String.class;
                        case 2:
                            return String.class;
                        case 3:
                            return Integer.class;
                        case 4:
                            return Integer.class;
    
                    }
                    return super.getColumnClass(columnIndex);
                }
            @Override
            public int getRowCount() {//Quiero el numero de filas
    
                return data.size();
            }
    
            @Override
            public int getColumnCount() {//Quiero el numero de columnas
                return 5;
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
    
                var registro = data.get(rowIndex);
                switch(columnIndex){
                    case 0:
                        return registro.getProveedor();
                    case 1:
                        return registro.getNombre_Material();
                    case 2:
                        return registro.getImportado();
                    case 3:
                        return registro.getPrecio_Unidad();
                    case 4:
                        return registro.getCantidad();
    
                }
                return null;
            }
        }
    

}
