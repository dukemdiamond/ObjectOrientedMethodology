import java.util.List;

public interface ReadingLists
{

  void add(MediaItem item);

  void remove(MediaItem item);

  String getName();

  int getSize();

  List<MediaItem> getItems(SearchFilter filter);

  boolean isOnList(MediaItem item);
}
