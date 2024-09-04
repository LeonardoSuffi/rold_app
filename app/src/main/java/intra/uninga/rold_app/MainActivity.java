package intra.uninga.rold_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextTelefone, editTextRA, editTextCPF, editTextCurso, editTextAno, editTextTurno;
    private Button buttonSalvar, buttonVerContatos;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextRA = findViewById(R.id.editTextRA);
        editTextCPF = findViewById(R.id.editTextCPF);
        editTextCurso = findViewById(R.id.editTextCurso);
        editTextAno = findViewById(R.id.editTextAno);
        editTextTurno = findViewById(R.id.editTextTurno);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonVerContatos = findViewById(R.id.buttonVerContatos);
        databaseHelper = new DatabaseHelper(this);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String telefone = editTextTelefone.getText().toString();
                int ra = Integer.parseInt(editTextRA.getText().toString());
                String cpf = editTextCPF.getText().toString();
                String curso = editTextCurso.getText().toString();
                int ano = Integer.parseInt(editTextAno.getText().toString());
                String turno = editTextTurno.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || curso.isEmpty() || turno.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = databaseHelper.addContato(nome, email, telefone, ra, cpf, curso, ano, turno);
                    if (isInserted) {
                        Toast.makeText(MainActivity.this, "Contato salvo com sucesso", Toast.LENGTH_SHORT).show();
                        clearFields();
                    } else {
                        Toast.makeText(MainActivity.this, "Erro ao salvar contato", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            private void clearFields() {
                editTextNome.setText("");
                editTextEmail.setText("");
                editTextTelefone.setText("");
                editTextRA.setText("");
                editTextCPF.setText("");
                editTextCurso.setText("");
                editTextAno.setText("");
                editTextTurno.setText("");
            }
        });

        buttonVerContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListarContactsActivity.class);
                startActivity(intent);
            }
        });
    }
}