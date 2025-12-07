import java.util.ArrayList;
import java.util.List;

public class SimpleChannel implements Channel
{
  private final String name;
  private final RatingsDatabase db;
  private List<Show> shows;

  public SimpleChannel(String name, RatingsDatabase db)
  {
    if (name == null || db == null)
    {
      throw new IllegalArgumentException("Cannot have null arguments");
    } 

    shows = new ArrayList<>();
    this.name = name;
    this.db = db;
  }

  @Override
  public void add(Show show)
  {
    FilterCriteria filterCriteria;
    if (show == null){
      throw new IllegalArgumentException("Cannot have null show or not in database.")
    }

  }

  @Override
  public String getName()
  {
    return "";
  }

  @Override
  public double getAverageRating()
  {
    return 0;
  }

  @Override
  public double getAverageRating(FilterCriteria criteria)
  {
    return 0;
  }
}
