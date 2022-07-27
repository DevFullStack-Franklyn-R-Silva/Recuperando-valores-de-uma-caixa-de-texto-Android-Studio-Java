package com.hadesfranklyn.componentesbasicosprojeto;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);

        //CheckBox
        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

        //RadioButton
        sexoMasculino = findViewById(R.id.radioButtonMasculino);
        sexoFeminino = findViewById(R.id.radioButtonFeminino);
        opcaoSexo = findViewById(R.id.radioGroupSexo);
        radioButton();
    }

    public String checkbox() {

        String texto = "", corSelecionada = "";

        if (checkVerde.isChecked()) {
            corSelecionada = checkVerde.getText().toString();
            texto = corSelecionada + " selecionado - ";
        }
        if (checkBranco.isChecked()) {
            corSelecionada = checkBranco.getText().toString();
            texto = texto + corSelecionada + " selecionado - ";
        }
        if (checkVermelho.isChecked()) {
            corSelecionada = checkVermelho.getText().toString();
            texto = texto + corSelecionada + " selecionado - ";
        }
        return texto;

    }

    public void radioButton() {
        // Executar no tempo de execução
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.radioButtonMasculino){
                    textoResultado.setText("Masculino");
                }else if(checkedId == R.id.radioButtonFeminino){
                    textoResultado.setText("Feminino");
                }
            }
        });

//        if (sexoMasculino.isChecked()) {
//            return sexoMasculino.getText().toString();
//        } else {
//            return sexoFeminino.getText().toString();
//        }
    }

    public void enviar(View view) {
        checkbox();


        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textoResultado.setText("nome: " + nome + "\nemail: " + email + "\n" + checkbox() + "\n" );
    }

    public void limpar(View view) {
        campoNome.setText("");
        campoEmail.setText("");
        textoResultado.setText("");
    }
}