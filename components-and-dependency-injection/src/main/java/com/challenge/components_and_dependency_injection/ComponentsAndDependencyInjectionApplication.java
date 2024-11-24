package com.challenge.components_and_dependency_injection;

import com.challenge.components_and_dependency_injection.entities.Order;
import com.challenge.components_and_dependency_injection.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ComponentsAndDependencyInjectionApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentsAndDependencyInjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("---- ENTRADA ----");
		System.out.print("Código do pedido: ");
		int code = sc.nextInt();
		System.out.print("Valor básico: ");
		double basic = sc.nextDouble();
		System.out.print("Porcentagem de desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println("---- SAIDA ----");
		System.out.println("Pedido do código: " + order.getCode());
		System.out.println("Valor total: " + orderService.total(order));

		sc.close();
	}
}
