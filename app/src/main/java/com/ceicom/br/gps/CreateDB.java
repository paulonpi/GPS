package com.ceicom.br.gps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by paulo on 27/01/2017.
 */

public class CreateDB extends SQLiteOpenHelper{

    public CreateDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    protected static final String NOME_BANCO = "gps.db";
    protected static final String TABELA = "anunciantes";
    protected static final String id = "_id";
    protected static final String registroId = "registroId";
    protected static final String planoID = "planoID";
    protected static final String setorID = "setorID";
    protected static final String tipoID = "tipoID";
    protected static final String razaoSocial = "razaoSocial";
    protected static final String nome = "nome";
    protected static final String cep = "cep";
    protected static final String bairro = "bairro";
    protected static final String enredeco = "enredeco";
    protected static final String estado = "estado";
    protected static final String cidade = "cidade";
    protected static final String cidadeNormatizada = "cidadeNormatizada";
    protected static final String numero = "numero";
    protected static final String telefone1 = "telefone1";
    protected static final String telefone2 = "telefone2";
    protected static final String celular = "celular";
    protected static final String email = "email";
    protected static final String site = "site";
    protected static final String facebook = "facebook";
    protected static final String twitter = "twitter";
    protected static final String palavrasChaves = "palavrasChaves";
    protected static final String ativo = "ativo";
    protected static final String atualizacao = "atualizacao";
    protected static final int VERSAO = 1;

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE "+ TABELA + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT NOTNULL UNIQUE,"
                + registroId + " integer,"
                + planoID + " integer,"
                + setorID + " integer,"
                + tipoID + " integer,"
                + razaoSocial + " text,"
                + nome + " text,"
                + cep + " text,"
                + bairro + " text,"
                + enredeco + " text,"
                + estado + " text,"
                + cidade + " text,"
                + cidadeNormatizada + " text,"
                + numero + " text,"
                + telefone1 + " text,"
                + telefone2 + " text,"
                + celular + " text,"
                + email + " text,"
                + site + " text,"
                + facebook + " text,"
                + twitter + " text,"
                + palavrasChaves + " text,"
                + ativo + " integer,"
                + atualizacao + " integer"
                +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " +  TABELA );
        onCreate(db);
    }
}
