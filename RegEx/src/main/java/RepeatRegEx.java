public class RepeatRegEx extends AbstractRegex
{
  private final AbstractRegex repeat;

  @Override
  protected int matches(String str, int startIdx)
  {
    // since repeat can match anywhree from 0 to (str.length - startIdx, we can't promise one answer)
    return 0;
  }
}
