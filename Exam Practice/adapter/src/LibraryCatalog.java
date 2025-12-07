import java.util.List;

public interface LibraryCatalog
{

  void addItem(MediaItem item);

  boolean hasItem(MediaItem item);

  List<MediaItem> search(SearchFilter filter);

  void checkOut(MediaItem item);

  void returnItem(MediaItem item);

  boolean isAvailable(MediaItem item);

  int totalItems();

  int availableItems();
}