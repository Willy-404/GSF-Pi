package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ponto {
    private int id;
    private String nomeFuncionario;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private double horasTrabalhadas;

    public Ponto(int id, String nomeFuncionario, LocalDate data, LocalTime horaEntrada, LocalTime horaSaida, double horasTrabalhadas) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    // Getters e setters
    public int getId() { return id; }
    public String getNomeFuncionario() { return nomeFuncionario; }
    public LocalDate getData() { return data; }
    public LocalTime getHoraEntrada() { return horaEntrada; }
    public LocalTime getHoraSaida() { return horaSaida; }
    public double getHorasTrabalhadas() { return horasTrabalhadas; }

    public void setId(int id) { this.id = id; }
    public void setNomeFuncionario(String nomeFuncionario) { this.nomeFuncionario = nomeFuncionario; }
    public void setData(LocalDate data) { this.data = data; }
    public void setHoraEntrada(LocalTime horaEntrada) { this.horaEntrada = horaEntrada; }
    public void setHoraSaida(LocalTime horaSaida) { this.horaSaida = horaSaida; }
    public void setHorasTrabalhadas(double horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }
}