package com.example.horascomplementares;

import android.widget.ImageView;

public class User {

    private String nome;
    private String sexo;
    private long cpf;
    private long rg;
    private ImageView avatar;
    private String endereco;
    private int enderecoNum;
    private long telefone;
    private long telefone2;
    private int admin;
    private String email;
    private String senha;

    public User() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getEnderecoNum() {
        return enderecoNum;
    }

    public void setEnderecoNum(int enderecoNum) {
        this.enderecoNum = enderecoNum;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(long telefone2) {
        this.telefone2 = telefone2;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
