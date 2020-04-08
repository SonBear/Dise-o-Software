/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author emman
 */
public class Torniquete {

    private Status status;
    private boolean coin;

    public Torniquete() {
        setStatus(Status.START);
        setCoin(false);
    }

    public void insertCoin() throws CoinException {
        setCoin(true);
        if (isLocked() || getStatus() == Status.START) {
            setStatus(Status.UNLOCKED);
        } else {
            throw new CoinException("Ingreso otra moneda estando desbloqueado");
        }
    }

    public void pass() throws PassException {
        setCoin(false);
        if (!isLocked()) {
            setStatus(Status.LOCKED);

        } else {
            throw new PassException("Paso cuando ya esta bloqueada");
        }
    }

    public Status getStatus() {
        return status;
    }

    public boolean isCoin() {
        return coin;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCoin(boolean coin) {
        this.coin = coin;
    }

    public boolean isLocked() {
        return status == Status.LOCKED;
    }
}
