import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfig {

	@Bean(name="person123")
	public Person getPerson(){
		Person person = new Person("Bruno");
		person.setPhoneNumber("085289704");
		return person;
	}
	
	@Bean(initMethod="testInit")
	public BankAccount getBankAcc(){
		BankAccount ba = new BankAccount();
		ba.setBankName("AIB");
		return ba;
	}
	
}
