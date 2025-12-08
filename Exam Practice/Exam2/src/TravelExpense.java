/**
 * An expense for any kind of travel. Assumes travel is reported as
 * cost instead of a rate over some amount of time.
 */
public final class TravelExpense extends AbstractGeneralExpense
{

  /**
   * Creates a travel expense with the associated name and costs
   *
   * @param name        name of the expense
   * @param totalCost   total dollar cost of expense with tax
   * @param taxedAmount dollar amount paid in tax
   */
  public TravelExpense(String name, double totalCost, double taxedAmount)
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

    if (!(other instanceof TravelExpense))
    {
      return false;
    }

    TravelExpense that = (TravelExpense) other;
    return this.name().equals(that.name());
  }
}