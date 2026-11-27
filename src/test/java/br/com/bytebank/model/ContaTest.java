package br.com.bytebank.model;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTest {
      
      @Test 
      public void deveDepositarValorNaConta() {
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            conta.depositar(new BigDecimal("50.00"));
            assertEquals(new BigDecimal("150.00"), conta.getSaldo());
      }

      @Test
      public void deveRejeitarDepositoZero(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            assertThrows(IllegalArgumentException.class, () -> {
                  conta.depositar(new BigDecimal("0"));

            });
            assertEquals(new BigDecimal("100.00"), conta.getSaldo());

      }

      @Test 
      public void deveRejeitarDepositoNegativo(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            assertThrows(IllegalArgumentException.class, () -> {
                  conta.depositar(new BigDecimal("-50.00"));
            });

            assertEquals(new BigDecimal("100.00"), conta.getSaldo());
      }

      @Test
      public void deveSacarValorDaConta(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            conta.sacar(new BigDecimal("30.00"));

            assertEquals(new BigDecimal("70.00"), conta.getSaldo());
      }

      @Test 
      public void deveRejeitarSaqueMaiorQueSaldo(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            assertThrows(IllegalArgumentException.class, () -> {
                  conta.sacar(new BigDecimal("150.00"));
            });

            assertEquals(new BigDecimal("100.00"), conta.getSaldo());
      }

      @Test 
      public void deveRejeitarSaqueZero(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            assertThrows(IllegalArgumentException.class, () ->{
                  conta.sacar(new BigDecimal("0"));
            });

            assertEquals(new BigDecimal("100.00"), conta.getSaldo());
      }

      @Test 
      public void deveRejeitarSaqueNegativo(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            assertThrows(IllegalArgumentException.class, () -> {
                  conta.sacar(new BigDecimal("-50.00"));
            });

            assertEquals(new BigDecimal("100.00"), conta.getSaldo());
      }

      @Test 
      public void devePermitirSaqueDoSaldoTotal(){
            Conta conta = new Conta(1L, "Luan", new BigDecimal("100.00"));

            conta.sacar(new BigDecimal("100.00"));

            assertEquals(new BigDecimal("0.00"), conta.getSaldo());
      }

      @Test 
      public void devePermitirCriacaoDeContaComSaldoZero(){
            Conta conta = new Conta(1L, "Luan", BigDecimal.ZERO);

            assertEquals(new BigDecimal("0"), conta.getSaldo());
      }

      @Test 
      public void rejeitarCriacaoDeContaComSaldoNegativo(){

            assertThrows(IllegalArgumentException.class, () -> {
                  new Conta(1L, "Luan", new BigDecimal("-100.00"));
            });
      }

      @Test 
      public void deveRejeitarCriacaoDeContaComTitularNulo(){

            assertThrows(IllegalArgumentException.class, () -> {
                  new Conta(1L, null, new BigDecimal("100.00"));
            });
      }

      @Test 
      public void deveRejeitarCriacaoDeContaComTitularEmBranco(){
            assertThrows(IllegalArgumentException.class, () -> {
                  new Conta(1L, "    ", new BigDecimal("100.00"));
            });
      }

      @Test 
      public void deveRejeitarCriacaoDeContaComSaldoNulo(){
            
            assertThrows(IllegalArgumentException.class, () -> {
                  new Conta(1L, "Luan", null);
            });
      }
}
