package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ponto {
    private int id;
    private long cpf;
    private LocalDate data;
    private LocalTime horaEntradaM;
    private LocalTime horaSaidaM;
    private LocalTime horaEntradaV;
    private LocalTime horaSaidaV;
    
    public Ponto(int id,long cpf , LocalDate data, LocalTime horaEntradaM, LocalTime horaSaidaM, LocalTime horaEntradaV, LocalTime horaSaidaV) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.horaEntradaM = horaEntradaM;
        this.horaSaidaM = horaSaidaM;
        this.horaEntradaV = horaEntradaV;
        this.horaSaidaV = horaSaidaV;
    }

    public LocalTime getHoraEntradaV() {
        return horaEntradaV;
    }

    public void setHoraEntradaV(LocalTime horaEntradaV) {
        this.horaEntradaV = horaEntradaV;
    }

    public LocalTime getHoraSaidaV() {
        return horaSaidaV;
    }

    public void setHoraSaidaV(LocalTime horaSaidaV) {
        this.horaSaidaV = horaSaidaV;
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraEntradaM() {
        return horaEntradaM;
    }

    public void setHoraEntradaM(LocalTime horaEntradaM) {
        this.horaEntradaM = horaEntradaM;
    }

    public LocalTime getHoraSaidaM() {
        return horaSaidaM;
    }

    public void setHoraSaidaM(LocalTime horaSaidaM) {
        this.horaSaidaM = horaSaidaM;
    }
    }