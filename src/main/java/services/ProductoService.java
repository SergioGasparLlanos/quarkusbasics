package services;

import dtos.ProductoDTO;
import entities.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import mappers.ProductoMapper;
import repositories.ProductoRepository;

import java.util.List;

@ApplicationScoped
public class ProductoService {

    @Inject
    ProductoRepository repository;

    @Inject
    ProductoMapper mapper;

    public List<Producto> obtenerTodos() {
        return repository.listAll();
    }

    @Transactional
    public Producto guardarProducto(ProductoDTO productoDto) {

        if (productoDto.nombre() == null || productoDto.precio() < 0) {
            throw new WebApplicationException("El precio debe ser mayor a 0", 422);
        }

        Producto producto = mapper.toEntity(productoDto);
        repository.persist(producto);
        return producto;
    }

    public Producto buscarPorId(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("entities.Producto no encontrado", 404));
    }
}