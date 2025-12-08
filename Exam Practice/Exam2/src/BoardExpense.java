import java.util.Objects;

/**
 * An expense for room and board. Assumes board is bought at a rated price over
 * some number of days.
 */
public final class BoardExpense implements Expense
{

  private final String name;
  private final double totalCost;
  private final double rate;
  private final int duration;

  /**
   * Creates a board expense for the given duration. Cost is calculated
   * using the duration and rate per day.
   *
   * @param name        name of the expense
   * @param rate        rate per unit of the stay
   * @param duration    how long the stay was
   * @param taxedAmount the amount paid in taxes for the entire stay
   */
  public BoardExpense(String name, double rate, int duration, double taxedAmount)
  {
    this.name = name;
    this.rate = rate;
    this.duration = duration;
    this.totalCost = this.subtotal() + taxedAmount;
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
    return this.rate * duration;
  }

  @Override
  public boolean equals(Object other)
  {
    if (other == this)
    {
      return true;
    }

    if (!(other instanceof BoardExpense))
    {
      return false;
    }

    BoardExpense that = (BoardExpense) other;
    return this.name.equals(that.name);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(this.name);
  }
}