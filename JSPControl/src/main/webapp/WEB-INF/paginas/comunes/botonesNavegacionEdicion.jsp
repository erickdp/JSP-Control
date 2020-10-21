<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-lock">   
                    <i class="fas fa-check"></i> Regresar al Inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-lock">
                    <i class="fa fa-check"></i> Guardar Cliente
                </button>
            </div>
            
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                   class="btn btn-danger btn-lock">
                    <i class="fas fa-trash"></i> Eliminar Registro
                </a>
            </div>
        </div>
    </div>
</section>