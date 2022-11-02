package br.ulbra.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class RegistraActivity extends AppCompatActivity {
    EditText edtNome, edtLogin, edtSenha, edtsenha2;
    Button   btnSalvar;
    DBHelper db;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
         setContentView(R.layout.cadastrousuario);
         db = new DBHelper(this);

         edtNome = (EditText) findViewById(R.id.edtNome);
         edtLogin = (EditText) findViewById(R.id.edtLogin);
         edtSenha = (EditText) findViewById(R.id.edtSenha);
         edtsenha2 = (EditText) findViewById(R.id.edtsenha2);

         btnSalvar = (Button) findViewById(R.id.btnSalvar);

         btnSalvar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String userName = edtLogin.getText().toString();
                 String pas1 = edtSenha.getText().toString();
                 String pas2 = edtsenha2.getText().toString();
                 if (userName.equals("")){
                     Toast.makeText(RegistraActivity.this, "insira o" +
                             "LOGIN DO USUARIO", Toast.LENGTH_SHORT).show();
                 }else if (pas1.equals("") || pas2.equals("")){
                     Toast.makeText(RegistraActivity.this, "As senhas" +
                             "não correspondem ao login do usuario", Toast.LENGTH_SHORT).show();
                 }else{
                     long res = db.criarUtilizador(userName,pas1);
                     if(res>0){
                        Toast.makeText(RegistraActivity.this,
                                "Registro OK", Toast.LENGTH_SHORT).show();
                     }else{
                         Toast.makeText(RegistraActivity.this, "Senha" +
                                 "invalida", Toast.LENGTH_SHORT).show();
                     }

                 }
             }
         });

    }
}
