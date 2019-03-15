package pkjone;
public class ProjectOne {

	private double balance;
	private int a;
	private boolean depositValidate;
	private boolean withdrawValidate;
	private String pass = ("0000");
	private int count = 0;
	private int countHistory = 0;

	private String[] history = new String[100];

	public String previous() {
		countHistory++;
		return history[count];
	}

	public String next() {

		countHistory++;
		return history[count];
	}

	public boolean passValidate() { // validate the password
		if (pass.equals("0000"))
			return true;
		else
			return false;
	}

	public double getBalance() { // getter balance
		history[count] = ("Balance Inquring" + balance);
		count++;
		return balance;
	}

	public boolean withDraw(double amount) { // function to withdraw
		if (balance >= amount) {
			balance = balance - amount;
			history[count] = ("Withdraw with" + amount);
			count++;
			withdrawValidate = true;
		} else
			withdrawValidate = false;

		return withdrawValidate;
	}

	public boolean deposit(double amount) { // function to deposit

		if (amount > 0) {
			balance += amount;
			depositValidate = true;
			history[count] = ("Deposit with" + amount);
			count++;
		} else
			depositValidate = false;

		return depositValidate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountHistory() {
		return countHistory;
	}

	public void setCountHistory(int countHistory) {
		this.countHistory = countHistory;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
