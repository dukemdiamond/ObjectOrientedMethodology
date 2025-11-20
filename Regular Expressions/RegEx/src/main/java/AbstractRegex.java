abstract class AbstractRegex implements RegularExpression
{

  protected abstract int matches(String str, int startIdx);

  public boolean match(String str)
  {
    return matches(str, 0) == str.length();
  }
}
