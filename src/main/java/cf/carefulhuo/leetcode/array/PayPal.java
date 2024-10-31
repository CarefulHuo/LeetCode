package cf.carefulhuo.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hwy
 * @version 1.0.0
 * @description 金额拆分
 * @date 2023/3/2318:59
 */
public class PayPal {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<>();
		Account resAccount1 = new Account("账户1", 80);
		Account resAccount2 = new Account("账户2", 20);
		Account resAccount3 = new Account("账户3", 30);
		accounts.add(resAccount2);
		accounts.add(resAccount3);
		accounts.add(resAccount1);
		List<Account> list = assign(100, accounts);
		for (Account account : list
		) {
			System.out.println(account.getName() + " : " + account.getAmount());
		}

	}


	public static List<Account> assign(double totalAmount, List<Account> accounts) {
		double diff = totalAmount;
		List<Account> resList = new ArrayList<>();
		List<Account> accountList = accounts.stream().sorted(Comparator.comparing(Account::getAmount).reversed()).collect(Collectors.toList());
		for (Account account : accountList
		) {
			if ((diff = diff - account.getAmount()) > 0) {
				Account resAccount = new Account(account.getName(), account.getAmount());
				resList.add(resAccount);
			} else if (diff < 0) {
				Account resAccount = new Account(account.getName(), account.getAmount() + diff);
				resList.add(resAccount);
				break;
			} else {
				break;
			}
		}
		return resList;

	}

	static class Account {
		String name;
		double amount;

		public Account(String name, double amount) {
			this.name = name;
			this.amount = amount;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Account{" +
					"name='" + name + '\'' +
					", amount=" + amount +
					'}';
		}
	}
}
