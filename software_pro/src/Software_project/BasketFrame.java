/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author bmetin
 */
public class BasketFrame extends javax.swing.JFrame {

    Statement st;
    ResultSet rs=null; 
    Connection con;
    PreparedStatement pst = null;
    DefaultTableModel model = null;
    
    int rowsCount;
    
    String query = "SELECT * FROM BASKET";
    /**
     * Creates new form BasketFrame
     */
    public BasketFrame() {
        initComponents();
        productNameText.setText(productNameText.getText());
        brandIdText.setText(brandIdText.getText());
        priceText.setText(priceText.getText());
        //idText.setText(idText.getText());
        getConnection();
        //viewBasket(query);
        rowsCount=listTable.getRowCount();
    }
    
    public void executeSQLQuery(String query,String message)
    {
        Connection con = getConnection();
        Statement st;
        
        try{
            st=con.createStatement();
            if((st.executeUpdate(query))==1)
            {
                JOptionPane.showMessageDialog(null, "Data"+message+"successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data Not"+message);
            }
        
        }catch(Exception ex)
        {
            
        }
    }
    
    public int getSum(int rowsCount)
    {
                
        int sum=0;
        
        for(int i=0; i<rowsCount; i++)
        {
           sum = sum + Integer.parseInt(listTable.getValueAt(i, 2).toString());
        }
        return sum;
    }
    
