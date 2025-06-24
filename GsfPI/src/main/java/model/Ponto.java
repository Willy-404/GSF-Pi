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
    private LocalTime HorarioEntradaEx;
    private LocalTime HorarioSaidaEx;
    private float SalarioDoDia;

    public Ponto(int id,long cpf , LocalDate data, LocalTime horaEntradaM, LocalTime horaSaidaM, LocalTime horaEntradaV, LocalTime horaSaidaV, LocalTime horaEntradaEx, LocalTime horaSaidaEx, float salario) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.HorarioEntradaM = horaEntradaM;
        this.HorarioSaidaM = horaSaidaM;
        this.HorarioEntradaV = horaEntradaV;
        this.HorarioSaidaV = horaSaidaV;
        this.HorarioEntradaEx = horaEntradaEx;
        this.HorarioSaidaEx = horaSaidaEx;
        this.SalarioDoDia = salario;
    }
 
    public float getSalarioDoDia() {
        return SalarioDoDia;
    }

    public void setSalarioDoDia(float SalarioDoDia) {
        this.SalarioDoDia = SalarioDoDia;
    }
    
    public LocalTime getHorarioEntradaEx() {
        return HorarioEntradaEx;
    }

    public void setHorarioEntradaEx(LocalTime HorarioEntradaEx) {
        this.HorarioEntradaEx = HorarioEntradaEx;
    }

    public LocalTime getHorarioSaidaEx() {
        return HorarioSaidaEx;
    }

    public void setHorarioSaidaEx(LocalTime HorarioSaidaEx) {
        this.HorarioSaidaEx = HorarioSaidaEx;
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