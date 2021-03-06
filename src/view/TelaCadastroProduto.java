package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.CadastroProdutoController;
import model.Categoria;
import model.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TelaCadastroProduto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtNome, txtPreco, txtQtd, txtCodBarras;
	private JComboBox<?> comboCategoria;
	private JTextArea txtDescricao;
	private JButton btnFinalizar;
	private CadastroProdutoController controller = new CadastroProdutoController();
	private Produto p;

	public TelaCadastroProduto(Produto p) {
		this.p = p;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 800, 50);
		painel.add(panel);

		JLabel lblCadastroDeProduto = new JLabel("CADASTRO DE PRODUTO");
		lblCadastroDeProduto.setForeground(Color.WHITE);
		lblCadastroDeProduto.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblCadastroDeProduto);

		JLabel lblNewLabel = new JLabel("Categoria*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(70, 110, 100, 30);
		painel.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(70, 175, 100, 30);
		painel.add(lblNome);

		JLabel lblPreo = new JLabel("Pre\u00E7o*");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPreo.setBounds(70, 240, 100, 30);
		painel.add(lblPreo);

		JLabel lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantidade.setBounds(70, 300, 125, 30);
		painel.add(lblQuantidade);

		comboCategoria = new JComboBox<Object>(Categoria.values());
		comboCategoria.setBounds(205, 115, 185, 25);
		painel.add(comboCategoria);

		txtNome = new JTextField();
		txtNome.setBounds(205, 185, 185, 25);
		painel.add(txtNome);
		txtNome.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(205, 245, 185, 25);
		painel.add(txtPreco);

		txtQtd = new JTextField();
		txtQtd.setColumns(10);
		txtQtd.setBounds(205, 310, 185, 25);
		painel.add(txtQtd);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescricao.setBounds(435, 110, 100, 30);
		painel.add(lblDescricao);

		btnFinalizar = new JButton();
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFinalizar.setBounds(365, 430, 100, 30);
		btnFinalizar.addActionListener(this);
		painel.add(btnFinalizar);

		JLabel lblCodBarras = new JLabel("Cod. Barras*");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodBarras.setBounds(70, 360, 125, 30);
		painel.add(lblCodBarras);

		txtCodBarras = new JTextField();
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(205, 370, 185, 25);
		painel.add(txtCodBarras);

		txtDescricao = new JTextArea();
		txtDescricao.setBounds(430, 150, 290, 165);

		JScrollPane scrollDesc = new JScrollPane(txtDescricao);
		scrollDesc.setBounds(430, 150, 290, 165);
		scrollDesc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDesc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painel.add(scrollDesc);

		if (p != null) {
			produtoToTela(p);
			btnFinalizar.setText("Alterar");
			lblCadastroDeProduto.setText("ALTERAR PRODUTO");
			txtCodBarras.setEditable(false);
		} else {
			btnFinalizar.setText("Cadastrar");
			lblCadastroDeProduto.setText("CADASTRO DE PRODUTO");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFinalizar) {
			if (p == null) {
				controller.adicionarNovoProduto(telaToProduto());
			} else {
				Produto alt_p = telaToProduto();
				controller.alterarProduto(alt_p, p.getCod_barras());
			}
			this.dispose();
		}
	}

	public Produto telaToProduto() {
		Produto prod = new Produto();
		prod.setCategoria(((Categoria) comboCategoria.getSelectedItem()));
		prod.setNome(txtNome.getText());
		prod.setPreco(Double.parseDouble(txtPreco.getText()));
		prod.setQuantidade_estoque(Integer.parseInt(txtQtd.getText()));
		prod.setCod_barras(txtCodBarras.getText());
		prod.setDescricao(txtDescricao.getText());

		return prod;
	}

	public void produtoToTela(Produto p) {
		txtNome.setText(p.getNome());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQtd.setText(String.valueOf(p.getQuantidade_estoque()));
		txtCodBarras.setText(p.getCod_barras());
		comboCategoria.setSelectedItem(p.getCategoria());
		txtDescricao.setText(p.getDescricao());
	}
}
