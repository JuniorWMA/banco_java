package banco;

import cliente.Cliente;
import java.util.Objects;

public class Conta implements InterfaceConta{
    
    private Integer numero;
    private Integer agencia;
    private TipoConta tipoConta;
    private Cliente cliente;
    private Double saldo;
    private String extrato;
   

    public Conta() {
    }


    public Conta(Integer numero, Integer agencia, TipoConta tipoConta, Cliente cliente, Double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.saldo = saldo;
        
    }


    public Integer getNumero() {
        return numero;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public Integer getAgencia() {
        return agencia;
    }


    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }


    public TipoConta getTipoConta() {
        return tipoConta;
    }


    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Double getSaldo() {
        return saldo;
    }


    public String getExtrato() {
        return extrato;
    }


    public void setExtrato(String extrato) {
        this.extrato = extrato;
    }



    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", agencia='" + getAgencia() + "'" +
            ", tipoConta='" + getTipoConta() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", saldo='" + getSaldo() + "'" +"}";
    }


    @Override
    public void saque(Double valor) {
        if (this.saldo >= valor) {
            this.saldo -=valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }


    @Override
    public void deposito(int numeroConta, Double valor) {
        if (this.numero == numeroConta) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        }
    }


    @Override
    public void transferencia(Conta numeroConta, Conta contaDestino, Double valor) {
        if (this.saldo >= valor) {
            numeroConta.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência realizada com sucesso!");
            
        }
        
    }


    @Override
    public String extrato() {
       
       return "{" +
       " numero='" + getNumero() + "'" +
       ", agencia='" + getAgencia() + "'" +
       ", tipoConta='" + getTipoConta() + "'" +
       ", cliente='" + getCliente() + "'" +
       ", saldo='" + getSaldo() + "'" +"}";
    }
   

    
    
}
