package com.ayd.aulas.comun;

import com.ayd.aulas.excepcion.ExcepcionErrorJpaRepository;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public class ValidadoresJpaRepository {

    public ValidadoresJpaRepository() {
    }

    public static void validarSave(JpaRepository jpa, Object o) {
        try {
            jpa.save(o);
        } catch (Exception e) {
           throw new ExcepcionErrorJpaRepository(e.getMessage());
        }
    }

    public static void validarSave(JpaRepository jpa, List<Object> objects) {
        if (objects.isEmpty() || Objects.isNull(objects)) {
            throw new ExcepcionSinDatos("Lista de objectos vacia, JpaReppository");
        }
        objects.forEach(
                obj -> validarSave(jpa, obj)
        );
    }

    public static void validarDelete(JpaRepository jpa, Object o) {
        try {
            jpa.delete(o);
        } catch (Exception e) {
            new ExcepcionErrorJpaRepository(e.getMessage());
        }
    }

    public static void validarDeleteById(JpaRepository jpa, Long o) {
        try {
            jpa.deleteById(o);
        } catch (Exception e) {
            new ExcepcionErrorJpaRepository(e.getMessage());
        }
    }
}
