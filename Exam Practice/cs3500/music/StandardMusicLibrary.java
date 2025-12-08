
import java.util.ArrayList;
import java.util.List;

public class StandardMusicLibrary implements MusicLibrary
{

  private final List<Song> library;

  public StandardMusicLibrary()
  {
    this.library = new ArrayList<>();
  }

  @Override
  public void addSong(Song song)
  {
    ensureNonNull(song);
    if (library.contains(song))
    {
      throw new IllegalArgumentException("Song already in library");
    }
    library.add(song);
  }

  @Override
  public boolean hasSong(Song song)
  {
    ensureNonNull(song);
    return library.contains(song);
  }

  @Override
  public List<Song> allSongs()
  {
    if (library.isEmpty())
    {
      throw new IllegalStateException("Library is empty");
    }
    List<Song> result = new ArrayList<>(library);
    result.sort(Song::compareTo);
    return result;
  }

  @Override
  public List<Song> songsByArtist(String artist)
  {
    ensureNonNull(artist);
    List<Song> result = new ArrayList<>();
    for (Song song : library)
    {
      if (song.getArtist().equalsIgnoreCase(artist))
      {
        result.add(song);
      }
    }
    if (result.isEmpty())
    {
      throw new IllegalStateException("No songs by artist: " + artist);
    }
    result.sort(Song::compareTo);
    return result;
  }

  @Override
  public int totalSongs()
  {
    return library.size();
  }

  private void ensureNonNull(Object obj)
  {
    if (obj == null)
    {
      throw new IllegalArgumentException("Argument cannot be null");
    }
  }
}