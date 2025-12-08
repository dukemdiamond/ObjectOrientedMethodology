import java.util.ArrayList;
import java.util.List;

/**
 * Shared code amongst most expense report implementations.
 * Currently, only the calculation of the reimbursement is left to the
 * concrete subclasses.
 */
abstract class AbstractExpenseReport implements ExpenseReport
{

  protected final List<Expense> expensesToReimburse;

  AbstractExpenseReport()
  {
    this.expensesToReimburse = new ArrayList<>();
  }

  @Override
  public void addExpense(Expense expense)
  {
    if (expense == null)
    {
      throw new IllegalArgumentException("Cannot add null expense");
    }
    if (!this.expensesToReimburse.contains(expense))
    {
      this.expensesToReimburse.add(expense);
    } else
    {
      throw new IllegalArgumentException("Cannot add same expense twice");
    }
  }

  @Override
  public abstract double totalReimbursement();

  @Override
  public double totalCost()
  {
    double answer = 0.0;
    for (Expense expense : expensesToReimburse)
    {
      answer += expense.totalCost();
    }
    return answer;
  }

  @Override
  public Expense findItemByName(String name)
  {
    for (Expense expense : expensesToReimburse)
    {
      if (expense.name().equals(name))
      {
        return expense;
      }
    }
    throw new IllegalStateException("No such expense called \"" + name + "\"");
  }

  @Override
  public List<Expense> expenses()
  {
    return new ArrayList<>(expensesToReimburse);
  }
}