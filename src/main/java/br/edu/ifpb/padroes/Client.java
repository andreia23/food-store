package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.domain.PaymentType;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.payment.PaymentService;
import br.edu.ifpb.padroes.strategy.StrategyPaymentCreditCard;

public class Client {
	public static void main(String[] args) {

		PaymentService paymentService = new PaymentService(new StrategyPaymentCreditCard());
		PaymentType payment = new PaymentType("CREDIT_CARD");
		Order order = new Order();
		OrderManager orderManager = new OrderManager(order);
		paymentService.definePayment(payment);
		orderManager.payOrder(payment);
		orderManager.cancelOrder();

	}
}
