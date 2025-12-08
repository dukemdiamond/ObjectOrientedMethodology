import java.util.List;

public interface Playlist
{

  /**
   * Adds a song to the end of the playlist.
   *
   * @throws IllegalArgumentException if song is null or already in playlist
   */
  void addSong(Song song);

  /**
   * Removes a song from the playlist.
   *
   * @throws IllegalArgumentException if song is null or not in playlist
   */
  void removeSong(Song song);

  /**
   * Returns total duration of all songs in seconds.
   */
  int totalDuration();

  /**
   * Returns the number of songs in the playlist.
   */
  int size();

  /**
   * Returns all songs in the playlist in the order they were added.
   */
  List<Song> getSongs();

  /**
   * Returns true if the song is in the playlist.
   *
   * @throws IllegalArgumentException if song is null
   */
  boolean contains(Song song);

  /**
   * Returns the name of the playlist.
   */
  String getName();
}
