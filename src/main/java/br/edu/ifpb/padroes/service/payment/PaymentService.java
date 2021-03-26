package br.edu.ifpb.padroes.service.payment;

import br.edu.ifpb.padroes.domain.Payment;
import br.edu.ifpb.padroes.domain.PaymentType;
import br.edu.ifpb.padroes.strategy.PaymentMethodStrategy;

public class PaymentService {

	public PaymentService() {

	}

	public PaymentService(PaymentMethodStrategy paymentMethodStrategy) {
		this.paymentMethodStrategy = paymentMethodStrategy;
	}

	private PaymentMethodStrategy paymentMethodStrategy;

	public Payment definePayment(PaymentType type) {
		return paymentMethodStrategy.definePayment(type);
	}

}
