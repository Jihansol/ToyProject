package cover.web.securingweb.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accounts;
	

	@GetMapping("/create")
	public Account create() {
		Account account = new Account();
		account.setEmail("hansol@suresofttech.com");
		account.setPassword("password");
		
		return accounts.save(account);
	}

	
}
