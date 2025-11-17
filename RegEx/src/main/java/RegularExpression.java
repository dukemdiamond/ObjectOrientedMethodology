/**
 * Write an interface for regular expressions
 * and write down the classes that will implement that interface.
 */
public interface RegularExpression
{


  boolean alternate(RegularExpression r1, RegularExpression r2);

  boolean repeats(RegularExpression r1);


}

