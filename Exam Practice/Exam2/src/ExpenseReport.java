import java.util.List;

/**
 * Expense reports are collections of expenses.
 * Behaviors are mostly observations to automate common requests on those collections.
 */
public interface ExpenseReport
{

  /**
   * Adds a single expense to the report.
   *
   * @param expense the expense to add to the report
   * @throws IllegalArgumentException if expense is null or already in the report
   */
  void addExpense(Expense expense);

  /**
   * Returns the amount of money that can be reimbursed with the expenses in the form.
   * Note this number can have more than two decimal places to prevent rounding error.
   *
   * @return the total amount of money that can be repaid
   */
  double totalReimbursement();

  /**
   * Returns the total cost of all expenses, including any tax paid on them.
   * Note this number can have more than two decimal places to prevent rounding error.
   *
   * @return the total cost of all expenses
   */
  double totalCost();

  /**
   * Returns the first expense that has the exact given name.
   *
   * @param name the name of the expense to find
   * @return the first expense found with that name
   * @throws IllegalStateException if no expense with the given name can be found
   */
  Expense findItemByName(String name);

  /**
   * Returns a list of all expenses in the report. If there are no expenses, the list is empty.
   *
   * @return list of expenses in the report.
   */
  List<Expense> expenses();
}