package cover.web.securingweb.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService{

	private final AccountRepository accounts;
	private final PasswordEncoder passwordEncoder;
	
	public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accounts = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accounts.findByEmail(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(account.getEmail(), account.getPassword(), authorities);
	}
	
	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return accounts.save(account);
	}


}
