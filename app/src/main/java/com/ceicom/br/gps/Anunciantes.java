package com.ceicom.br.gps;

/**
 * Created by paulo on 27/01/2017.
 */

public class Anunciantes {
    private static int registroId;
    private static int planoID;
    private static int setorID;
    private static int tipoID;
    private static String razaoSocial;
    private static String nome;
    private static String cep;
    private static String bairro;
    private static String enredeco;
    private static String estado;
    private static String cidade;
    private static String cidadeNormatizada;
    private static String numero;
    private static String telefone1;
    private static String telefone2;
    private static String celular;
    private static String email;
    private static String site;
    private static String facebook;
    private static String twitter;
    private static String palavrasChaves;
    private static int ativo;
    private static int atualizacao;

    public static int getRegistroId() {
        return registroId;
    }

    public static void setRegistroId(int registroId) {
        Anunciantes.registroId = registroId;
    }

    public static int getPlanoID() {
        return planoID;
    }

    public static void setPlanoID(int planoID) {
        Anunciantes.planoID = planoID;
    }

    public static int getSetorID() {
        return setorID;
    }

    public static void setSetorID(int setorID) {
        Anunciantes.setorID = setorID;
    }

    public static int getTipoID() {
        return tipoID;
    }

    public static void setTipoID(int tipoID) {
        Anunciantes.tipoID = tipoID;
    }

    public static String getRazaoSocial() {
        return razaoSocial;
    }

    public static void setRazaoSocial(String razaoSocial) {
        Anunciantes.razaoSocial = razaoSocial;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Anunciantes.nome = nome;
    }

    public static String getCep() {
        return cep;
    }

    public static void setCep(String cep) {
        Anunciantes.cep = cep;
    }

    public static String getBairro() {
        return bairro;
    }

    public static void setBairro(String bairro) {
        Anunciantes.bairro = bairro;
    }

    public static String getEnredeco() {
        return enredeco;
    }

    public static void setEnredeco(String enredeco) {
        Anunciantes.enredeco = enredeco;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        Anunciantes.estado = estado;
    }

    public static String getCidade() {
        return cidade;
    }

    public static void setCidade(String cidade) {
        Anunciantes.cidade = cidade;
    }

    public static String getCidadeNormatizada() {
        return cidadeNormatizada;
    }

    public static void setCidadeNormatizada(String cidadeNormatizada) {
        Anunciantes.cidadeNormatizada = cidadeNormatizada;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        Anunciantes.numero = numero;
    }

    public static String getTelefone1() {
        return telefone1;
    }

    public static void setTelefone1(String telefone1) {
        Anunciantes.telefone1 = telefone1;
    }

    public static String getTelefone2() {
        return telefone2;
    }

    public static void setTelefone2(String telefone2) {
        Anunciantes.telefone2 = telefone2;
    }

    public static String getCelular() {
        return celular;
    }

    public static void setCelular(String celular) {
        Anunciantes.celular = celular;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Anunciantes.email = email;
    }

    public static String getSite() {
        return site;
    }

    public static void setSite(String site) {
        Anunciantes.site = site;
    }

    public static String getFacebook() {
        return facebook;
    }

    public static void setFacebook(String facebook) {
        Anunciantes.facebook = facebook;
    }

    public static String getTwitter() {
        return twitter;
    }

    public static void setTwitter(String twitter) {
        Anunciantes.twitter = twitter;
    }

    public static String getPalavrasChaves() {
        return palavrasChaves;
    }

    public static void setPalavrasChaves(String palavrasChaves) {
        Anunciantes.palavrasChaves = palavrasChaves;
    }

    public static int getAtivo() {
        return ativo;
    }

    public static void setAtivo(boolean ativo) {
        int ativ;

        if(ativo)
            ativ = 1;
        else
            ativ = 0;

        Anunciantes.ativo = ativ;
    }

    public static int getAtualizacao() {
        return atualizacao;
    }

    public static void setAtualizacao(int atualizacao) {
        Anunciantes.atualizacao = atualizacao;
    }
}
