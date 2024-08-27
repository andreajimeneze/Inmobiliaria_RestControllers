package cl.praxis.inmobiliaria.services;

import java.util.List;

public interface ICrudGenericoService<T> {
    List<T> listar();
    T buscarPorId(int id);
    T guardar(T t);
    T actualizar(T t);
    void remover(T t);

}
