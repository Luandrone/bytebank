package br.com.bytebank;

import java.math.BigDecimal;

import br.com.bytebank.model.Conta;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));
        System.out.println(conta.getSaldo());

        try {
            conta.depositar(new BigDecimal("0.00"));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(conta.getSaldo());

        Conta conta2 = new Conta(2L, "Luan", new BigDecimal("100.00"));

        try {
            conta2.sacar(new BigDecimal("150.00"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(conta2.getSaldo());

       
    }
}
