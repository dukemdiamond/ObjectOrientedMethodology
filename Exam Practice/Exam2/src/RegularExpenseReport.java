/**
 * An expense report which calculates reimbursement with tax included.
 */
public class RegularExpenseReport extends AbstractExpenseReport
{

  /**
   * Returns the total cost of expenses with their tax included. This is how
   * this form calculates the reimbursement (the amount to be repaid).
   * NOTE we had to add Javadocs to this method because the implementation does
   * something more specific than what the interface claims.
   *
   * @return the reimbursement for the contained expenses
   */
  @Override
  public double totalReimbursement()
  {
    double answer = 0.0;
    for (Expense expense : expensesToReimburse)
    {
      answer += expense.totalCost();
    }
    return answer;
  }
}