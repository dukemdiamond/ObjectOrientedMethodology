import java.util.Objects;

public final class Song implements Comparable<Song>
{
  private final String title;
  private final String artist;
  private final Genre genre;
  private final int durationSeconds;

  public Song(String title, String artist, Genre genre, int durationSeconds)
  {
    if (title == null || artist == null || genre == null)
    {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    if (durationSeconds <= 0)
    {
      throw new IllegalArgumentException("Duration must be positive");
    }
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.durationSeconds = durationSeconds;
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public Genre getGenre()
  {
    return genre;
  }

  public int getDurationSeconds()
  {
    return durationSeconds;
  }

  @Override
  public boolean equals(Object other)
  {
    if (this == other)
    {
      return true;
    }
    if (!(other instanceof Song))
    {
      return false;
    }
    Song that = (Song) other;
    return title.equals(that.title) && artist.equals(that.artist);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(title, artist);
  }

  @Override
  public int compareTo(Song other)
  {
    return this.title.compareToIgnoreCase(other.title);
  }
}