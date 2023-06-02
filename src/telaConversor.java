import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class telaConversor implements ActionListener {
    JComboBox caixa1;
    JComboBox caixa2;
    JTextField caixaTexto;
    JTextField caixaResultado;
    Conversor conversor = new Conversor();

    public telaConversor(String[] itens){
        JFrame telaConversor = new JFrame();
        telaConversor.setSize(700, 500);

        JPanel telaFrontal = new JPanel();
        telaFrontal.setBorder(new EmptyBorder(new Insets(150,200,150,200)));
        telaFrontal.setLayout(new BoxLayout(telaFrontal, BoxLayout.Y_AXIS));

        telaConversor.add(telaFrontal);

        caixaTexto = new JTextField(10);
        telaFrontal.add(caixaTexto);

        telaFrontal.add(Box.createRigidArea(new Dimension(0,15)));

        caixa1 = new JComboBox(itens);
        caixa1.setBackground(Color.white);

        caixa2 = new JComboBox(itens);
        caixa2.setBackground(Color.white);

        telaFrontal.add(caixa1);

        telaFrontal.add(Box.createRigidArea(new Dimension(0,15)));

        telaFrontal.add(caixa2);

        telaFrontal.add(Box.createRigidArea(new Dimension(0,15)));


        JButton botaoConverter = new JButton("Converter");
        telaFrontal.add(botaoConverter);
        botaoConverter.addActionListener(this::actionPerformed);

        telaFrontal.add(Box.createRigidArea(new Dimension(0,15)));

        caixaResultado = new JTextField(10);
        caixaResultado.setEditable(false);
        caixaResultado.setBackground(Color.white);
        telaFrontal.add(caixaResultado);

        telaConversor.setDefaultCloseOperation(EXIT_ON_CLOSE);
        telaConversor.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoMoeda1 = caixa1.getSelectedItem().toString();
        String tipoMoeda2 = caixa2.getSelectedItem().toString();
        double valor = Double.parseDouble(caixaTexto.getText().replaceAll(",", "."));

        double valorResultado = (conversor.converterMoedas(valor, tipoMoeda1, tipoMoeda2));
        String resultado = String.format(Locale.US, "%,.2f", valorResultado);
        caixaResultado.setText(resultado);
    }
}
