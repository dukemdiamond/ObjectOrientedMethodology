/**
 * Expenses are assumed to be labeled with a name describing the expense.
 * Of note, the cost of an expense can be obtained with or without tax.
 * Two expenses are considered the same if they have the same name.
 * <p>
 * All monetary values are assumed to be in US dollars and cents.
 */
public interface Expense
{
  /**
   * Return the name associated with this expense
   *
   * @return the name for this expense
   */
  String name();

  /**
   * Returns the cost with tax of this expense
   *
   * @return total cost of the expense including tax
   */
  double totalCost();

  /**
   * Returns the cost of this expense without tax
   *
   * @return total cost of the expense without tax
   */
  double subtotal();
}