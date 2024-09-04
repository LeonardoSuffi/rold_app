package intra.uninga.rold_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contatos.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTATOS = "contatos";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTATOS + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT,"
                + "email TEXT,"
                + "telefone TEXT,"
                + "ra INTEGER,"
                + "cpf TEXT,"
                + "curso TEXT,"
                + "ano INTEGER,"
                + "turno TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTATOS);
        onCreate(db);
    }

    public boolean addContato(String nome, String email, String telefone, int ra, String cpf, String curso, int ano, String turno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("email", email);
        values.put("telefone", telefone);
        values.put("ra", ra);
        values.put("cpf", cpf);
        values.put("curso", curso);
        values.put("ano", ano);
        values.put("turno", turno);

        long result = db.insert(TABLE_CONTATOS, null, values);
        db.close();
        return result != -1;
    }


    public Cursor getAllContatos() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CONTATOS, null);
    }
}