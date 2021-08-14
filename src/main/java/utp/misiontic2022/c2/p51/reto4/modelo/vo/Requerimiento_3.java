package utp.misiontic2022.c2.p51.reto4.modelo.vo;

public class Requerimiento_3 {
    // Su código
    private String Proveedor;
    private String Nombre_Material;
    private String Importado;
    private Integer Precio_Unidad;
    private Integer Cantidad;

   

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String proveedor) {
        this.Proveedor = proveedor;
    }

    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String nombre_Material) {
        this.Nombre_Material = nombre_Material;
    }

    public String getImportado() {
        return Importado;
    }

    public void setImportado(String importado) {
        this.Importado = importado;
    }

    public Integer getPrecio_Unidad() {
        return Precio_Unidad;
    }

    public void setPrecio_Unidad(Integer precio_Unidad) {
        this.Precio_Unidad = precio_Unidad;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.Cantidad = cantidad;
    }
    
}
