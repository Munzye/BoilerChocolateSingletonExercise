package com.fabrica.boiler.service;

import com.fabrica.boiler.model.ChocolateBoiler;

public class BoilerService {

    private final ChocolateBoiler boiler = ChocolateBoiler.getInstance();

    public void llenar() {
        boiler.fill();
        imprimirEstado();
    }

    public void iniciarProceso() {
        boiler.startMixing();
        imprimirEstado();
    }

    public void vaciar() {
        boiler.drain();
        imprimirEstado();
    }

    public void imprimirEstado() {
        System.out.println("Estado actual => " + boiler);
    }
}
