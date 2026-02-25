package com.fabrica.boiler.model;

public final class ChocolateBoiler {

    private static volatile ChocolateBoiler instance;

    private BoilerState state;
    private boolean heating;

    private ChocolateBoiler() {
        this.state = BoilerState.EMPTY;
        this.heating = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoiler.class) {
                if (instance == null) {
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }
  //Synchronized: Used to control the access of multiple threads to shared resources
    public synchronized void fill() {
        if (state == BoilerState.EMPTY && !heating) {
            state = BoilerState.FILLED;
            System.out.println("Boiler llenado con mezcla de chocolate y leche.");
        } else {
            System.out.println("No se puede llenar: debe estar vacío y con resistencia apagada.");
        }
    }

    public synchronized void startMixing() {
        if (state == BoilerState.FILLED && !heating) {
            heating = true;
            state = BoilerState.BOILING;
            System.out.println("Proceso iniciado: resistencia encendida, mezclando/calientando...");
        } else {
            System.out.println("No se puede iniciar: debe estar lleno y con resistencia apagada.");
        }
    }

    public synchronized void drain() {
        if (state != BoilerState.EMPTY && heating) {
            state = BoilerState.EMPTY;
            heating = false;
            System.out.println("Boiler vaciado. Resistencia apagada.");
        } else {
            System.out.println("No se puede vaciar: debe no estar vacío y resistencia encendida.");
        }
    }

    public synchronized BoilerState getState() {
        return state;
    }

    public synchronized boolean isHeating() {
        return heating;
    }

    @Override
    public synchronized String toString() {
        return "ChocolateBoiler{state=" + state + ", heating=" + heating + "}";
    }
}
