import com.entities.Kelengkeng;
import com.impl.KelengkengImpl;
import com.menu.Menus;
import com.util.ConnectionConfig;
import java.sql.Connection;

public class Main{
    public static void main(String[] args){
        Menus menus = new Menus();
        Kelengkeng kelengkeng =new Kelengkeng();
//        KelengkengImpl create = new KelengkengImpl();
//        create.createTableTransaksi();
        try {
            menus.loginAdmin();
            menus.MainMenu();;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}