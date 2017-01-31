package com.ceicom.br.gps;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String ANUNCIANTES_JSON = "http://api.guiaparanasudoeste.com.br/sincronizar/anunciantes/pqsHfZlP7RCXfZ5plSoVDq3xxTwUMx/";

    private static String TAG = MainActivity.class.getSimpleName();

    private Button btnRequest, btnTimeStamp, btnAtualizarCadastros;

    private ProgressDialog dialog;

    private TextView txResposta;

    private String jsonResposta;

    private Anunciantes anunciante = new Anunciantes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = (Button) findViewById(R.id.btnRequest);
        btnTimeStamp = (Button) findViewById(R.id.btnLastTimeStamp);
        btnAtualizarCadastros = (Button) findViewById(R.id.btnCadastros);

        txResposta = (TextView) findViewById(R.id.txResposta);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Processando...");
        dialog.setCancelable(false);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestObjetc("1485255954");
            }
        });

        btnTimeStamp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getLastTimeStamp();
            }
        });

        btnAtualizarCadastros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                atualizarCadastros();
            }
        });
    }

    private void requestObjetc(String atualizacao){

        showDialog();
        final DBController crud = new DBController(getBaseContext());

        if (atualizacao == "" || atualizacao.isEmpty()){
            txResposta.setText("sem dados no BD");
            hideDialog();
            return;
        }

        atualizacao.concat("1");

        JsonArrayRequest jsonReq = new JsonArrayRequest(ANUNCIANTES_JSON + atualizacao, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                jsonResposta = "";
                int cont = 0;
                try {
                    if (response.length() > 0){
                        for (int i = 0; i < response.length(); i++){
                            JSONObject obj = (JSONObject) response.get(i);

                            anunciante.setRegistroId(obj.getInt("registroID"));
                            anunciante.setPlanoID(obj.getInt("planoID"));
                            anunciante.setSetorID(obj.getInt("setorID"));
                            anunciante.setTipoID(obj.getInt("tipoID"));
                            anunciante.setRazaoSocial(obj.getString("razaoSocial"));
                            anunciante.setNome(obj.getString("nome"));
                            anunciante.setCep(obj.getString("cep"));
                            anunciante.setBairro(obj.getString("bairro"));
                            anunciante.setEnredeco(obj.getString("endereco"));
                            anunciante.setEstado(obj.getString("estado"));
                            anunciante.setCidade(obj.getString("cidade"));
                            anunciante.setCidadeNormatizada(obj.getString("cidadeNormatizada"));
                            anunciante.setNumero(obj.getString("numero"));
                            anunciante.setTelefone1(obj.getString("telefone1"));
                            anunciante.setTelefone2(obj.getString("telefone2"));
                            anunciante.setCelular(obj.getString("celular"));
                            anunciante.setEmail(obj.getString("email"));
                            anunciante.setSite(obj.getString("site"));
                            anunciante.setFacebook(obj.getString("facebook"));
                            anunciante.setTwitter(obj.getString("twitter"));
                            anunciante.setPalavrasChaves(obj.getString("palavrasChaves"));
                            anunciante.setAtivo(obj.getBoolean("ativo"));
                            anunciante.setAtualizacao(obj.getInt("atualizacao"));

                            try {
                                jsonResposta = crud.insertDados(anunciante);
                                cont++;
                            }catch (Exception e){
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                            }
                        }

                        txResposta.setText("+ " + cont + " " + jsonResposta);
                    }else {
                        txResposta.setText("Nenhum cadastro novo foi inserido");
                    }

                    hideDialog();
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError response){
                hideDialog();
            }
        });
        AppController.getInstance().addParaQueue(jsonReq);
    }

    private void showDialog(){
        if(!dialog.isShowing()){
            dialog.show();
        }
    }

    private void hideDialog(){
        if(dialog.isShowing()){
            dialog.dismiss();
        }
    }

    public void irParaLista(View view){
        Intent lista = new Intent(this, ListaActivity.class);
        startActivity(lista);
    }

    public int getLastTimeStamp(){
        showDialog();
        DBController crud = new DBController(getBaseContext());
        int ts = crud.lastTimeStamp();
        txResposta.setText("Última atualização " + ts);
        hideDialog();

        return ts;
    }

    public void atualizarCadastros(){
        int cod = getLastTimeStamp();
        requestObjetc(cod + "");
    }

    public void limpaTabela(View view){
        DBController crud = new DBController(getBaseContext());
        String res = crud.limpaTabela(CreateDB.TABELA);
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();
    }
}
