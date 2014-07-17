package examples.jmockit.service;

public class ServiceFactory {
	private static final AccountService ACCOUNT_SERVICE = new AccountServiceImpl();

	public static AccountService getAccountService() {
		return ACCOUNT_SERVICE;
	}

}
