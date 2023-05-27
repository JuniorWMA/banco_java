package banco;

public interface InterfaceConta {
    public void saque(Double valor);
    public void deposito(int numeroConta, Double valor);
    public void transferencia(Conta numeroConta, Conta contaDestino, Double valor);
    public String extrato();
}
