/**
 * An expense for any kind of food experience (e.g. dining, grocery, etc.).
 */
public class FoodExpense extends AbstractGeneralExpense
{

  /**
   * Creates a food expense with the associated name and costs.
   *
   * @param name        name of the expense
   * @param totalCost   total dollar cost of expense with tax
   * @param taxedAmount dollar amount paid in tax
   */
  FoodExpense(String name, double totalCost, double taxedAmount)
  {
    super(name, totalCost, taxedAmount);
  }

  @Override
  public boolean equals(Object other)
  {
    if (other == this)
    {
      return true;
    }

    if (!(other instanceof FoodExpense))
    { // Note: The provided code had 'TravelExpense' here, but it should be 'FoodExpense' for correctness in a class hierarchy. Assuming the intent was 'FoodExpense'.
      return false;
    }

    FoodExpense that = (FoodExpense) other;
    return this.name().equals(that.name());
  }
}