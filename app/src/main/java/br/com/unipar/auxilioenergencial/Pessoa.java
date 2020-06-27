package br.com.unipar.auxilioenergencial;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.YEAR;


public class Pessoa{

    private String cpf;
    private Date dataNascimento;
    private double rendaMensal;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    // Calcula a Idade
    public int calculaIdade(Date dataNasc){

        Calendar dataUsuario = new GregorianCalendar();
        dataUsuario.setTime(dataNasc);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int idade = today.get(Calendar.YEAR) - dataUsuario.get(Calendar.YEAR);
        dataUsuario.add(Calendar.YEAR, idade);

        return idade;
    }

    // calcula data futura pagamento
    public String calcularDataPagamento(Date dataNasc){

        // Através do Calendar, trabalhamos a data informada e adicionamos 1 dia nela
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNasc);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // estrai ano, mes, dia
        int ano = today.get(Calendar.YEAR);
        int mesInt = dateOfBirth.get(Calendar.MONDAY) + 1;
        int diaInt  = dateOfBirth.get(Calendar.DAY_OF_MONTH) + 20;

        // condicao para dia, se for maior que 31 muda  o mes
        if(diaInt > 31){
            int diaSobra = diaInt - 31;
            diaInt = 0;
            mesInt = dateOfBirth.get(Calendar.MONDAY) + 2;
            diaInt  = diaInt + diaSobra;
        }

        // condicao para mes, se for maior que 12 muda ano
        if(mesInt > 12){
            int mesSobra = mesInt - 12;
            mesInt = 0;
            ano = ano + 1;
            mesInt = mesInt + mesSobra;
        }

        // pasa para string
        String mes = Integer.toString(mesInt);
        String dia = Integer.toString(diaInt);

        String dataPagamento = "";

        // condicao para dia, se for menor que 9 acresenta 0
        if(Integer.parseInt(dia) <= 9){
            dataPagamento += "0";
        }

        dataPagamento += dia;
        dataPagamento += "/";

        // condicao para mes, se for menor que 9 acresenta 0
        if(Integer.parseInt(mes) <= 9){
            dataPagamento += "0";
        }

        dataPagamento += mes;
        dataPagamento += "/";
        dataPagamento += ano;

        return  dataPagamento;
    }

    // calcula volor a receber
    public double saldoReceber(double valor){

        double saldoTotal = (valor * 70) / 100;

        if(saldoTotal >= 475){
            saldoTotal = 475;
        }
        return saldoTotal;
    }

    // converte data string para date
    public Date converterData(String data){

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataConvertida = null;
        try {
            dataConvertida = format.parse(String.valueOf(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataConvertida;
    }
}

