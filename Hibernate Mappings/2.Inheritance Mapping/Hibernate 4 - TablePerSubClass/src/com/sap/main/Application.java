package com.sap.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sap.pojo.CreditCard;
import com.sap.pojo.DebitCard;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			insertCreditTx(222, "19/2026", 100, "26 sept", 1222, session);
			insertDebitTx(333, "19/2026", 100, "26 sept", 1422, session);
			System.out.println("Transaction Insertion Succesfull");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

	public static void insertCreditTx(int cardNo, String exprDate, int amount, String date, int txId, Session session) {
		session.beginTransaction();

		CreditCard credit = new CreditCard();
		credit.setCardNo(cardNo);
		credit.setExprDate(exprDate);
		credit.setPayAmount(amount);
		credit.setPayDate(date);
		credit.setTxId(txId);
		session.save(credit);
		session.getTransaction().commit();
	}

	public static void insertDebitTx(int cardNo, String exprDate, int amount, String date, int txId, Session session) {
		session.beginTransaction();

		DebitCard debit = new DebitCard();
		debit.setCardNo(cardNo);
		debit.setExprDate(exprDate);
		debit.setPayAmount(amount);
		debit.setPayDate(date);
		debit.setTxId(txId);

		session.save(debit);
		session.getTransaction().commit();
	}

}