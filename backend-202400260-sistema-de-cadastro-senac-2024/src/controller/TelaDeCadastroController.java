package controller;
import model.*;
import view.*;

public class TelaDeCadastroController extends TelaDeCadastroView {
    public static String[] retornoUsuario = {
        "Email já cadastrado! Favor digitar outro email e tentar novamente.",
        "Não foi possível realizar o seu cadastro, por uma falha no servidor! Por favor, tente novamente mais tarde.",
        "Cadastro realizado com sucesso"
    };

    public static String cadastrarController(String nome, String email, String senha, String caminhoFoto) {
        return retornoUsuario[TelaDeCadastroModel.cadastrarModel(nome, email, senha, caminhoFoto)];
    }
}
