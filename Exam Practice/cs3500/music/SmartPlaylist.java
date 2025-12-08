import java.util.ArrayList;
import java.util.List;

public class SmartPlaylist implements SearchablePlaylist
{
  private final Playlist playlist;
  private String name;

  public SmartPlaylist(Playlist playlist)
  {
    if (playlist == null)
    {
      throw new IllegalArgumentException("Playlist cannot be null.");
    }
    this.playlist = playlist;
  }

  @Override
  public List<Song> getSong(SongCriteria sc)
  {
    List<Song> result = new ArrayList<>();
    for (Song song : playlist.getSongs())
    {
      if (sc.shouldInclude(song))
      {
        result.add(song);
      }
    }
    return result;
  }

  @Override
  public void addSong(Song song)
  {
    playlist.addSong(song);

  }

  @Override
  public void removeSong(Song song)
  {
    playlist.removeSong(song);
  }

  @Override
  public int totalDuration()
  {
    return playlist.totalDuration();
  }

  @Override
  public int size()
  {
    return playlist.size();
  }

  @Override
  public List<Song> getSongs()
  {
    return playlist.getSongs();
  }

  @Override
  public boolean contains(Song song)
  {
    return playlist.contains(song);
  }

  @Override
  public String getName()
  {
    return this.name;
  }
}
