import java.util.Locale;
import java.util.Scanner;
import banco.Conta;
import banco.TipoConta;
import cliente.Cliente;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Conta conta = null;
        Cliente cliente = null;

        
        //Abrindo uma conta no banco
        System.out.println("Olá! Seja bem vindo. Deseja abrir uma conta em nosso banco?");
        System.out.println("Digite S para sim e N para não");
        char aberturaConta = sc.nextLine().toUpperCase().charAt(0);

        if (aberturaConta == 'S') {
            System.out.println("Ok, vamos em frente!");  
            
            while (aberturaConta == 'S') {
                
                System.out.println("Vamos precisar de alguns de seus dados. É rápido e fácil!");
                System.out.println("Digite o seu nome:");
                String nome = sc.nextLine();
                System.out.println("Digite o seu cpf:");
                String cpf = sc.nextLine();
                cliente = new Cliente(nome, cpf);
                System.out.println("Numero da conta:");
                int numero = sc.nextInt();
                System.out.println("Numero da agencia:");
                int agencia = sc.nextInt();
                System.out.println("Digite 1 para conta corrente ou outro número para conta poupança");
                int tipoConta = sc.nextInt();
                TipoConta tipo = null;
                if (tipoConta ==1) {
                    tipo = TipoConta.CONTA_CORRENTE;
                }
                conta = new Conta(numero, agencia, tipo, cliente, 0.0);
                System.out.println("Deseja abrir uma nova conta? S/N");
                aberturaConta = sc.next().toUpperCase().charAt(0);
                sc.nextLine();   
            }
        } else{
            System.out.println("Obrigado e volte sempre!");
            return;
        }

        
        System.out.println("""
            Bem vindo ao nosso Banco.

            É muito bom ter você como nosso cliente.

            Deseja fazer alguma operação na sua conta?

            == Digite 1 para saque;

            == Digite 2 para deposito;

            == Digite 3 para transferência

            == Digite 4 para extrato;

            == Digite 0 para sair;
                
            """);
            System.out.println("Digite uma das opções:");
            int menu = sc.nextInt();
            if (menu !=0) {
                while (menu!=0) {
                    if (menu == 1) {
                        System.out.println("Digite um valor");
                        Double valor = sc.nextDouble();
                        conta.saque(valor);
                        System.out.println("Seu novo saldo é de " + conta.getSaldo());
                        System.out.println("Deseja realizar mais uma operação?\n Digite o número escolhido.");
                        menu = sc.nextInt();
    
                        
                    }if (menu == 2) {
                        System.out.println("Digite o número da conta do favorecido");
                        int contaFavorecido = sc.nextInt();
                        System.out.println("Digite um valor");
                        Double valor = sc.nextDouble();
                        conta.deposito(contaFavorecido, valor);
                        System.out.println("Seu novo saldo é " + conta.getSaldo());
                        System.out.println("Deseja realizar mais uma operação?\n Digite o número escolhido.");
                        menu = sc.nextInt();
                    }if (menu == 3) {
                        System.out.println("Digite o número da sua conta");
                        Conta pessoa = null;
                        int contaPessoal = sc.nextInt();
                        pessoa.setNumero(contaPessoal);
                        System.out.println("Digite o número da conta do favorecido");
                        Conta contaFavorecido = null;
                        int contaFavorecidoInt = sc.nextInt();
                        contaFavorecido.setNumero(contaFavorecidoInt);
                        System.out.println("Digite um valor");
                        Double valor = sc.nextDouble();
                        conta.transferencia(pessoa, contaFavorecido, valor);
                        System.out.println("Deseja realizar mais uma operação?\n Digite o número escolhido.");
                        menu = sc.nextInt();
                    }if (menu == 4) {
                        System.out.println("====****=======");
                        System.out.println(conta.extrato());
                        System.out.println("=====----======");
                        System.out.println("Deseja realizar mais uma operação?\n Digite o número escolhido.");
                        menu = sc.nextInt();
                    }if(menu < 0 || menu >=5){
                        System.out.println("Opção inválida.");
                        System.out.println("Deseja realizar mais uma operação?\n Digite o número escolhido.");
                        menu = sc.nextInt();
                    }
                    
                }
                System.out.println("Obrigado e tenha um bom dia!!!");
                return;
            }
                  

            sc.close();
        }
    }


