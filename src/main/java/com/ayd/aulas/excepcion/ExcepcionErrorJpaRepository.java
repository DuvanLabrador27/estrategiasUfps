package com.ayd.aulas.excepcion;

public class ExcepcionErrorJpaRepository extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionErrorJpaRepository(String message) {
        super(message);
    }
}
