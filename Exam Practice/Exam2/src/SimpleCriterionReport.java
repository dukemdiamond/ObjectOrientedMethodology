import java.util.ArrayList;
import java.util.List;

public class SimpleCriterionReport implements CriterionExpenseReport
{
  private List<Expense> expenses;
  private ExpenseReport expenseReport;

  public SimpleCriterionReport(ExpenseReport expenseReport)
  {
    if (expenseReport == null)
    {
      throw new IllegalArgumentException("Cannot have a null expenseReport");
    }
    this.expenseReport = expenseReport;
    expenses = new ArrayList<>();
  }

  @Override
  public List<Expense> findExpenses(Criteria criteria)
  {
    ArrayList<Expense> result = new ArrayList<>();
    for (Expense expense : expenseReport.expenses())
    {
      if (criteria.shouldInclude(expense))
      {
        result.add(expense);
      }
    }
    return result;
  }

  @Override
  public void addExpense(Expense expense)
  {
    expenseReport.addExpense(expense);
  }

  @Override
  public double totalReimbursement()
  {
    return expenseReport.totalReimbursement();
  }

  @Override
  public double totalCost()
  {
    return expenseReport.totalCost();
  }

  @Override
  public Expense findItemByName(String name)
  {
    return expenseReport.findItemByName(name);
  }

  @Override
  public List<Expense> expenses()
  {
    return expenses;
  }
}
