package br.edu.ifpb.padroes.strategy;

import br.edu.ifpb.padroes.domain.Payment;
import br.edu.ifpb.padroes.domain.PaymentType;

public class StrategyPaymentBillet implements PaymentMethodStrategy {

	public Payment definePayment(PaymentType type) {
		System.out.println("Do billet payment!");
		return null;
	}

}
