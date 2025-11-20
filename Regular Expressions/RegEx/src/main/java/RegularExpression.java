/**
 * Write an interface for regular expressions
 * and write down the classes that will implement that interface.
 */
public interface RegularExpression
{
  /**
   * Checks if there is a match.
   *
   * @param regex the regex as a string
   * @return true if it is a match, false otherwise
   */
  boolean match(String regex);

}

