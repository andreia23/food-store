package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.domain.PaymentType;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.Editor;
import br.edu.ifpb.padroes.service.mail.EmailNotificationListener;
import br.edu.ifpb.padroes.service.payment.PaymentService;

public class OrderManager {

	public OrderManager(Order order) {
		this.order = order;
	}

	private Order order;

	Editor editor = new Editor();
	private PaymentService paymentService = new PaymentService();

	private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));

	public void payOrder(PaymentType paymentType) {
		order.setStatus(Order.OrderStatus.IN_PROGRESS);
		try {
			paymentService.definePayment(paymentType);
			order.setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
			editor.events.subscribe("save", new EmailNotificationListener("contact@food-store.com",
					String.format("Order %d completed successfully", order.getId())));

			logService.info("payment finished");
		} catch (Exception e) {
			logService.error("payment refused");
			order.setStatus(Order.OrderStatus.PAYMENT_REFUSED);
			editor.events.subscribe("save", new EmailNotificationListener("contact@food-store.com",
					String.format("Order %d completed successfully", order.getId())));
		}
	}

	public void cancelOrder() {
		order.setStatus(Order.OrderStatus.CANCELED);
		editor.events.subscribe("save", new EmailNotificationListener("contact@food-store.com",
				String.format("Order %d completed successfully", order.getId())));
		logService.debug(String.format("order %d canceled", order.getId()));
	}

}
