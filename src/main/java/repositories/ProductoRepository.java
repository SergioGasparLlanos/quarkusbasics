package repositories;

import entities.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductoRepository implements PanacheRepository<Producto> {


    public List<Producto> buscarPorNombre(String nombre) {
        return list("nombre like ?1", "%" + nombre + "%");
    }
}
