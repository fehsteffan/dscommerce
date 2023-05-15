package com.program.ecommerce.entity;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TIMESTAMP  WITHOUT TIME ZONE")
	private Instant moment;
	private OrderStatus orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)	
	private Payment payment;	
	
	
	public Order() {	
		
	}	


	public Order(Long id, Instant moment, OrderStatus orderStatus, User client, Payment payment) {
		super();
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Instant getMoment() {
		return moment;
	}



	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}	

}
