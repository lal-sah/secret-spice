package examples.jmockit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.junit.Test;

import examples.jmockit.service.AccountService;

public class AccountImplTest {

	@Test
	public void test_canary() {
		assertFalse(true == false);
	}

	@Test
	public void testGetBalance_using_non_strict_expecations(
			@Mocked final AccountService accountService) {
		Account account = new AccountImpl();
		Deencapsulation.setField(account, accountService);

		// record expectations: mock behavior
		new NonStrictExpectations() {
			{
				accountService.getBalance();
				returns(100.0);
			}
		};

		// replay: test call method
		assertEquals(100.0, account.getBalance(), 0.0);

		// verify invocations
		new Verifications() {
			{
				accountService.getBalance();
				times = 1;
			}
		};
	}

	@Test
	public void testGetBalance_using_strict_expecations(
			@Mocked final AccountService accountService) {
		Account account = new AccountImpl();
		Deencapsulation.setField(account, accountService);

		// record expectations: mock behavior
		new Expectations() {
			{
				accountService.getBalance();
				returns(100.0);
			}
		};

		// replay: test call method
		assertEquals(100.0, account.getBalance(), 0.0);

		// no need to verify invocations again; having strict expectations means
		// all methods recorded must be called otherwise the test would have
		// failed
	}

	@Test
	public void testDeposit() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithdraw() {
		fail("Not yet implemented");
	}

}
