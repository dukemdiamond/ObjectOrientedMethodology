import java.util.Objects;

public final class MediaItem implements Comparable<MediaItem>
{
  private final String title;
  private final String author;
  private final MediaType type;

  public MediaItem(String title, String author, MediaType type)
  {
    if (title == null || author == null || type == null)
    {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.title = title;
    this.author = author;
    this.type = type;
  }

  public String getTitle()
  {
    return title;
  }

  public String getAuthor()
  {
    return author;
  }

  public MediaType getType()
  {
    return type;
  }

  @Override
  public boolean equals(Object other)
  {
    if (this == other)
    {
      return true;
    }
    if (!(other instanceof MediaItem))
    {
      return false;
    }
    MediaItem that = (MediaItem) other;
    return title.equals(that.title)
        && author.equals(that.author)
        && type.equals(that.type);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(title, author, type);
  }

  @Override
  public int compareTo(MediaItem other)
  {
    return this.title.compareToIgnoreCase(other.title);
  }
}
