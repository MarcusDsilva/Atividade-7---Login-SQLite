package br.ulbra.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtlogin, edtsenha3;
    Button btnLogar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticacao);
        db = new DBHelper(this);

        edtlogin = (EditText) findViewById(R.id.edtlogin);
        edtsenha3 = (EditText) findViewById(R.id.edtsenha3);
        btnLogar = (Button) findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtlogin.getText().toString();
                String password = edtsenha3.getText().toString();
                if (username.equals("")){
                    Toast.makeText(LoginActivity.this, "Usuario nao" +
                            "inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(LoginActivity.this,"Senha não" +
                            "inserida, tente novamente", Toast.LENGTH_SHORT).show();
                }else{
                    String res = db.validarLogin(username,password);
                    if(res.equals("OK")){
                        Toast.makeText(LoginActivity.this,"login" +
                                "OK !!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this,"Login ou" +
                                "senha errado(s)!!",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}
