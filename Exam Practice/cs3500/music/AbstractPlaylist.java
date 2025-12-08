import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlaylist implements Playlist
{

  protected final String name;
  protected final List<Song> songs;

  protected AbstractPlaylist(String name)
  {
    if (name == null)
    {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
    this.songs = new ArrayList<>();
  }

  @Override
  public void addSong(Song song)
  {
    ensureNonNull(song);
    if (songs.contains(song))
    {
      throw new IllegalArgumentException("Song already in playlist");
    }
    songs.add(song);
  }

  @Override
  public void removeSong(Song song)
  {
    ensureNonNull(song);
    if (!songs.contains(song))
    {
      throw new IllegalArgumentException("Song not in playlist");
    }
    songs.remove(song);
  }

  @Override
  public int totalDuration()
  {
    int total = 0;
    for (Song song : songs)
    {
      total += song.getDurationSeconds();
    }
    return total;
  }

  @Override
  public int size()
  {
    return songs.size();
  }

  @Override
  public List<Song> getSongs()
  {
    return new ArrayList<>(songs);
  }

  @Override
  public boolean contains(Song song)
  {
    ensureNonNull(song);
    return songs.contains(song);
  }

  @Override
  public String getName()
  {
    return name;
  }

  protected void ensureNonNull(Object obj)
  {
    if (obj == null)
    {
      throw new IllegalArgumentException("Argument cannot be null");
    }
  }

  // Helper for subclasses: calculates average duration
  protected double calculateAverageDuration()
  {
    if (songs.isEmpty())
    {
      return 0.0;
    }
    return (double) totalDuration() / songs.size();
  }
}
