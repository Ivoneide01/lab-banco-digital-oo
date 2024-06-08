
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = 0.0; // Inicializa o saldo com zero
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;

		if (valor <= 0) {
            System.out.println("Erro: Valor de saque inválido.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente.");
            return;
        }
        this.saldo -= valor;
        System.out.println("Saque de " + valor + " realizado com sucesso. Novo saldo: " + this.saldo);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;

		if (valor <= 0) {
            System.out.println("Erro: Valor de depósito inválido.");
            return;
        }
        this.saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso. Novo saldo: " + this.saldo);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		// Deposita o valor na conta de destino
		contaDestino.depositar(valor);


		// Verifica se o valor é válido
		if (valor <= 0) {
			System.out.println("Erro: Valor de transferência inválido.");
			return;
		}
		
		System.out.println("Transferência de " + valor + " para conta destino realizada com sucesso.");
		System.out.println("Novo saldo na conta de origem: " + this.getSaldo());

		contaDestino.depositar(valor);

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
