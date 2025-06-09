package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ponto {
    private int id;
    private long cpf;
    private LocalDate data;
    private LocalTime HorarioEntradaM;
    private LocalTime HorarioSaidaM;
    private LocalTime HorarioEntradaV;
    private LocalTime HorarioSaidaV;
    
    public Ponto(int id,long cpf , LocalDate data, LocalTime horaEntradaM, LocalTime horaSaidaM, LocalTime horaEntradaV, LocalTime horaSaidaV) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.HorarioEntradaM = horaEntradaM;
        this.HorarioSaidaM = horaSaidaM;
        this.HorarioEntradaV = horaEntradaV;
        this.HorarioSaidaV = horaSaidaV;
    }

    public LocalTime getHoraEntradaV() {
        return HorarioEntradaV;
    }

    public void setHoraEntradaV(LocalTime horaEntradaV) {
        this.HorarioEntradaV = horaEntradaV;
    }

    public LocalTime getHoraSaidaV() {
        return HorarioSaidaV;
    }

    public void setHoraSaidaV(LocalTime horaSaidaV) {
        this.HorarioSaidaV = horaSaidaV;
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
        return HorarioEntradaM;
    }

    public void setHoraEntradaM(LocalTime horaEntradaM) {
        this.HorarioEntradaM = horaEntradaM;
    }

    public LocalTime getHoraSaidaM() {
        return HorarioSaidaM;
    }

    public void setHoraSaidaM(LocalTime horaSaidaM) {
        this.HorarioSaidaM = horaSaidaM;
    }
    }