    public static Connection getConnection()
    {
        Connection con = null;
         try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Connection to Database...");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SOFTWARE_PRO","bmetin1");
        }

        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.getMessage() + "");
        
        }
         return con;
    }
    
    public void addBasket(String searchQuery)
    {
      
       String p_name = productNameText.getText();
       
       try{
      
        System.out.println(p_name);
   
           Connection con = getConnection();
           st = con.createStatement();
           
           //String searchQuery = "INSERT INTO BASKET(P_NAME,BRAND_ID,PRICE) VALUES('"+productNameText.getText()+"','"+brandIdText.getText()+"','"+priceText.getText()+"') ";
       
           st.executeQuery(searchQuery); 
            
           
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
       
   
    }
    
     public ArrayList<Basket> viewBasket(String searchQuery)
    {
       
        
        ArrayList<Basket> basketLists;
        basketLists = new ArrayList<>();
        

       try{
      
        
       
           Connection con = getConnection();
           st = con.createStatement();
           rs = st.executeQuery(searchQuery); 
          
          Basket basket;
           
           while(rs.next())
           {
                 basket=new Basket(
                        rs.getString("P_NAME"),
                        rs.getString("BRAND_ID"),
                        rs.getInt("PRICE"),
                        rs.getInt("ID")
                 );
           
            basketLists.add(basket);
           }
     
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
       
       return basketLists;
    }
    
    
    public void findBasket(String query)
    {
      
        ArrayList<Basket> p_name = viewBasket(query);
       
        
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"P_NAME","BRAND_ID","PRICE","ID"});
        
        Object[]row=new Object[4];
        for(int i=0; i<p_name.size(); i++)
        {
            row[0]=p_name.get(i).getProduct_name();
            row[1]=p_name.get(i).getBrand_id();
            row[2]=p_name.get(i).getPrice();
            row[3]=p_name.get(i).getId();
            model.addRow(row);
        }
        
        listTable.setModel(model);
    }
   
    
    
    public ArrayList<Basket> deleteBasket(String searchQuery)
    {
      
       
        ArrayList<Basket> deleteList;
        deleteList = new ArrayList<>();
        
     
       
       try{
      
           con = getConnection();
           st = con.createStatement();
         
           
           //String searchQuery = "DELETE FROM BASKET WHERE P_NAME= '"+productNameText.getText()+"' AND PRICE ='"+priceText.getText()+"' AND BRAND_ID='"+brandIdText.getText()+"' AND ID='"+idText.getText()+"' ";
           rs = st.executeQuery(searchQuery); 
           
           //String searchQuery2 = "INSERT INTO BASKET(P_NAME,BRAND_ID,PRICE) VALUES('"+productNameText.getText()+"','"+brandIdText.getText()+"','"+priceText.getText()+"') ";
           //rs = st.executeQuery(searchQuery2); 
          
         
           Basket basket;
           
           while(rs.next())
           {
              
                basket=new Basket(
                        rs.getString("P_NAME"),
                        rs.getString("BRAND_ID"),
                        rs.getInt("PRICE"),
                        rs.getInt("ID")

               );
              deleteList.add(basket);
           }
          
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
       
       return deleteList;
    }
    
    
    
    public void findBasket_delete(String query)
    {
      
        ArrayList<Basket> basketL = deleteBasket(query);
       
        
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"P_NAME","BRAND_ID","PRICE","ID"});
        
        Object[]row=new Object[4];
        for(int i=0; i<basketL.size(); i++)
        {
            row[0]=basketL.get(i).getProduct_name();
            row[1]=basketL.get(i).getBrand_id();
            row[2]=basketL.get(i).getPrice();
            row[3]=basketL.get(i).getId();
            model.addRow(row);
        }
        
        listTable.setModel(model);
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTitle = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        productNameLabel = new javax.swing.JLabel();
        productNameText = new javax.swing.JTextField();
        brandIdLabel = new javax.swing.JLabel();
        brandIdText = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        basketTable = new javax.swing.JScrollPane();
        listTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        buyButton = new javax.swing.JButton();
        totalText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ID_label = new javax.swing.JLabel();
        sortPriceButton = new javax.swing.JButton();
        sortPriceButtonDesc = new javax.swing.JButton();
        idText = new javax.swing.JTextField();
        mainButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainTitle.setFont(new java.awt.Font("Viner Hand ITC", 1, 70)); // NOI18N
        mainTitle.setText("HARMONIA");
        getContentPane().add(mainTitle);
        mainTitle.setBounds(380, 20, 470, 100);

        title.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        title.setText("YOUR BASKET");
        getContentPane().add(title);
        title.setBounds(710, 390, 210, 40);

        productNameLabel.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        productNameLabel.setText("Product Name:");
        getContentPane().add(productNameLabel);
        productNameLabel.setBounds(480, 150, 150, 30);

        productNameText.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        productNameText.setOpaque(false);
        productNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTextActionPerformed(evt);
            }
        });
        getContentPane().add(productNameText);
        productNameText.setBounds(630, 150, 210, 30);

        brandIdLabel.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        brandIdLabel.setText("Brand ID:");
        brandIdLabel.setToolTipText("");
        getContentPane().add(brandIdLabel);
        brandIdLabel.setBounds(530, 200, 100, 30);

        brandIdText.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        brandIdText.setOpaque(false);
        getContentPane().add(brandIdText);
        brandIdText.setBounds(630, 200, 210, 30);

        priceLabel.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        priceLabel.setText("Price:");
        getContentPane().add(priceLabel);
        priceLabel.setBounds(550, 250, 70, 40);

        priceText.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        priceText.setOpaque(false);
        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });
        getContentPane().add(priceText);
        priceText.setBounds(630, 250, 210, 30);

        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P_NAME", "BRAND_ID", "PRICE", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableMouseClicked(evt);
            }
        });
        basketTable.setViewportView(listTable);

        getContentPane().add(basketTable);
        basketTable.setBounds(580, 440, 390, 160);

        backButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(130, 520, 160, 40);

        addButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        addButton.setText("ADD BASKET");
        addButton.setActionCommand("viewButton");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(930, 150, 190, 40);

        viewButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        viewButton.setText("VIEW BASKET");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewButton);
        viewButton.setBounds(930, 250, 190, 40);

        deleteButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        deleteButton.setText("DELETE FIELD");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(930, 200, 190, 40);

        buyButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        buyButton.setText("BUY");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buyButton);
        buyButton.setBounds(1040, 660, 120, 40);

        totalText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        totalText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTextActionPerformed(evt);
            }
        });
        getContentPane().add(totalText);
        totalText.setBounds(1020, 570, 110, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("TL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1170, 580, 50, 30);

        ID_label.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        ID_label.setText("ID:");
        getContentPane().add(ID_label);
        ID_label.setBounds(570, 310, 40, 40);

        sortPriceButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        sortPriceButton.setText("SORT PRICE ASC");
        sortPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortPriceButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sortPriceButton);
        sortPriceButton.setBounds(1020, 440, 210, 40);

        sortPriceButtonDesc.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        sortPriceButtonDesc.setText("SORT PRICE DESC");
        sortPriceButtonDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortPriceButtonDescActionPerformed(evt);
            }
        });
        getContentPane().add(sortPriceButtonDesc);
        sortPriceButtonDesc.setBounds(1020, 500, 210, 40);

        idText.setOpaque(false);
        getContentPane().add(idText);
        idText.setBounds(630, 310, 210, 30);

        mainButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        mainButton.setText("GO MAIN PAGE");
        mainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mainButton);
        mainButton.setBounds(60, 40, 230, 60);

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\bmetin\\Desktop\\SOFTWARE_PROJECT_COSMETIC\\software_database_images\\back3.jpg")); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1300, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        model = (DefaultTableModel) listTable.getModel();
        model.addRow(new Object[]{productNameText.getText(), brandIdText.getText(),priceText.getText()});
        
        String searchQuery = "INSERT INTO BASKET(P_NAME,BRAND_ID,PRICE,ID) VALUES('"+productNameText.getText()+"','"+brandIdText.getText()+"','"+priceText.getText()+"','"+idText.getText()+"') ";
        
        addBasket(searchQuery);
    
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SecondFrame sf = new SecondFrame();
        sf.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
  
        String searchQuery = "SELECT * FROM BASKET";
        findBasket(searchQuery);
        
        totalText.setText(Integer.toString(getSum(rowsCount)));
     
    }//GEN-LAST:event_viewButtonActionPerformed

    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       
        //AND ID='"+idText.getText()+"'
        String searchQuery = "DELETE FROM BASKET WHERE P_NAME= '"+productNameText.getText()+"' AND PRICE ='"+priceText.getText()+"' AND BRAND_ID='"+brandIdText.getText()+"'AND ID='"+idText.getText()+"' ";
        findBasket_delete(searchQuery);
           
        String searchQuery2 = "SELECT * FROM BASKET";
        findBasket(searchQuery2);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void listTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableMouseClicked
        
        int i = listTable.getSelectedRow();
        TableModel model = listTable.getModel();
        
        productNameText.setText(model.getValueAt(i, 0).toString());
        brandIdText.setText(model.getValueAt(i, 1).toString());
        priceText.setText(model.getValueAt(i, 2).toString());
        idText.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_listTableMouseClicked

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        BuyFrame buyF = new BuyFrame(totalText.getText());
        buyF.setVisible(true);
    }//GEN-LAST:event_buyButtonActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void productNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTextActionPerformed

    private void sortPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortPriceButtonActionPerformed
        
        String searchQuery = " SELECT * FROM BASKET ORDER BY PRICE ASC ";
        
        findBasket(searchQuery);
        
       
    }//GEN-LAST:event_sortPriceButtonActionPerformed

    private void sortPriceButtonDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortPriceButtonDescActionPerformed
        String searchQuery2 = " SELECT * FROM BASKET ORDER BY PRICE DESC ";
        
        findBasket(searchQuery2);
    }//GEN-LAST:event_sortPriceButtonDescActionPerformed

    private void totalTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTextActionPerformed
        
    }//GEN-LAST:event_totalTextActionPerformed

    private void mainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainButtonActionPerformed
        SecondFrame sF = new SecondFrame();
        sF.setVisible(true);
    }//GEN-LAST:event_mainButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BasketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasketFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_label;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane basketTable;
    private javax.swing.JLabel brandIdLabel;
    public javax.swing.JTextField brandIdText;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable listTable;
    private javax.swing.JButton mainButton;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JLabel priceLabel;
    public javax.swing.JTextField priceText;
    private javax.swing.JLabel productNameLabel;
    public javax.swing.JTextField productNameText;
    private javax.swing.JButton sortPriceButton;
    private javax.swing.JButton sortPriceButtonDesc;
    private javax.swing.JLabel title;
    private javax.swing.JTextField totalText;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
