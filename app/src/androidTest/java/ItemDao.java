import androidx.room.*;
import java.util.*;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Closet")
    List<Item> getAll();

    @Query("SELECT * FROM Closet WHERE color IN (:closetColors)")
    List<Item> loadAllByColor(int[] closetColors);

    @Query("SELECT * FROM Closet WHERE isWinter LIKE :winter AND " +
            "isFall LIKE :fall AND" + " isSummer LIKE :summer AND" + " isSpring LIKE :spring")
    Item findBySeasom(boolean winter, boolean spring, boolean fall, boolean summer);

    @Query("SELECT * FROM Closet WHERE clothingType IN (:closetTypes)")
    List<Item> loadAllByType(int[] closetTypes);

    @Query("SELECT * FROM Closet WHERE isPatterned IN (:arePatterned)")
    List<Item> loadAllByType(boolean[] arePatterned);

    @Insert
    void insertAll(Item... Closets);

    @Delete
    void delete(Item Closet);
}