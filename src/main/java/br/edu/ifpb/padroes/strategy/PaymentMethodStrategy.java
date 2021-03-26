package br.edu.ifpb.padroes.strategy;

import br.edu.ifpb.padroes.domain.Payment;
import br.edu.ifpb.padroes.domain.PaymentType;

public interface PaymentMethodStrategy {
	Payment definePayment(PaymentType type);
}
