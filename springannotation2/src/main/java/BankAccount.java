
public class BankAccount {

	private String bankName = "BOI";

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "BankAccount [bankName=" + bankName + "]";
	}
	
	public void testInit(){
		System.out.println("Testing init-method!");
	}
	
}
