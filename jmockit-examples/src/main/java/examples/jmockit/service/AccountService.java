package examples.jmockit.service;

public interface AccountService {
	double getBalance();

	void deposit(double amount);

	double withdraw(double amount);
}
