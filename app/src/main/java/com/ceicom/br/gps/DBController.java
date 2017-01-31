package com.ceicom.br.gps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by paulo on 27/01/2017.
 */

public class DBController {

    private SQLiteDatabase db;
    private CreateDB banco;

    public DBController(Context context) {
        banco = new CreateDB(context);
    }

    public String insertDados(Anunciantes anunciantes){
        ContentValues values;
        long result;

        db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(CreateDB.registroId, anunciantes.getRegistroId());
        values.put(CreateDB.planoID, anunciantes.getPlanoID());
        values.put(CreateDB.setorID, anunciantes.getSetorID());
        values.put(CreateDB.tipoID, anunciantes.getTipoID());
        values.put(CreateDB.razaoSocial, anunciantes.getRazaoSocial());
        values.put(CreateDB.nome, anunciantes.getNome());
        values.put(CreateDB.cep, anunciantes.getCep());
        values.put(CreateDB.bairro, anunciantes.getBairro());
        values.put(CreateDB.enredeco, anunciantes.getEnredeco());
        values.put(CreateDB.estado, anunciantes.getEstado());
        values.put(CreateDB.cidade, anunciantes.getCidade());
        values.put(CreateDB.cidadeNormatizada, anunciantes.getCidadeNormatizada());
        values.put(CreateDB.numero, anunciantes.getNumero());
        values.put(CreateDB.telefone1, anunciantes.getTelefone1());
        values.put(CreateDB.telefone2, anunciantes.getTelefone2());
        values.put(CreateDB.celular, anunciantes.getCelular());
        values.put(CreateDB.email, anunciantes.getEmail());
        values.put(CreateDB.site, anunciantes.getSite());
        values.put(CreateDB.facebook, anunciantes.getFacebook());
        values.put(CreateDB.twitter, anunciantes.getTwitter());
        values.put(CreateDB.palavrasChaves, anunciantes.getPalavrasChaves());
        values.put(CreateDB.ativo, anunciantes.getAtivo());
        values.put(CreateDB.atualizacao, anunciantes.getAtualizacao());

        result = db.insert(CreateDB.TABELA, null, values);
        db.close();

        if(result == 1)
            return "Erro ao inserir registro";
        else
            return  "Registro(s) inserido(s) com sucesso";
    }

    public Cursor loadDados(){
        Cursor cursor;
        String[] campos = {banco.id, banco.nome, banco.telefone1};

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null);

        if(cursor == null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int lastTimeStamp() {
        Cursor cursor;
        int retorno;

        db = banco.getReadableDatabase();
        cursor = db.rawQuery("SELECT MAX(" + banco.atualizacao + ") AS " + banco.atualizacao + " FROM " + banco.TABELA, null);

        cursor.moveToFirst();
        retorno = cursor.getInt(cursor.getColumnIndex(banco.atualizacao));

        return retorno;
    }

    public String limpaTabela(String tabela) {
        try {
            db = banco.getWritableDatabase();
            db.execSQL("DELETE FROM " + tabela + "");
            db.close();
        } catch (Exception e){
            return "Erro; " + e;
        }
        return "Tabela limpa";
    }
}
