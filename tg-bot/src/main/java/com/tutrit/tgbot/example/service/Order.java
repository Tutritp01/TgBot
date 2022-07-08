package com.tutrit.tgbot.example.service;

import com.tutrit.tgbot.example.constants.OrderStatus;

public class Order {

	private OrderStatus orderStatus;

	public Order(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus(OrderStatus orderStatus) {
		String status;
		switch (orderStatus) {
			case REQUEST:
				status = "Заявка";
			case REGISTRATION:
				status = "Оформление";
			case IN_PROGRESS:
				status = "В работе";
			case WAITING_FOR_PARTS:
				status = "Ожидание З/Ч";
			case WAITING_FOR_CLIENT_APPROVE:
				status = "Согласование";
			case JOB_IS_DONE:
				status = "Работы окончены";
			case ORDER_COMPLETE:
				status = "Выполнен";
			case CLOSED:
				status = "Закрыт";
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + orderStatus);
		}
		return status;
	}
}
