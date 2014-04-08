package sendemail;

import org.junit.Test;

public class SendEmailTest {
	@Test
	public void test() {
		new SendEmail("localhost", "avantis@palantir.com", "jessica.liu.taylor@gmail.com", "oink", "oink2");
	}
}
