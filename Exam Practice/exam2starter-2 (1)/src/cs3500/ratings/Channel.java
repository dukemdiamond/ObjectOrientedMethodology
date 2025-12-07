public interface Channel
{
  void add(Show show);

  String getName();

  double getAverageRating();

  double getAverageRating(FilterCriteria criteria);

  
}
