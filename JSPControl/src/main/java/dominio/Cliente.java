package dominio;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String tlf;
    private double saldo;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String email, String tlf, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tlf = tlf;
        this.saldo = saldo;
    }

    public Cliente(String nombre, String apellido, String email, String tlf, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tlf = tlf;
        this.saldo = saldo;
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{idCliente=").append(idCliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", email=").append(email);
        sb.append(", tlf=").append(tlf);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }

}
