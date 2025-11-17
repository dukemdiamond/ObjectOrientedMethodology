public class SequenceRegEx implements RegularExpression
{
  RegularExpression r1;
  RegularExpression r2;

  public SequenceRegEx(RegularExpression r1, RegularExpression r2)
  {
    this.r1 = r1;
    this.r2 = r2;
  }

  // Why is this hard?
  // Hard to figure out where to start maching for the second regex
  @Override
  public boolean match(String regex)
  {
    
  }
}
