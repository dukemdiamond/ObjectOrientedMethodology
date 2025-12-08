import java.util.Objects;

/**
 * Shared implementation details of most expense types.
 */
abstract class AbstractGeneralExpense implements Expense
{

  private final String name;
  private final double totalCost;
  private final double subtotal;

  /**
   * Creates a food expense with the associated name and costs.
   *
   * @param name        name of the expense
   * @param totalCost   total dollar cost of expense with tax
   * @param taxedAmount dollar amount paid in tax
   */
  AbstractGeneralExpense(String name, double totalCost, double taxedAmount)
  {
    this.name = name;
    this.totalCost = totalCost;
    this.subtotal = totalCost - taxedAmount;
  }

  @Override
  public String name()
  {
    return this.name;
  }

  @Override
  public double totalCost()
  {
    return this.totalCost;
  }

  @Override
  public double subtotal()
  {
    return this.subtotal;
  }

  //We don't override equals to prevent different subclasses from being equal
  //to each other.
  @Override
  public abstract boolean equals(Object other);

  @Override
  public int hashCode()
  {
    return Objects.hash(name);
  }
}