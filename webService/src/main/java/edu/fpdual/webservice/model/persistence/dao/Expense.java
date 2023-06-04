package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Expense implements Comparable<Expense>{
    private int expenseId;
    private int budgetId;
    private String expenseName;
    private String description;
    private int categoryId;
    private double amount;
    private boolean isRecurrent;
    private Timestamp creationDate;

    public Expense (ResultSet result) {
        try {
            this.expenseId = result.getInt("expenseId");
            this.budgetId = result.getInt("budgetId");
            this.expenseName = result.getString("expenseName");
            this.description = result.getString("description");
            this.categoryId = result.getInt("categoryId");
            this.amount = result.getDouble("amount");
            this.isRecurrent = result.getBoolean("isRecurrent");
            this.creationDate = result.getTimestamp("creationDate");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Expense o) {
        return this.expenseId - o.expenseId;
    }
}
