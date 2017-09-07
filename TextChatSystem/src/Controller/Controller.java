
package Controller;

import GUI.*;
import Action.*;
import DBContext.DBModel;
import FileIO.FileController;
import Networking.*;

public class Controller {
    private FileController fc;
    
    public Server server;
    public Client client;
    public ServerListIn upd_in;
    public ServerListOut upd_out;
    
    private Login vLogin;
    private Register vRegister;
    private ListUser vListUser;
    
    private DBModel data;
    
    public static void main(String[] args) {
        new Controller().init();
    }
    
    private void init() {
      data = new DBModel();
      fc = new FileController();
      
      setupComponents();
      setupNetworks();
      
      vLogin.setVisible(true);
    }
    
    public void setupNetworks() {
        upd_in = new ServerListIn();
        upd_out = new ServerListOut();
        client = new Client();
        server = new Server();
    }
    
    private void setupComponents() {
        vLogin = new Login();
        vRegister = new Register();
        vListUser = new ListUser();
        
        // set up event listeners for each buttons
        vLogin.getButton_login().addActionListener(new LoginButtonSubmit(this));
        vLogin.getButton_cancel().addActionListener(new LoginButtonCancel(this));
        vLogin.getButton_register().addActionListener(new LoginButtonRegister(this));
        
        vRegister.getButton_cancle().addActionListener(new RegisterButtonCancel(this));
        vRegister.getButton_register().addActionListener(new RegisterButtonSubmit(this));
    }

    public Login getvLogin() {
        return vLogin;
    }

    public Register getvRegister() {
        return vRegister;
    }

    public ListUser getvListUser() {
        return vListUser;
    }
    
    public DBModel getData() {
        return data;
    }
    
}


