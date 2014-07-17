package examples.jmockit;

import examples.jmockit.service.AccountService;
import examples.jmockit.service.ServiceFactory;

public class AccountImpl implements Account {

	private AccountService accountService = ServiceFactory.getAccountService();

	@Override
	public double getBalance() {
		return accountService.getBalance();
	}

	@Override
	public void deposit(double amount) {
		accountService.deposit(amount);
	}

	@Override
	public double withdraw(double amount) {
		return accountService.withdraw(amount);
	}

}
