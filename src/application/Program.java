package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner (System.in);
		
		System.out.println("Informe os dados da conta: ");
		System.out.print("Numero: ");
		int number = input.nextInt();
		System.out.print("Titular: ");
		input.nextLine();
		String holder = input.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = input.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = input.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.println("Informe uma quantia para sacar: ");
		double amount = input.nextDouble();
		
		try {
				acc.withdraw(amount);
				System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		input.close();
	}
}
