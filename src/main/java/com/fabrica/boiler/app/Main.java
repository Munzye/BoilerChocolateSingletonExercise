package com.fabrica.boiler.app;

import com.fabrica.boiler.service.BoilerService;

public class Main {
    public static void main(String[] args) {
        BoilerService service = new BoilerService();

        //ResistenceDown
        service.imprimirEstado();

        //InvalidTry
        service.vaciar();

        //Fill
        service.llenar();

        //InvalidFill
        service.llenar();

        service.iniciarProceso();

        service.vaciar();

        service.iniciarProceso();
    }
}
