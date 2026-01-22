package mappers;

import dtos.ProductoDTO;
import entities.Producto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductoMapper {

    public Producto toEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.nombre = dto.nombre();
        producto.precio = dto.precio();
        return producto;
    }


    public ProductoDTO toDTO(Producto entidad) {
        return new ProductoDTO(entidad.nombre, entidad.precio);
    }
}