package org.serratec.java2backend.projeto03.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto03.dominio.Conta;
import org.serratec.java2backend.projeto03.exception.ContaNotFoundException;
import org.serratec.java2backend.projeto03.exception.OperacaoInvalidaException;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	public ContaService() {

		contas.add(new Conta(1, "Batman", 8000));
		contas.add(new Conta(2, "Robin", 1000));
		contas.add(new Conta(3, "Coringa", 5000));

	}

	private List<Conta> contas = new ArrayList<Conta>();
	int contador = 3;

	private Conta findConta(Integer id) throws ContaNotFoundException {

		Conta contaExistente = null;

		for (Conta conta : contas) {
			if (conta.getNumero().equals(id)) {
				contaExistente = conta;
				break;
			}
		}

		if (contaExistente == null) {
			throw new ContaNotFoundException(id);
		}

		return contaExistente;
	}

	public List<Conta> listaTodos() {
		return this.contas;
	}

	public Conta getConta(Integer id) throws ContaNotFoundException {

		Conta conta = this.findConta(id);
		return conta;
	}

	public Conta criaConta(Conta conta) {

		Conta obj = new Conta(++contador, conta.getTitular(), conta.getSaldo());
		contas.add(obj);
		return obj;
	}

	public Conta atualizaConta(Conta newConta, Integer id) throws ContaNotFoundException {

		Conta conta = this.findConta(id);
		conta.setTitular(newConta.getTitular());
		conta.setNumero(newConta.getNumero());

		return conta;

	}

	public Conta operacaoConta(Conta contaValor,Integer id,String operacao) 
			throws ContaNotFoundException {

		if (operacao.equals("deposito")) {
			Conta conta = this.findConta(id);
			conta.deposito(contaValor.getSaldo());
			return conta;
		}
		if (operacao.equals("saque")) {
			Conta conta = this.findConta(id);
			conta.saque(contaValor.getSaldo());
			return conta;
		}
		else
			throw new OperacaoInvalidaException(operacao);
	}


	public void apagaConta(Integer id) throws ContaNotFoundException {

		Conta conta = this.findConta(id);

		contas.remove(conta);

	}
}
