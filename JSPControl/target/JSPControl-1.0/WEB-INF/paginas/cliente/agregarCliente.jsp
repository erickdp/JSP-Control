<!--el id se lo toma de botonesNavegacion, por eso se hace referencia a agregar cliente modal-->
<div class="modal fade" id="agregarClienteModal"> 
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <!--Formulario Action = se obtiene con expression languaje el nombre de la aplicacion y el servlet controlador
            y ademas se le asigna una accion. Method oculta los datos de la url WAS-VALIDATED determina que los campos
            insertados sean validos-->
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST"
                  class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>

                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>

                    <div class="form-group">
                        <label for="tlf">Tlf</label>
                        <input type="tel" class="form-control" name="tlf" required>
                    </div>

                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>

            </form>
        </div>
    </div>


</div>
