import java.util.List;

public interface SearchablePlaylist extends Playlist
{
  List<Song> getSong(SongCriteria sc);
}
