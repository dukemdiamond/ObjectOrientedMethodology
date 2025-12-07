import java.util.ArrayList;
import java.util.List;

public class SimpleReadingList implements ReadingLists
{
  private final String name;
  private final LibraryCatalog lc;
  private List<MediaItem> readingList;

  public SimpleReadingList(String name, LibraryCatalog catalog)
  {
    if (name == null)
    {
      throw new IllegalArgumentException("Cannot be null name.");
    }
    this.name = name;
    this.lc = catalog;
    readingList = new ArrayList<>();
  }

  @Override
  public void add(MediaItem item)
  {
    if (!lc.hasItem(item) || item == null)
    {
      throw new IllegalArgumentException("Can't");
    }
    readingList.add(item);
  }

  @Override
  public void remove(MediaItem item)
  {
    if (!readingList.contains(item) || item == null)
    {
      throw new IllegalArgumentException("Can't");
    }
    readingList.remove(item);
  }

  @Override
  public String getName()
  {
    return this.name;
  }

  @Override
  public int getSize()
  {
    return readingList.size();
  }

  @Override
  public List<MediaItem> getItems(SearchFilter filter)
  {
    List<MediaItem> results = new ArrayList<>();
    for (MediaItem item : readingList)
    {
      if (filter.matches(item))
      {
        results.add(item);
      }
    }

    if (results.isEmpty())
    {
      throw new IllegalStateException("No items match filter");
    }

    results.sort(MediaItem::compareTo);
    return results;
  }

  @Override
  public boolean isOnList(MediaItem item)
  {
    return readingList.contains(item);
  }
}
