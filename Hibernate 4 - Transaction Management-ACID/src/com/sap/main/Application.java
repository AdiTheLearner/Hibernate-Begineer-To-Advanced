package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sap.pojo.Account;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory oracle_sf = null;
		SessionFactory mysql_sf = null;
		Session oracle_s = null;
		Session mysql_s = null;
		Transaction oracle_tx = null;
		Transaction mysql_tx = null;

		try {
			oracle_sf = HibernateUtil.getOracleSessionFactory();
			oracle_s = oracle_sf.openSession();
			mysql_sf = HibernateUtil.getMysqlSessionFactory();
			mysql_s = mysql_sf.openSession();

			Account source = (Account) oracle_s.get("com.sap.pojo.Account", 2);
			float source_balance = 0.0f;
			source_balance = source.getAccountBalance();
			source_balance = source_balance - 5000.0f;
			source.setAccountBalance(source_balance);

			Account target = (Account) mysql_s.get("com.sap.pojo.Account", 1);
			float target_balance = 0.0f;
			target_balance = target.getAccountBalance();
			target_balance = target_balance + 5000.0f;
			target.setAccountBalance(target_balance);

			oracle_tx = oracle_s.beginTransaction();
			mysql_tx = mysql_s.beginTransaction();
			oracle_s.update(source);
			mysql_s.update(target);
			oracle_tx.commit();
			mysql_tx.commit();
			System.out.println("Amount Transferred");
		} catch (Exception e) {
			e.printStackTrace();
			oracle_tx.rollback();
			mysql_tx.rollback();

		} finally {
			oracle_s.close();
			mysql_s.close();
			oracle_sf.close();
			mysql_sf.close();

		}
	}

}
