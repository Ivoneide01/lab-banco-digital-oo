import java.util.Scanner;

public class Main {

public static void main(String[] args) {
        // Criando um objeto Scanner para receber entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Criando um cliente
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        // Criando contas para o cliente
        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        // Solicitando e realizando o depósito na conta corrente
        System.out.print("Digite o valor a depositar na conta corrente: ");
        double valorDeposito = scanner.nextDouble();
        cc.depositar(valorDeposito);


        // Solicitando e realizando a transferência da conta corrente para a conta poupança
        System.out.print("Digite o valor a transferir da conta corrente para a poupança: ");
        double valorTransferencia = scanner.nextDouble();
        cc.transferir(valorTransferencia, poupanca);

		        // Solicitando e realizando o saque da conta corrente
        System.out.print("Digite o valor a sacar da conta corrente: ");
        double valorSaque = scanner.nextDouble();
        cc.sacar(valorSaque);

// Perguntar se o usuário deseja imprimir o extrato da conta corrente
        System.out.print("Deseja imprimir o extrato da conta corrente? (s/n): ");
        String respostaCC = scanner.next();
        if (respostaCC.equalsIgnoreCase("s")) {
            System.out.println("\nExtrato da conta corrente:");
            cc.imprimirExtrato();
        }

        // Perguntar se o usuário deseja imprimir o extrato da conta poupança
        System.out.print("Deseja imprimir o extrato da conta poupança? (s/n): ");
        String respostaPoupanca = scanner.next();
        if (respostaPoupanca.equalsIgnoreCase("s")) {
            System.out.println("\nExtrato da conta poupança:");
            poupanca.imprimirExtrato();
        }

        // Fechando o Scanner
        scanner.close();
    }

}
