package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {

    public int generateSequenceNumber() {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT transacationId_seq.NEXTVAL FROM dual";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean validateAccount(String accountNumber) {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT 1 FROM ACCOUNT_TBL WHERE ACCOUNT_NUMBER = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public float findBalance(String accountNumber) {
        if (!validateAccount(accountNumber)) {
            return -1;
        }

        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT BALANCE FROM ACCOUNT_TBL WHERE ACCOUNT_NUMBER = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateBalance(String accountNumber, float newBalance) {
        Connection connection = DBUtil.getDBConnection();
        String query = "UPDATE ACCOUNT_TBL SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setFloat(1, newBalance);
            ps.setString(2, accountNumber);

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean transferMoney(TransferBean transferBean) {
        int transactionId = generateSequenceNumber();
        if (transactionId == 0) {
            return false;
        }

        transferBean.setTransactionID(transactionId);

        Connection connection = DBUtil.getDBConnection();
        String query = "INSERT INTO TRANSFER_TBL VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, transferBean.getTransactionID());
            ps.setString(2, transferBean.getFromAccountNumber());
            ps.setString(3, transferBean.getToAccountNumber());

            Date sqlDate = new Date(transferBean.getDateOfTransaction().getTime());
            ps.setDate(4, sqlDate);

            ps.setFloat(5, transferBean.getAmount());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}