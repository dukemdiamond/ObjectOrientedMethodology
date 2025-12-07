import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardCatalog implements LibraryCatalog
{

  private final Map<MediaItem, Boolean> catalog;

  public StandardCatalog()
  {
    this.catalog = new HashMap<>();
  }

  @Override
  public void addItem(MediaItem item)
  {
    ensureNonNull(item);
    if (catalog.containsKey(item))
    {
      throw new IllegalArgumentException("Item already exists");
    }
    catalog.put(item, true);
  }

  @Override
  public boolean hasItem(MediaItem item)
  {
    ensureNonNull(item);
    return catalog.containsKey(item);
  }

  @Override
  public List<MediaItem> search(SearchFilter filter)
  {
    ensureNonNull(filter);
    ensureCatalogNotEmpty();

    List<MediaItem> results = new ArrayList<>();
    for (MediaItem item : catalog.keySet())
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
  public void checkOut(MediaItem item)
  {
    ensureNonNull(item);
    ensureItemExists(item);
    if (!catalog.get(item))
    {
      throw new IllegalStateException("Item already checked out");
    }
    catalog.put(item, false);
  }

  @Override
  public void returnItem(MediaItem item)
  {
    ensureNonNull(item);
    ensureItemExists(item);
    if (catalog.get(item))
    {
      throw new IllegalStateException("Item not checked out");
    }
    catalog.put(item, true);
  }

  @Override
  public boolean isAvailable(MediaItem item)
  {
    ensureNonNull(item);
    ensureItemExists(item);
    return catalog.get(item);
  }

  @Override
  public int totalItems()
  {
    return catalog.size();
  }

  @Override
  public int availableItems()
  {
    int count = 0;
    for (Boolean available : catalog.values())
    {
      if (available)
      {
        count++;
      }
    }
    return count;
  }

  protected List<MediaItem> getAllItems()
  {
    return new ArrayList<>(catalog.keySet());
  }

  protected Map<MediaItem, Boolean> getCatalogCopy()
  {
    return new HashMap<>(catalog);
  }

  private void ensureNonNull(Object obj)
  {
    if (obj == null)
    {
      throw new IllegalArgumentException("Argument cannot be null");
    }
  }

  private void ensureCatalogNotEmpty()
  {
    if (catalog.isEmpty())
    {
      throw new IllegalStateException("Catalog is empty");
    }
  }

  private void ensureItemExists(MediaItem item)
  {
    if (!catalog.containsKey(item))
    {
      throw new IllegalArgumentException("Item not in catalog");
    }
  }
}