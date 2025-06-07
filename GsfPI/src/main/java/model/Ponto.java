package model;

import java.sql.Time;
import java.time.LocalDate;

public class Ponto {
    private int id;
    private long cpf;
    private LocalDate data;
    private Time horaEntradaM;
    private Time horaSaidaM;
    private Time horaEntradaV;
    private Time horaSaidaV;
    
    public Ponto(int id,long cpf , LocalDate data, Time horaEntradaM, Time horaSaidaM, Time horaEntradaV, Time horaSaidaV) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.horaEntradaM = this.horaEntradaM;
        this.horaSaidaM = this.horaSaidaM;
        this.horaEntradaV = this.horaEntradaV;
        this.horaSaidaV = this.horaSaidaV;
    }

    public Time getHoraEntradaV() {
        return horaEntradaV;
    }

    public void setHoraEntradaV(Time horaEntradaV) {
        this.horaEntradaV = horaEntradaV;
    }

    public Time getHoraSaidaV() {
        return horaSaidaV;
    }

    public void setHoraSaidaV(Time horaSaidaV) {
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

    public Time getHoraEntradaM() {
        return horaEntradaM;
    }

    public void setHoraEntradaM(Time horaEntradaM) {
        this.horaEntradaM = horaEntradaM;
    }

    public Time getHoraSaidaM() {
        return horaSaidaM;
    }

    public void setHoraSaidaM(Time horaSaidaM) {
        this.horaSaidaM = horaSaidaM;
    }
    }