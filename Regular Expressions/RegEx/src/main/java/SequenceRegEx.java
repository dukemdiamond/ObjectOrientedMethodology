public class SequenceRegEx extends AbstractRegex
{
  private final AbstractRegex r1, r2;

  public SequenceRegEx(AbstractRegex r1, AbstractRegex r2)
  {
    this.r1 = r1;
    this.r2 = r2;
  }

  @Override
  protected int matches(String str, int startIdx)
  {
    int r2MatchStart = r1.matches(str, startIdx);
    if (r2MatchStart == -1)
    {
      return -1;
    }
    return r2.matches(str, r2MatchStart);
  }

  @Override
  public boolean match(String regex)
  {
    return false;
  }
}
