package jmapps.simplenotes.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Имя и версия базы данных
    private static final String DBName = "simpleNotes.DB";
    private static final int DBVersion = 1;

    // Имя таблицы
    public static final String tableName = "Table_of_chapters";

    // Имена столбцов в таблице
    public static final String _ID = "_id";
    public static final String chapterTitle = "chapter_title";
    public static final String chapterContent = "chapter_content";

    // Создаем таблицу
    private static final String createTable = "CREATE TABLE " + tableName + "(" + _ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + chapterTitle + " TEXT, " + chapterContent + " TEXT);";

    // Создаем переменную со столбцами
    public static final String[] columns = {_ID, chapterTitle, chapterContent};

    // Создаем конструктор класса DatabaseHelper
    DatabaseHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    // Создаем базу данных
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(database);
    }
}