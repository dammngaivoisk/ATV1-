import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendidos();
        
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVendas;

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();

        setTitle("Vendas Realizadas");
        setSize(500, 300);
        setLocationRelativeTo(null);

        tabelaVendas.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Valor", "Status"}
        ));

        jScrollPane1.setViewportView(tabelaVendas);
        add(jScrollPane1);
    }

    private void listarVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
        model.setNumRows(0);

        ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();

        for (ProdutosDTO p : lista) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getValor(),
                p.getStatus()
            });
        }
    }
}

