package intra.uninga.rold_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListarContactsActivity extends AppCompatActivity {

    private ListView listViewContatos;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contacts);

        listViewContatos = findViewById(R.id.listViewContatos);
        databaseHelper = new DatabaseHelper(this);

        loadContatos();
    }

    private void loadContatos() {
        ArrayList<String> contatos = new ArrayList<>();
        Cursor cursor = databaseHelper.getAllContatos();

        if (cursor.moveToFirst()) {
            do {
                int nameIndex = cursor.getColumnIndex("nome");
                int emailIndex = cursor.getColumnIndex("email");
                int telefoneIndex = cursor.getColumnIndex("telefone");
                int raIndex = cursor.getColumnIndex("ra");
                int cpfIndex = cursor.getColumnIndex("cpf");
                int cursoIndex = cursor.getColumnIndex("curso");
                int anoIndex = cursor.getColumnIndex("ano");
                int turnoIndex = cursor.getColumnIndex("turno");

                String nome = (nameIndex != -1) ? cursor.getString(nameIndex) : "N/A";
                String email = (emailIndex != -1) ? cursor.getString(emailIndex) : "N/A";
                String telefone = (telefoneIndex != -1) ? cursor.getString(telefoneIndex) : "N/A";
                String ra = (raIndex != -1) ? String.valueOf(cursor.getInt(raIndex)) : "N/A";
                String cpf = (cpfIndex != -1) ? cursor.getString(cpfIndex) : "N/A";
                String curso = (cursoIndex != -1) ? cursor.getString(cursoIndex) : "N/A";
                String ano = (anoIndex != -1) ? String.valueOf(cursor.getInt(anoIndex)) : "N/A";
                String turno = (turnoIndex != -1) ? cursor.getString(turnoIndex) : "N/A";

                contatos.add(nome + " - " + email + " - " + telefone + " - " + ra + " - " + cpf + " - " + curso + " - " + ano + " - " + turno);
            } while (cursor.moveToNext());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contatos);
        listViewContatos.setAdapter(adapter);
    }
}