package org.example;

import java.sql.*;
import java.util.Optional;

public record Song(int ID, String artist, String title, int time)
{

    public static class Persistence
    {
        private static final String url = "jdbc:sqlite:songs.db";
        public static Optional<Song> read(int id)
        {
            Optional<Song> result = Optional.empty();
            try(Connection conn = DriverManager.getConnection(url))
            {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM song WHERE id = ?");
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next())
                {
                    String artist = rs.getString("artist");
                    String title = rs.getString("title");
                    int time = rs.getInt("length");
                    Song s = new Song(id, artist, title, time);

                    result = Optional.of(s);
                }
            }
            catch (SQLException exception)
            {
                System.out.println("Połączenie się nie powiodło");
            }
            return result;
        }
    }
}
