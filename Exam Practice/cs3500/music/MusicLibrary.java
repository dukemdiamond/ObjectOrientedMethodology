import java.util.List;

public interface MusicLibrary
{

  /**
   * Adds a song to the library.
   *
   * @throws IllegalArgumentException if song is null or already exists
   */
  void addSong(Song song);

  /**
   * Returns true if song exists in library.
   *
   * @throws IllegalArgumentException if song is null
   */
  boolean hasSong(Song song);

  /**
   * Returns all songs in the library sorted alphabetically by title.
   *
   * @throws IllegalStateException if library is empty
   */
  List<Song> allSongs();

  /**
   * Returns all songs by the given artist.
   *
   * @throws IllegalArgumentException if artist is null
   * @throws IllegalStateException    if no songs by that artist
   */
  List<Song> songsByArtist(String artist);

  /**
   * Returns total number of songs.
   */
  int totalSongs();
}