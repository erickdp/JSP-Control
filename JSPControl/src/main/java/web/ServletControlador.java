package web;

import datos.ClienteDAO;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(req, resp);
                    break;
                    
                case "eliminar":
                    this.eliminarCliente(req, resp);
                    break;
                    
                default:
                    this.accionDefault(req, resp);
            }
        } else {
            this.accionDefault(req, resp);
        }
    }
    
    private void eliminarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        int registrosAfectados = new ClienteDAO().eliminar(new Cliente(idCliente));
        
        System.out.println("registrosAfectados = " + registrosAfectados);
        
        this.accionDefault(req, resp);
    }

    private void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recuperar el idCliente
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        Cliente cliente = new ClienteDAO().encontrar(new Cliente(idCliente));
        req.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }

//    Este metodo sirve para cargar nuevamente la pagina index y que se actualicen los campos,
//    se usa tanto en doGet como doPost por eso esque se agrega en codigo aparte y se lo llama
    private void accionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDAO().listar();
        System.out.println("clientes = " + clientes);

        HttpSession sesion = req.getSession(); //Como usamos senRedirect debemos de cambiar el alcance a session

        sesion.setAttribute("clientes", clientes);//agregro en el alcance de session

//        req.setAttribute("clientes", clientes);//agrego en el alcance de request
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));

//        req.getRequestDispatcher("clientes.jsp").forward(req, resp); //Enviar info a clientes.jsp, pero produce un error pues no sabe que un nuevo servlet se selecciona
//        osea que el url no cambie y se mantiene con la accion que se ha echo anteriormente
        resp.sendRedirect("clientes.jsp"); //Si notifica al navegador que se esta cambiando de url

    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(req, resp);
                    break;

                case "modificar":
                    this.modificarCliente(req, resp);
                    break;

                default:
                    this.accionDefault(req, resp);
            }
        } else {
            this.accionDefault(req, resp);
        }
    }

    private void modificarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String tlf = req.getParameter("tlf");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        int registrosModificados = new ClienteDAO().actualizar(new Cliente(
                Integer.parseInt(req.getParameter("idCliente")), nombre, apellido, email, tlf, saldo));
        
        System.out.println("registrosModificados = " + registrosModificados);
        
        this.accionDefault(req, resp);
    }

    private void insertarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperar los valores del formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String tlf = req.getParameter("tlf");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, tlf, saldo);

        //Insertamos nuevo objeto en la bbdd
        int registrosModificados = new ClienteDAO().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Reedirigimos al default
        this.accionDefault(req, resp);
    }

}
