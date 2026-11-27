package br.com.bytebank.model;
import java.math.BigDecimal;

public class Conta {
      private Long id;
      private String titular;
      private BigDecimal saldo;

      public Conta(Long id, String titular, BigDecimal saldo) {
            if (titular == null || titular.isBlank()){
                  throw new IllegalArgumentException("Nome inválido");
            }

            if (saldo == null || saldo.compareTo(BigDecimal.ZERO) < 0){
                  throw new IllegalArgumentException("O valor digitado não pode ser menor que zero ou vazio");
            }

            this.id = id;
            this.titular = titular;
            this.saldo = saldo;
            
      }

      public BigDecimal getSaldo() {
            return this.saldo;
      }

      public void depositar(BigDecimal valor) {
            if (valor.compareTo(BigDecimal.ZERO) <= 0){
                  throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero");
            }
            
            this.saldo = this.saldo.add(valor);
            
            
      }

      public void sacar(BigDecimal valor) {
            if (valor.compareTo(BigDecimal.ZERO) <= 0){
                  throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero");
            }

            if (this.saldo.compareTo(valor) < 0){
                  throw new IllegalArgumentException("O valor não pode ser maior que o saldo");
            }

             
            this.saldo = this.saldo.subtract(valor);
            
      }
}
