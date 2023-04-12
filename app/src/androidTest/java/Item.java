import androidx.room.*;

import android.media.Image;

@Fts4
@Entity(tableName = "closet")
public class Item {
    @PrimaryKey
    public Image clothingImg;
    public String clothingType;
    public boolean isWinter;
    public boolean isSpring;
    public boolean isFall;
    public boolean isSummer;
    public android.graphics.Color color;
    public boolean isPatterned;

}

