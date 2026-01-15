package App.ConsoleApp;

public class KGD {
    private String cedula;
    private String nombre;
    private String usuario;
    private String clave;

    public KGD(String cedula, String nombre, String usuario, String clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void show() {
        System.out.println("[+] Alumno:");
        System.out.println(getCedula() + " | " + getNombre());
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n cedula    : " + getCedula()
                + "\n nombre    : " + getNombre()
                + "\n usuario    : " + getUsuario()
                + "\n clave    : " + getClave();

    }
}
