package examples.jmockit;

public interface Account {
	double getBalance();

	void deposit(double amount);

	double withdraw(double amount);
}
