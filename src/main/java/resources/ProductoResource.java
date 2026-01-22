package resources;

import dtos.ProductoDTO;
import entities.Producto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.ProductoService;

import java.util.List;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoResource {


    @Inject
    ProductoService service;

    @GET
    public List<Producto> listar() {
        return service.obtenerTodos();
    }

    @GET
    @Path("/{id}")
    public Producto obtener(@PathParam("id") Long id) {
        return service.buscarPorId(id);
    }

    @POST
    public Response crear(ProductoDTO productoDto) {
        Producto nuevo = service.guardarProducto(productoDto);
        return Response.status(Response.Status.CREATED).entity(nuevo).build();
    }
}