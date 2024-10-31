package view;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class TelaDeCadastroView extends JFrame
{   
    private File fotoSelecionada;
    private final String CAMINHO_FOTO = System.getProperty("user.dir") + "\\" + "imagens";

    private File salvarFoto(File foto) throws IOException{

        Path destino = Paths.get(CAMINHO_FOTO, foto.getName());
        Files.copy(foto.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
        return destino.toFile();


    }

    private void removerFoto(File foto) throws IOException{

        Files.deleteIfExists(foto.toPath());
    }


    private final JLabel lblNome;
    private final JTextField txtNome;

    private final JLabel lblEmail;
    private final JTextField txtEmail;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnCadastrar;
    private final JButton btnAdcionarFoto;

    private final JLabel lblNotificacoes;
    private final JLabel lblFotoPreview;

    

    public TelaDeCadastroView()
    {
        super("Tela de Cadastro");
        setLayout(new GridLayout(5,2,5,5));

        lblNome = new JLabel("Nome:");
        add(lblNome);

        txtNome = new JTextField(10);
        add(txtNome);

        lblEmail = new JLabel("Email:");
        add(lblEmail);

        txtEmail = new JTextField(10);
        add(txtEmail);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        btnAdcionarFoto = new JButton("Adcionar Foto");
        add(btnAdcionarFoto);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        lblFotoPreview = new JLabel();
        add(lblFotoPreview);

        

        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                        txtNome.requestFocus();
                        return;
                    }

                    if (txtEmail.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma Senha e tente novamente."));
                        txtSenha.requestFocus();
                        return;
                    }

                    lblNotificacoes.setText(TelaDeCadastroController.cadastrarController(txtNome.getText(), txtEmail.getText(), String.valueOf(txtSenha.getPassword()),fotoSelecionada != null ? fotoSelecionada.getPath() : ""));
                    // Aqui deverá ser chamado o método da controller de cadastro
                }
            }
        );

        btnAdcionarFoto.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Selecione uma foto");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    
                    int resultado = fileChooser.showOpenDialog(TelaDeCadastroView.this);
                    
                    if (resultado == JFileChooser.APPROVE_OPTION) {
                        fotoSelecionada = fileChooser.getSelectedFile();
                        ImageIcon icon = new ImageIcon(fotoSelecionada.getPath());
                        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        lblFotoPreview.setIcon(new ImageIcon(img));
                        lblNotificacoes.setText(setHtmlFormat("Foto selecionada com sucesso."));
                    }
                }
            }
        );


        

        setSize(250, 250);
        setVisible(true);
    }

    private String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static TelaDeCadastroView appTelaDeCadastroView;
    public static void main(String[] args) {
        appTelaDeCadastroView = new TelaDeCadastroView();
        appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
